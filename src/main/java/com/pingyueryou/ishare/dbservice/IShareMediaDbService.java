package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;

public interface IShareMediaDbService {
    IShareMedia get(Long mediaId);

    IShareMedia create(IShareMedia media);
}
