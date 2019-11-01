package com.pingyueryou.ishare.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pingyueryou.ishare.dbservice.IUserDbService;
import com.pingyueryou.ishare.entity.LoginBody;
import com.pingyueryou.ishare.entity.WxSessionResponse;
import com.pingyueryou.ishare.entity.WxUserInfo;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.security.JwtTokenUtil;
import com.pingyueryou.ishare.security.UserDetailsServiceImpl;
import com.pingyueryou.ishare.security.UserEntity;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.WxApi;
import com.pingyueryou.ishare.utils.XResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;
    @Autowired
    private IUserDbService iUserDbService;
    @Autowired
    private WxApi wxApi;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity auth(@RequestBody LoginBody body) throws JsonProcessingException {
        WxSessionResponse wxSessionResponse = wxApi.code2Session(body.getCode());
        WxUserInfo userInfo = body.getUserInfo();
        IUser iUser = new IUser();
        iUser.setOpenId(wxSessionResponse.getOpenid());
        iUser.setUnionId(wxSessionResponse.getUnionid());
        iUser.setNickName(userInfo.getNickName());
        iUser.setAvatarUrl(userInfo.getAvatarUrl());
        iUser.setGender(userInfo.getGender());
        IUser xIUser = userService.updateByOpenId(iUser.getOpenId(), iUser);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(xIUser.getId());
        userEntity.setUsername(xIUser.getOpenId());
        String token = jwtTokenUtil.generateToken(userEntity);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("accessToken", token);
        stringObjectHashMap.put("profile", xIUser);
        return XResponse.ok(stringObjectHashMap);
    }

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public ResponseEntity profile() {
        IUser user = userService.getCurrentUser();
        return XResponse.ok(user);
    }
}
