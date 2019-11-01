package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.impl.IClassDbServiceImpl;
import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IGrade;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private IClassDbService iClassDbService;


    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity crate(@RequestBody IGrade body) {
        IGrade iGrade = new IGrade();
        String name = body.getName();
        if (!XStringUtils.isEmpty(name)) {
            return XResponse.errorCode(ErrorCode.CLASS_NAME_EMPTY);
        }
        iGrade.setName(body.getName());
        IGrade resIGrade = iClassDbService.createGrade(iGrade);

        return XResponse.ok(resIGrade);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<IGrade> allGrade = iClassDbService.getAllGrade();
        return XResponse.ok(allGrade);
    }

    @RequestMapping(path = "/{gradeId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "gradeId") Long gradeId) {
        iClassDbService.deleteGrade(gradeId);
        return XResponse.ok("success");
    }


}
