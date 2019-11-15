package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.entity.IClassExtra;
import com.pingyueryou.ishare.entity.IGradeExtra;
import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IGrade;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private IClassDbService iClassDbService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity crate(@RequestBody IClass body) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isAdmin()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        IClass iClass = new IClass();
        Long gradeId = body.getGradeId();
        IGrade grade = iClassDbService.getGrade(gradeId);
        if (grade == null) {
            return XResponse.errorCode(ErrorCode.GRADE_NOT_FOUND);
        }
        String name = body.getName();
        if (XStringUtils.isEmpty(name)) {
            return XResponse.errorCode(ErrorCode.CLASS_NAME_EMPTY);
        }
        iClass.setGradeId(gradeId);
        iClass.setName(body.getName());

        IClass resIClass = iClassDbService.create(iClass);

        return XResponse.ok(resIClass);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<IClassExtra> all = iClassDbService.getAll();
        return XResponse.ok(all);
    }

    @RequestMapping(path = "/my", method = RequestMethod.GET)
    public ResponseEntity getMyClass() {
        IUserExtra currentUser = userService.getCurrentUser();
        List<IClassExtra> byUserId = iClassDbService.getByUserId(currentUser.getId());
        return XResponse.ok(byUserId);
    }

    @RequestMapping(path = "/{classId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable(value = "classId") Long classId) {
        IClass iClass = iClassDbService.get(classId);
        return XResponse.ok(iClass);
    }

    @RequestMapping(path = "/{classId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable(value = "classId") Long classId, @RequestBody IClass iClass) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isAdmin()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        IClass update = iClassDbService.update(classId, iClass);
        return XResponse.ok(update);
    }

    @RequestMapping(path = "/byGradeId/{gradeId}", method = RequestMethod.GET)
    public ResponseEntity getByGradeId(@PathVariable(value = "gradeId") Long gradeId) {
        List<IClass> byGradeId = iClassDbService.getByGradeId(gradeId);
        return XResponse.ok(byGradeId);
    }

    @RequestMapping(path = "/{classId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "classId") Long classId) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isAdmin()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        iClassDbService.delete(classId);
        return XResponse.ok("success");
    }

    @RequestMapping(path = "/tree", method = RequestMethod.GET)
    public ResponseEntity tree() {
        List<IGrade> allGrade = iClassDbService.getAllGrade();
        ArrayList<IGradeExtra> iGradeExtras = new ArrayList<>();
        for (IGrade iGrade : allGrade) {
            List<IClass> byGradeId = iClassDbService.getByGradeId(iGrade.getId());
            IGradeExtra iGradeExtra = new IGradeExtra(iGrade, byGradeId);
            iGradeExtras.add(iGradeExtra);
        }
        return XResponse.ok(iGradeExtras);
    }

    @RequestMapping(path = "/order", method = RequestMethod.PUT)
    public ResponseEntity order(@RequestBody List<Long> classIds) {
        IUserExtra currentUser = userService.getCurrentUser();
        if (!currentUser.isAdmin()) {
            return XResponse.errorCode(ErrorCode.FORBIDDEN);
        }
        for (int i = 0; i < classIds.size(); i++) {
            Long classId = classIds.get(i);
            iClassDbService.updateOrder(classId, i);
        }
        return XResponse.ok("success");
    }

}
