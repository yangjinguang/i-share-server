package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner;

import java.util.List;

public interface IIndexBannerDbService {
    IIndexBanner create(IIndexBanner banner);

    List<IIndexBanner> getAll();

    void delete(Long bannerId);

    void deleteAll();
}
