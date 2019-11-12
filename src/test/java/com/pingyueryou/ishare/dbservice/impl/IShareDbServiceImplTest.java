package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.entity.IShareExtra;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class IShareDbServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private IShareDbServiceImpl iShareDbService;

    @Test
    void popularByItemId() {
        List<IShareExtra> iShareExtras = iShareDbService.popularByItemId(1L, 0, 20);
        logger.info("success");
    }
}