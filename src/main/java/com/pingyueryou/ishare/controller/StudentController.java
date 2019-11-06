package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IStudentDbService;
import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;
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
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private IStudentDbService iStudentDbService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody IStudent student) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        Long classId = student.getClassId();
        String name = student.getName();
        if (classId == null || XStringUtils.isEmpty(name)) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IStudent iStudent = iStudentDbService.create(student);
        return XResponse.ok(iStudent);
    }

    @RequestMapping(path = "/{studentId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable(value = "studentId") Long studentId) {
        IStudent iStudent = iStudentDbService.get(studentId);
        return XResponse.ok(iStudent);
    }

    @RequestMapping(path = "/{studentId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable(value = "studentId") Long studentId, @RequestBody IStudent student) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isTeacher()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        IStudent update = iStudentDbService.update(studentId, student);
        return XResponse.ok(update);
    }

    @RequestMapping(path = "/by-class-id/{classId}", method = RequestMethod.GET)
    public ResponseEntity getByClassId(@PathVariable(value = "classId") Long classId) {
        List<IStudent> students = iStudentDbService.getByClassId(classId);
        return XResponse.ok(students);
    }

    @RequestMapping(path = "/my", method = RequestMethod.GET)
    public ResponseEntity getMy() {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isParent()) {
            return XResponse.ok(new ArrayList<IStudent>());
        }
        List<IStudent> byUserId = iStudentDbService.getByUserId(currentUser.getId());
        return XResponse.ok(byUserId);
    }
}
