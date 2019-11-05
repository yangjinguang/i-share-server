package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.service.QiniuClient;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QiniuClientImpl implements QiniuClient {
    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.domain}")
    private String domain;

    @Override
    public String uploadToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }

    @Override
    public String downloadUrl(String baseUrl) {
        return "http://" + this.domain + "/" + baseUrl;
    }
}
