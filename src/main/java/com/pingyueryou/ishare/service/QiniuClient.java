package com.pingyueryou.ishare.service;

public interface QiniuClient {
    String uploadToken();

    String downloadUrl(String baseUrl);
}
