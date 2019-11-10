package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.entity.IItemLendOrderExtra;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class IItemLendOrderDbServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private IItemLendOrderDbServiceImpl iItemLendOrderDbService;

    @Test
    void create() {
    }

    @Test
    void countByClassId() {
    }

    @Test
    void countByClassIds() {
    }

    @Test
    void getByClassIds() {
    }

    @Test
    void get() {
    }

    @Test
    void changeStatus() {
    }

    @Test
    void countByUserId() {
    }

    @Test
    void queryByUserId() {
        ArrayList<Integer> statusList = new ArrayList<>();
        statusList.add(1);
        List<IItemLendOrderExtra> orders = iItemLendOrderDbService.queryByUserId(1L, statusList, 0, 20);
        logger.info(orders.toString());
    }
}
