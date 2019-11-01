package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;
import com.pingyueryou.ishare.utils.XResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody IStudent student) {
        return XResponse.ok("success");
    }
}
