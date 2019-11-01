package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IIdAuthOrderDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.XResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private IIdAuthOrderDbService iIdAuthOrderDbService;


    @RequestMapping(path = "/id-auth", method = RequestMethod.POST)
    public ResponseEntity idAuth(@RequestBody IIdAuthOrder body) {
        IUser currentUser = userService.getCurrentUser();
        body.setUserId(currentUser.getId());
        iIdAuthOrderDbService.create(body);
        return XResponse.ok("success");
    }
}
