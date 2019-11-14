package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IIndexBannerDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner;
import com.pingyueryou.ishare.service.QiniuClient;
import com.pingyueryou.ishare.utils.XResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    @Autowired
    private QiniuClient qiniuClient;
    @Autowired
    private IIndexBannerDbService iIndexBannerDbService;

    @RequestMapping(path = "upload-token", method = RequestMethod.GET)
    public ResponseEntity getUploadToken() {
        return XResponse.ok(qiniuClient.uploadToken());
    }

    @RequestMapping(path = "banner", method = RequestMethod.GET)
    public ResponseEntity getBanners() {
        List<IIndexBanner> all = iIndexBannerDbService.getAll();
        return XResponse.ok(all);
    }

    @RequestMapping(path = "banner", method = RequestMethod.PUT)
    public ResponseEntity bannerUpdate(@RequestBody List<String> images) {
        iIndexBannerDbService.deleteAll();
        for (String image : images) {
            IIndexBanner banner = new IIndexBanner();
            banner.setImageUrl(image);
            iIndexBannerDbService.create(banner);
        }
        return XResponse.ok("success");
    }
}
