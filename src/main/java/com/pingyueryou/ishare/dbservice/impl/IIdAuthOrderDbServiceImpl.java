package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IIdAuthOrderDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;
import com.pingyueryou.ishare.jooq.tables.records.IIdAuthOrderRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pingyueryou.ishare.jooq.tables.IIdAuthOrder.I_ID_AUTH_ORDER;

@Service
public class IIdAuthOrderDbServiceImpl implements IIdAuthOrderDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IIdAuthOrder create(IIdAuthOrder order) {
        IIdAuthOrderRecord iIdAuthOrderRecord = context.newRecord(I_ID_AUTH_ORDER, order);
        iIdAuthOrderRecord.store();
        return iIdAuthOrderRecord.into(IIdAuthOrder.class);
    }
}
