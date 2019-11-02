package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.records.IItemRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pingyueryou.ishare.jooq.tables.IItem.I_ITEM;

@Service
public class IItemDbServiceImpl implements IItemDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IItem create(IItem item) {
        IItemRecord iItemRecord = context.newRecord(I_ITEM, item);
        iItemRecord.store();
        return iItemRecord.into(IItem.class);
    }
}
