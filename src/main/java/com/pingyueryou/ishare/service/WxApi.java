package com.pingyueryou.ishare.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pingyueryou.ishare.entity.WxSessionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;

@Service
public class WxApi {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.secret}")
    private String secret;

    private <T> T jsonToObject(String body, Class<T> classType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return objectMapper.readValue(body, classType);
    }

    public WxSessionResponse code2Session(String code) throws JsonProcessingException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        HashMap<String, String> params = new HashMap<>();
        params.put("1", appId);
        params.put("2", secret);
        params.put("3", code);
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session?appid={1}&secret={2}&js_code={3}&grant_type=authorization_code", String.class, params);
        return jsonToObject(response.getBody(), WxSessionResponse.class);
    }
}
