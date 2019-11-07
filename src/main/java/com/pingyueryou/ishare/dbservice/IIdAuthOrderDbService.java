package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IIdAuthOrderExtra;
import com.pingyueryou.ishare.entity.IdAuthOrderStatus;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;

import java.util.List;

public interface IIdAuthOrderDbService {
    IIdAuthOrder create(IIdAuthOrder order);

    Integer countTeacherOrders();

    List<IIdAuthOrderExtra> getTeacherOrders();

    Integer countParentOrders(List<Long> classIds, IdAuthOrderStatus status);

    List<IIdAuthOrderExtra> getParentOrders(List<Long> classIds, IdAuthOrderStatus status);

    IIdAuthOrderExtra get(Long id);

    void changeStatus(Long orderId, Integer status);
}
