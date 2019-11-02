package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;

import java.util.List;

public interface IItemLendOrderDbService {
    IItemLendOrder create(IItemLendOrder order);

    Integer countByClassId(Long classId);

    List<IItemLendOrder> getByClassIds(List<Long> classIds);
}
