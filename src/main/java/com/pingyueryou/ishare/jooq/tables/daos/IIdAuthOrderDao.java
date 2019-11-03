/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.daos;


import com.pingyueryou.ishare.jooq.tables.IIdAuthOrder;
import com.pingyueryou.ishare.jooq.tables.records.IIdAuthOrderRecord;

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
public class IIdAuthOrderDao extends DAOImpl<IIdAuthOrderRecord, com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder, Long> {

    /**
     * Create a new IIdAuthOrderDao without any configuration
     */
    public IIdAuthOrderDao() {
        super(IIdAuthOrder.I_ID_AUTH_ORDER, com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder.class);
    }

    /**
     * Create a new IIdAuthOrderDao with an attached configuration
     */
    public IIdAuthOrderDao(Configuration configuration) {
        super(IIdAuthOrder.I_ID_AUTH_ORDER, com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchById(Long... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder fetchOneById(Long value) {
        return fetchOne(IIdAuthOrder.I_ID_AUTH_ORDER.ID, value);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByUserId(Long... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.USER_ID, values);
    }

    /**
     * Fetch records that have <code>role IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByRole(Integer... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.ROLE, values);
    }

    /**
     * Fetch records that have <code>class_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByClassId(Long... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.CLASS_ID, values);
    }

    /**
     * Fetch records that have <code>child_name IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByChildName(String... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.CHILD_NAME, values);
    }

    /**
     * Fetch records that have <code>relation IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByRelation(String... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.RELATION, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByStatus(Integer... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.STATUS, values);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByCreatedAt(Timestamp... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder> fetchByUpdatedAt(Timestamp... values) {
        return fetch(IIdAuthOrder.I_ID_AUTH_ORDER.UPDATED_AT, values);
    }
}