package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IItemLendOrderExtra;
import com.pingyueryou.ishare.entity.ItemLendOrderStatus;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;

import java.util.List;

public interface IItemLendOrderDbService {
    IItemLendOrder create(IItemLendOrder order);

    Integer countByClassId(Long classId,ItemLendOrderStatus status);

    Integer countByClassIds(List<Long> classIds,ItemLendOrderStatus status);

    List<IItemLendOrderExtra> getByClassIds(List<Long> classIds, ItemLendOrderStatus status);

    IItemLendOrderExtra get(Long orderId);

    void changeStatus(Long orderId, ItemLendOrderStatus status);

}
