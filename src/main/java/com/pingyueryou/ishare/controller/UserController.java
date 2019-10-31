package com.pingyueryou.ishare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity auth() {
        return ResponseEntity.ok("ok");
    }
}
