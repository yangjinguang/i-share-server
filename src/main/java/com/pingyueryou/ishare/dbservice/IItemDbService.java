package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IItem;

public interface IItemDbService {
    IItem create(IItem item);
}
