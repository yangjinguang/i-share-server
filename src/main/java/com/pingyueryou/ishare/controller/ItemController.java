package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.entity.IItemCreateData;
import com.pingyueryou.ishare.entity.IItemExtra;
import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.entity.Pagination;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;
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

    @RequestMapping(path = "/mgr", method = RequestMethod.GET)
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
}
