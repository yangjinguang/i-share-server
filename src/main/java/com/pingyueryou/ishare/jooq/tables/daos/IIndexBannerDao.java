/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.daos;


import com.pingyueryou.ishare.jooq.tables.IIndexBanner;
import com.pingyueryou.ishare.jooq.tables.records.IIndexBannerRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IIndexBannerDao extends DAOImpl<IIndexBannerRecord, com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner, Long> {

    /**
     * Create a new IIndexBannerDao without any configuration
     */
    public IIndexBannerDao() {
        super(IIndexBanner.I_INDEX_BANNER, com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner.class);
    }

    /**
     * Create a new IIndexBannerDao with an attached configuration
     */
    public IIndexBannerDao(Configuration configuration) {
        super(IIndexBanner.I_INDEX_BANNER, com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner> fetchById(Long... values) {
        return fetch(IIndexBanner.I_INDEX_BANNER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner fetchOneById(Long value) {
        return fetchOne(IIndexBanner.I_INDEX_BANNER.ID, value);
    }

    /**
     * Fetch records that have <code>image_url IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner> fetchByImageUrl(String... values) {
        return fetch(IIndexBanner.I_INDEX_BANNER.IMAGE_URL, values);
    }

    /**
     * Fetch records that have <code>order IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner> fetchByOrder(Integer... values) {
        return fetch(IIndexBanner.I_INDEX_BANNER.ORDER, values);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner> fetchByCreatedAt(Timestamp... values) {
        return fetch(IIndexBanner.I_INDEX_BANNER.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIndexBanner> fetchByUpdatedAt(Timestamp... values) {
        return fetch(IIndexBanner.I_INDEX_BANNER.UPDATED_AT, values);
    }
}
