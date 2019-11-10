package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.entity.IItemLendOrderExtra;
import com.pingyueryou.ishare.entity.PaginationList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ItemServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private ItemServiceImpl itemService;

    @Test
    void serialize() {
    }

    @Test
    void detail() {
    }

    @Test
    void lendOrder() {
    }

    @Test
    void getLendOrdersByUserId() {
        ArrayList<Integer> statusList = new ArrayList<>();
        statusList.add(1);
        PaginationList<IItemLendOrderExtra> lendOrdersByUserId = itemService.getLendOrdersByUserId(1L, statusList, 1, 20);
        logger.info(lendOrdersByUserId.toString());
    }
}
