package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IIdAuthOrderDbService;
import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.entity.IdAuthHandleBody;
import com.pingyueryou.ishare.entity.IdAuthOrderStatus;
import com.pingyueryou.ishare.entity.Role;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private IIdAuthOrderDbService iIdAuthOrderDbService;

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public ResponseEntity profile() {
        IUser user = userService.getCurrentUser();
        return XResponse.ok(user);
    }

    @RequestMapping(path = "/id-auth", method = RequestMethod.POST)
    public ResponseEntity idAuth(@RequestBody IIdAuthOrder body) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long classId = body.getClassId();
        Integer role = body.getRole();
        String childName = body.getChildName();
        String relation = body.getRelation();
        if (classId == null || role == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        if (role.equals(Role.PARENT.getIndex())) {
            if (XStringUtils.isEmpty(childName) || XStringUtils.isEmpty(relation)) {
                return XResponse.errorCode(ErrorCode.PARAM_ERROR);
            }
        }
        IIdAuthOrder order = new IIdAuthOrder();
        order.setUserId(currentUser.getId());
        order.setRole(role);
        order.setClassId(classId);
        order.setChildName(childName);
        order.setRelation(relation);
        iIdAuthOrderDbService.create(order);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "/id-auth/handle", method = RequestMethod.PUT)
    public ResponseEntity idAuthHandle(@RequestBody IdAuthHandleBody body) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long orderId = body.getOrderId();
        boolean agree = body.isAgree();
        Long studentId = body.getStudentId();
        if (orderId == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IIdAuthOrder iIdAuthOrder = iIdAuthOrderDbService.get(orderId);
        if (iIdAuthOrder == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        Long userId = iIdAuthOrder.getUserId();
        Integer role = iIdAuthOrder.getRole();
        if (role.equals(Role.TEACHER.getIndex())) {
            if (!currentUser.isAdmin()) {
                return XResponse.errorCode(ErrorCode.FORBIDDEN);
            }
            if (agree) {
                userService.joinClass(userId, iIdAuthOrder.getClassId());
                userService.addRole(userId, Role.TEACHER.getIndex());
                iIdAuthOrderDbService.changeStatus(orderId, IdAuthOrderStatus.AGREE.getIndex());
            } else {
                iIdAuthOrderDbService.changeStatus(orderId, IdAuthOrderStatus.REJECT.getIndex());
            }
        } else if (role.equals(Role.PARENT.getIndex())) {
            if (!currentUser.isTeacher()) {
                return XResponse.errorCode(ErrorCode.FORBIDDEN);
            }
            if (studentId == null) {
                return XResponse.errorCode(ErrorCode.PARAM_ERROR);
            }
            if (agree) {
                userService.bindStudent(iIdAuthOrder.getUserId(), studentId);
                userService.addRole(userId, Role.PARENT.getIndex());
                iIdAuthOrderDbService.changeStatus(orderId, IdAuthOrderStatus.AGREE.getIndex());
            } else {
                iIdAuthOrderDbService.changeStatus(orderId, IdAuthOrderStatus.REJECT.getIndex());
            }
        }
        return XResponse.ok("success");
    }
}
