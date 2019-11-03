package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IIdAuthOrderExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;

import java.util.List;

public interface IIdAuthOrderDbService {
    IIdAuthOrder create(IIdAuthOrder order);

    Integer countTeacherOrders();

    List<IIdAuthOrderExtra> getTeacherOrders();

    Integer countParentOrders(List<Long> classIds);

    List<IIdAuthOrderExtra> getParentOrders(List<Long> classIds);

    IIdAuthOrderExtra get(Long id);

    void changeStatus(Long orderId, Integer status);
}
