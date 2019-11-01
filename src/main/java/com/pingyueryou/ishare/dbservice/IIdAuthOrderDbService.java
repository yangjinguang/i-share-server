package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;

public interface IIdAuthOrderDbService {
    IIdAuthOrder create(IIdAuthOrder order);
}
