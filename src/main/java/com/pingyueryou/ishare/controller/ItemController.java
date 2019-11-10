package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.dbservice.IItemLendOrderDbService;
import com.pingyueryou.ishare.dbservice.IStudentDbService;
import com.pingyueryou.ishare.entity.*;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;
import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;
import com.pingyueryou.ishare.service.ItemService;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private IItemDbService iItemDbService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private IItemLendOrderDbService iItemLendOrderDbService;
    @Autowired
    private IClassDbService iClassDbService;
    @Autowired
    private IStudentDbService iStudentDbService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody IItemCreateData createData) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        createData.setUploadUserId(currentUser.getId());
        IItem iItem = iItemDbService.create(createData);
        return XResponse.ok(iItem);
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable(value = "itemId") Long itemId) {
        IItemExtra detail = itemService.detail(itemId);
        return XResponse.ok(detail);
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable(value = "itemId") Long itemId,
                                 @RequestBody IItemCreateData createData) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        createData.setUploadUserId(currentUser.getId());
        IItem iItem = iItemDbService.update(itemId, createData);
        return XResponse.ok(iItem);
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "itemId") Long itemId) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        iItemDbService.delete(itemId);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "/tag", method = RequestMethod.POST)
    public ResponseEntity createTag(@RequestBody IItemTag tag) {
        String name = tag.getName();
        if (XStringUtils.isEmpty(name)) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IItemTag tag1 = iItemDbService.createTag(tag);
        return XResponse.ok(tag1);
    }

    @RequestMapping(path = "/tag", method = RequestMethod.GET)
    public ResponseEntity getTags() {
        List<IItemTag> tags = iItemDbService.getTags();
        return XResponse.ok(tags);
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.GET)
    public ResponseEntity getTag(@PathVariable(value = "tagId") Long tagId) {
        IItemTag tag = iItemDbService.getTag(tagId);
        return XResponse.ok(tag);
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.PUT)
    public ResponseEntity updateTag(@PathVariable(value = "tagId") Long tagId,
                                    @RequestBody IItemTag tag) {
        IItemTag iItemTag = iItemDbService.updateTag(tagId, tag);
        return XResponse.ok(iItemTag);
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTag(@PathVariable(value = "tagId") Long tagId) {
        iItemDbService.deleteTag(tagId);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity search(@RequestParam(value = "s") String s) {
        List<IItem> search = iItemDbService.search(s);
        return XResponse.ok(search);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity query(@RequestParam(value = "classId", required = false) Long classId,
                                @RequestParam(value = "tagId", required = false) Long tagId,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Integer offset = page - 1;
        ArrayList<Long> classIds = new ArrayList<>();
        if (classId != null) {
            classIds.add(classId);
        } else {
            classIds = null;
        }
        Integer total = iItemDbService.count(classIds, tagId);
        List<IItem> query = iItemDbService.query(classIds, tagId, offset, size);
        itemService.serialize(query);
        return XResponse.ok(new Pagination(page, total, size), query);
    }

    @RequestMapping(path = "mgr", method = RequestMethod.GET)
    public ResponseEntity queryMgr(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Integer offset = page - 1;
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        List<Long> classIds = userService.getClassIds(currentUser.getId());
        Integer total = iItemDbService.count(classIds, null);
        List<IItem> query = iItemDbService.query(classIds, null, offset, size);
        itemService.serialize(query);
        return XResponse.ok(new Pagination(page, total, size), query);
    }

    @RequestMapping(path = "lend", method = RequestMethod.PUT)
    public ResponseEntity lend(@RequestBody ItemLendOrderBody orderBody) {
        Long itemId = orderBody.getItemId();
        Long studentId = orderBody.getStudentId();
        if (itemId == null || studentId == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IUserExtra currentUser = userService.getCurrentUser();
        itemService.lendOrder(itemId, currentUser.getId(), studentId);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "lend/detail/{orderId}", method = RequestMethod.GET)
    public ResponseEntity lendDetail(@PathVariable(value = "orderId") Long orderId) {
        IItemLendOrderExtra iItemLendOrderExtra = iItemLendOrderDbService.get(orderId);
        if (iItemLendOrderExtra == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IItemExtra iItemExtra = iItemDbService.get(iItemLendOrderExtra.getItemId());
        iItemLendOrderExtra.setiItem(iItemExtra);
        IClassExtra iClassExtra = iClassDbService.get(iItemLendOrderExtra.getClassId());
        iItemLendOrderExtra.setiClass(iClassExtra);
        IStudent iStudent = iStudentDbService.get(iItemLendOrderExtra.getStudentId());
        if (iStudent != null) {
            IClassExtra studentClass = iClassDbService.get(iStudent.getClassId());
            iItemLendOrderExtra.setStudentClass(studentClass);
        }
        iItemLendOrderExtra.setiStudent(iStudent);
        return XResponse.ok(iItemLendOrderExtra);
    }

    @RequestMapping(path = "lend/handle", method = RequestMethod.PUT)
    public ResponseEntity lendHandle(@RequestBody ItemLendOrderStatusBody body) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        Long orderId = body.getOrderId();
        Boolean agree = body.getAgree();
        if (orderId == null || agree == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }

        itemService.lendOrderHandle(orderId, agree);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "lend/my", method = RequestMethod.GET)
    public ResponseEntity getMyLendOrders(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "page", defaultValue = "20") Integer size) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        List<Integer> statusList = new ArrayList<>();
        if (!XStringUtils.isEmpty(status)) {
            String[] statusArr = status.split(",");
            for (String s : statusArr) {
                statusList.add(Integer.parseInt(s));
            }
        }
        PaginationList<IItemLendOrderExtra> lendOrdersByUserId = itemService.getLendOrdersByUserId(userId, statusList, page, size);
        return XResponse.ok(lendOrdersByUserId);
    }

    @RequestMapping(path = "lend/return/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity lendReturn(@PathVariable(value = "orderId") Long orderId) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        IItemLendOrderExtra iItemLendOrderExtra = iItemLendOrderDbService.get(orderId);
        if (!iItemLendOrderExtra.getUserId().equals(userId)) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        iItemLendOrderDbService.changeStatus(orderId, ItemLendOrderStatus.IN_RETURN);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "lend/cancel/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity lendCancel(@PathVariable(value = "orderId") Long orderId) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        IItemLendOrderExtra iItemLendOrderExtra = iItemLendOrderDbService.get(orderId);
        if (!iItemLendOrderExtra.getUserId().equals(userId)) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        if (!iItemLendOrderExtra.getStatus().equals(ItemLendOrderStatus.NEW.getIndex())) {
            return XResponse.errorCode(ErrorCode.LEND_CANCEL_STATUS_NOT_MATCH);
        }
        iItemLendOrderDbService.changeStatus(orderId, ItemLendOrderStatus.CANCELED);
        iItemDbService.changeStatus(iItemLendOrderExtra.getItemId(), ItemStatus.NORMAL);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "lend/delete/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity lendDelete(@PathVariable(value = "orderId") Long orderId) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        IItemLendOrderExtra iItemLendOrderExtra = iItemLendOrderDbService.get(orderId);
        if (!iItemLendOrderExtra.getUserId().equals(userId)) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        if (!iItemLendOrderExtra.getStatus().equals(ItemLendOrderStatus.CANCELED.getIndex())) {
            return XResponse.errorCode(ErrorCode.LEND_CANCEL_STATUS_NOT_MATCH);
        }
        iItemLendOrderDbService.changeStatus(orderId, ItemLendOrderStatus.DELETED);
        return XResponse.ok("success");
    }
}
