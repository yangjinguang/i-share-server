package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IItemLendOrderDbService;
import com.pingyueryou.ishare.entity.IItemLendOrderExtra;
import com.pingyueryou.ishare.entity.ItemLendOrderStatus;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;
import com.pingyueryou.ishare.jooq.tables.records.IItemLendOrderRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.pingyueryou.ishare.jooq.tables.IItemLendOrder.I_ITEM_LEND_ORDER;
import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

@Service
public class IItemLendOrderDbServiceImpl implements IItemLendOrderDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IItemLendOrder create(IItemLendOrder order) {
        IItemLendOrderRecord iItemLendOrderRecord = context.newRecord(I_ITEM_LEND_ORDER, order);
        iItemLendOrderRecord.store();
        return iItemLendOrderRecord.into(IItemLendOrder.class);
    }

    @Override
    public Integer countByClassId(Long classId, ItemLendOrderStatus status) {
        return context.selectCount().from(I_ITEM_LEND_ORDER)
                .where(I_ITEM_LEND_ORDER.CLASS_ID.eq(classId))
                .and(I_ITEM_LEND_ORDER.STATUS.eq(status.getIndex()))
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public Integer countByClassIds(List<Long> classIds, ItemLendOrderStatus status) {
        return context.selectCount().from(I_ITEM_LEND_ORDER)
                .where(I_ITEM_LEND_ORDER.CLASS_ID.in(classIds))
                .and(I_ITEM_LEND_ORDER.STATUS.eq(status.getIndex()))
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public List<IItemLendOrderExtra> getByClassIds(List<Long> classIds, ItemLendOrderStatus status) {
        return context.select(I_ITEM_LEND_ORDER.fields())
                .select(I_USER.NICK_NAME.as("user_name"))
                .from(I_ITEM_LEND_ORDER)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_ITEM_LEND_ORDER.USER_ID))
                .where(I_ITEM_LEND_ORDER.CLASS_ID.in(classIds))
                .and(I_ITEM_LEND_ORDER.STATUS.eq(status.getIndex()))
                .fetch()
                .into(IItemLendOrderExtra.class);
    }

    @Override
    public IItemLendOrderExtra get(Long orderId) {
        Record record = context.select(I_ITEM_LEND_ORDER.fields())
                .select(I_USER.NICK_NAME.as("user_name"))
                .from(I_ITEM_LEND_ORDER)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_ITEM_LEND_ORDER.USER_ID))
                .where(I_ITEM_LEND_ORDER.ID.eq(orderId))
                .fetchOptional()
                .orElse(null);
        if (record != null) {
            return record.into(IItemLendOrderExtra.class);
        }
        return null;
    }

    @Override
    public void changeStatus(Long orderId, ItemLendOrderStatus status) {
        IItemLendOrderRecord orderRecord = context.selectFrom(I_ITEM_LEND_ORDER)
                .where(I_ITEM_LEND_ORDER.ID.eq(orderId))
                .fetchOptional()
                .orElseThrow(NoDataFoundException::new);
        orderRecord.setStatus(status.getIndex());
        orderRecord.update();
    }
}
