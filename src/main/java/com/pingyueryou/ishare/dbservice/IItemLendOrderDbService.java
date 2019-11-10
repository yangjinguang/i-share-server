package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IItemLendOrderExtra;
import com.pingyueryou.ishare.entity.ItemLendOrderStatus;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;

import java.util.List;

public interface IItemLendOrderDbService {
    IItemLendOrder create(IItemLendOrder order);

    Integer countByClassId(Long classId, List<Integer> statusList);

    Integer countByClassIds(List<Long> classIds, List<Integer> statusList);

    List<IItemLendOrderExtra> getByClassIds(List<Long> classIds, List<Integer> statusList);

    IItemLendOrderExtra get(Long orderId);

    void changeStatus(Long orderId, ItemLendOrderStatus status);

    Integer countByUserId(Long userId, List<Integer> statusList);

    List<IItemLendOrderExtra> queryByUserId(Long userId, List<Integer> statusList, Integer offset, Integer size);
}
