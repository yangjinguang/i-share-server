package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IIndexBannerDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner;
import com.pingyueryou.ishare.jooq.tables.records.IIndexBannerRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IIndexBanner.I_INDEX_BANNER;

@Service
public class IIndexBannerDbServiceImpl implements IIndexBannerDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IIndexBanner create(IIndexBanner banner) {
        IIndexBannerRecord bannerRecord = context.newRecord(I_INDEX_BANNER, banner);
        bannerRecord.store();
        return bannerRecord.into(IIndexBanner.class);
    }

    @Override
    public List<IIndexBanner> getAll() {
        return context.selectFrom(I_INDEX_BANNER)
                .fetch()
                .into(IIndexBanner.class);
    }

    @Override
public void delete(Long bannerId) {
        context.deleteFrom(I_INDEX_BANNER)
                .where(I_INDEX_BANNER.ID.eq(bannerId))
                .execute();
    }

    @Override
    public void deleteAll() {
        context.deleteFrom(I_INDEX_BANNER).execute();
    }
}
