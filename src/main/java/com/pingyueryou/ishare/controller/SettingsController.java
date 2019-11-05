package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.service.QiniuClient;
import com.pingyueryou.ishare.utils.XResponse;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    @Autowired
    private QiniuClient qiniuClient;

    @RequestMapping(path = "upload-token", method = RequestMethod.GET)
    public ResponseEntity getUploadToken() {
        return XResponse.ok(qiniuClient.uploadToken());
    }
}
