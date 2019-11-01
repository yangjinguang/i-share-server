package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IGrade;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private IClassDbService iClassDbService;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity crate(@RequestBody IClass body) {
        IClass iClass = new IClass();
        Long gradeId = body.getGradeId();
        IGrade grade = iClassDbService.getGrade(gradeId);
        if (grade == null) {
            return XResponse.errorCode(ErrorCode.GRADE_NOT_FOUND);
        }
        String name = body.getName();
        if (!XStringUtils.isEmpty(name)) {
            return XResponse.errorCode(ErrorCode.CLASS_NAME_EMPTY);
        }
        iClass.setGradeId(gradeId);
        iClass.setName(body.getName());

        IClass resIClass = iClassDbService.create(iClass);

        return XResponse.ok(resIClass);
    }

    @RequestMapping(path = "/byGrade/{gradeId}", method = RequestMethod.GET)
    public ResponseEntity getByGradeId(@PathVariable(value = "gradeId") Long gradeId) {
        List<IClass> byGradeId = iClassDbService.getByGradeId(gradeId);
        return XResponse.ok(byGradeId);
    }

    @RequestMapping(path = "/{classId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "classId") Long classId) {
        iClassDbService.delete(classId);
        return XResponse.ok("success");
    }

}
