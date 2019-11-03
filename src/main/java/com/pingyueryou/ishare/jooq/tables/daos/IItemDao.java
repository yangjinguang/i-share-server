/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.daos;


import com.pingyueryou.ishare.jooq.tables.IItem;
import com.pingyueryou.ishare.jooq.tables.records.IItemRecord;

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
public class IItemDao extends DAOImpl<IItemRecord, com.pingyueryou.ishare.jooq.tables.pojos.IItem, Long> {

    /**
     * Create a new IItemDao without any configuration
     */
    public IItemDao() {
        super(IItem.I_ITEM, com.pingyueryou.ishare.jooq.tables.pojos.IItem.class);
    }

    /**
     * Create a new IItemDao with an attached configuration
     */
    public IItemDao(Configuration configuration) {
        super(IItem.I_ITEM, com.pingyueryou.ishare.jooq.tables.pojos.IItem.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.pingyueryou.ishare.jooq.tables.pojos.IItem object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchById(Long... values) {
        return fetch(IItem.I_ITEM.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IItem fetchOneById(Long value) {
        return fetchOne(IItem.I_ITEM.ID, value);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByType(Integer... values) {
        return fetch(IItem.I_ITEM.TYPE, values);
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByTitle(String... values) {
        return fetch(IItem.I_ITEM.TITLE, values);
    }

    /**
     * Fetch records that have <code>cover_url IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByCoverUrl(String... values) {
        return fetch(IItem.I_ITEM.COVER_URL, values);
    }

    /**
     * Fetch records that have <code>desc IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByDesc(String... values) {
        return fetch(IItem.I_ITEM.DESC, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByStatus(Integer... values) {
        return fetch(IItem.I_ITEM.STATUS, values);
    }

    /**
     * Fetch records that have <code>upload_user_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByUploadUserId(Long... values) {
        return fetch(IItem.I_ITEM.UPLOAD_USER_ID, values);
    }

    /**
     * Fetch records that have <code>class_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByClassId(Long... values) {
        return fetch(IItem.I_ITEM.CLASS_ID, values);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByCreatedAt(Timestamp... values) {
        return fetch(IItem.I_ITEM.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IItem> fetchByUpdatedAt(Timestamp... values) {
        return fetch(IItem.I_ITEM.UPDATED_AT, values);
    }
}