package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IShareMediaDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;
import com.pingyueryou.ishare.jooq.tables.records.IShareMediaRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pingyueryou.ishare.jooq.tables.IShareMedia.I_SHARE_MEDIA;

@Service
public class IShareMediaDbServiceImpl implements IShareMediaDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IShareMedia get(Long mediaId) {
        IShareMediaRecord iShareMediaRecord = context.selectFrom(I_SHARE_MEDIA)
                .where(I_SHARE_MEDIA.ID.eq(mediaId))
                .fetchOptional()
                .orElse(null);
        if (iShareMediaRecord != null) {
            return iShareMediaRecord.into(IShareMedia.class);
        }
        return null;
    }

    @Override
    public IShareMedia create(IShareMedia media) {
        IShareMediaRecord iShareMediaRecord = context.newRecord(I_SHARE_MEDIA, media);
        iShareMediaRecord.store();
        return iShareMediaRecord.into(IShareMedia.class);
    }
}
