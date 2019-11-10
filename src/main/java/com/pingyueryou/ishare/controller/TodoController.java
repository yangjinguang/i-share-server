package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.IIdAuthOrderDbService;
import com.pingyueryou.ishare.dbservice.IItemLendOrderDbService;
import com.pingyueryou.ishare.entity.*;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.XResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private IIdAuthOrderDbService iIdAuthOrderDbService;
    @Autowired
    private IItemLendOrderDbService iItemLendOrderDbService;
    @Autowired
    private IClassDbService iClassDbService;
    @Autowired
    private UserService userService;

    @RequestMapping("/count")
    public ResponseEntity countMy() {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        Integer count = 0;
        if (currentUser.isAdmin()) {
            count += iIdAuthOrderDbService.countTeacherOrders();
        }
        if (currentUser.isTeacher()) {
            List<Long> classIds = userService.getClassIds(userId);
            count += iIdAuthOrderDbService.countParentOrders(classIds, IdAuthOrderStatus.NEW);
            ArrayList<Integer> statusList = new ArrayList<>();
            statusList.add(ItemLendOrderStatus.NEW.getIndex());
            statusList.add(ItemLendOrderStatus.IN_RETURN.getIndex());
            count += iItemLendOrderDbService.countByClassIds(classIds, statusList);
        }
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("count", count);
        return XResponse.ok(stringIntegerHashMap);
    }

    @RequestMapping("")
    public ResponseEntity list() {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        List<IIdAuthOrderExtra> iIdAuthOrders = new ArrayList<>();
        List<IItemLendOrderExtra> iItemLendOrders = new ArrayList<>();
        if (currentUser.isAdmin()) {
            List<IIdAuthOrderExtra> orders = iIdAuthOrderDbService.getTeacherOrders();
            iIdAuthOrders.addAll(orders);
        }
        if (currentUser.isTeacher()) {
            List<Long> classIds = userService.getClassIds(userId);
            List<IIdAuthOrderExtra> orders = iIdAuthOrderDbService.getParentOrders(classIds, IdAuthOrderStatus.NEW);
            iIdAuthOrders.addAll(orders);
            ArrayList<Integer> statusList = new ArrayList<>();
            statusList.add(ItemLendOrderStatus.NEW.getIndex());
            statusList.add(ItemLendOrderStatus.IN_RETURN.getIndex());
            iItemLendOrders = iItemLendOrderDbService.getByClassIds(classIds, statusList);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("itemLendOrders", iItemLendOrders);
        map.put("idAuthOrders", iIdAuthOrders);
        return XResponse.ok(map);
    }
}
