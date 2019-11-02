package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IItemLendOrderDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;
import com.pingyueryou.ishare.jooq.tables.records.IItemLendOrderRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IItemLendOrder.I_ITEM_LEND_ORDER;

@Service
public class IItemLendOrderDbServiceImpl implements IItemLendOrderDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IItemLendOrder create(IItemLendOrder order) {
        IItemLendOrderRecord iItemLendOrderRecord = context.newRecord(I_ITEM_LEND_ORDER, order);
        return iItemLendOrderRecord.into(IItemLendOrder.class);
    }

    @Override
    public Integer countByClassId(Long classId) {
        return context.selectCount().from(I_ITEM_LEND_ORDER)
                .where(I_ITEM_LEND_ORDER.CLASS_ID.eq(classId))
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public List<IItemLendOrder> getByClassIds(List<Long> classIds) {
        return context.selectFrom(I_ITEM_LEND_ORDER)
                .where(I_ITEM_LEND_ORDER.CLASS_ID.in(classIds))
                .fetch()
                .into(IItemLendOrder.class);
    }
}
