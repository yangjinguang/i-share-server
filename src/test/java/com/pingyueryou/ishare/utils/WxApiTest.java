package com.pingyueryou.ishare.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pingyueryou.ishare.entity.WxSessionResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class WxApiTest {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private WxApi wxApi;

    @Test
    void code2Session() throws JsonProcessingException {
        WxSessionResponse session = wxApi.code2Session("xxxx");
        logger.info(session.getErrmsg());
    }
}
