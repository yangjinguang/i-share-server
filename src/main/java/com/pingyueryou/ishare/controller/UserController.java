package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.IIdAuthOrderDbService;
import com.pingyueryou.ishare.entity.*;
import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private IIdAuthOrderDbService iIdAuthOrderDbService;
    @Autowired
    private IClassDbService iClassDbService;

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public ResponseEntity profile() {
        IUserExtra user = userService.getCurrentUser();
        List<IClassExtra> classes = iClassDbService.getByUserId(user.getId());
        user.setClasses(classes);
        return XResponse.ok(user);
    }

    @RequestMapping(path = "/id-auth", method = RequestMethod.POST)
    public ResponseEntity idAuth(@RequestBody IIdAuthOrder body) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long classId = body.getClassId();
        Integer role = body.getRole();
        String studentName = body.getStudentName();
        String relation = body.getRelation();
        if (classId == null || role == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        if (role.equals(Role.PARENT.getIndex())) {
            if (XStringUtils.isEmpty(studentName) || XStringUtils.isEmpty(relation)) {
                return XResponse.errorCode(ErrorCode.PARAM_ERROR);
            }
        }
        IIdAuthOrder order = new IIdAuthOrder();
        order.setUserId(currentUser.getId());
        order.setRole(role);
        order.setClassId(classId);
        order.setStudentName(studentName);
        order.setRelation(relation);
        iIdAuthOrderDbService.create(order);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "/id-auth/{orderId}", method = RequestMethod.GET)
    public ResponseEntity idAuthDetail(@PathVariable(value = "orderId") Long orderId) {
        IIdAuthOrderExtra iIdAuthOrder = iIdAuthOrderDbService.get(orderId);
        IClassExtra iClassExtra = iClassDbService.get(iIdAuthOrder.getClassId());
        iIdAuthOrder.setiClass(iClassExtra);
        return XResponse.ok(iIdAuthOrder);
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

    @RequestMapping(path = "unbind-class", method = RequestMethod.PUT)
    public ResponseEntity unbindClass(@RequestBody UnbindClassBody body) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = body.getUserId();
        Long classId = body.getClassId();
        if (userId == null || classId == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        if (!currentUser.isAdmin() && !currentUser.getId().equals(body.getUserId())) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        userService.leaveClass(userId, classId);
        Integer count = userService.countClassByUserId(userId);
        if (count <= 0) {
            userService.rmRole(userId, Role.TEACHER.getIndex());
        }
        return XResponse.ok("success");
    }

    @RequestMapping(path = "unbind-student", method = RequestMethod.PUT)
    public ResponseEntity unbindStudent(@RequestBody UnbindStudentBody body) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = body.getUserId();
        Long studentId = body.getStudentId();
        if (userId == null || studentId == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        if (!currentUser.isAdmin() && !currentUser.getId().equals(body.getUserId())) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        userService.unbindStudent(userId, studentId);
        Integer count = userService.countStudentByUserId(userId);
        if (count <= 0) {
            userService.rmRole(userId, Role.PARENT.getIndex());
        }
        return XResponse.ok("success");
    }
}
