/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.daos;


import com.pingyueryou.ishare.jooq.tables.IClass;
import com.pingyueryou.ishare.jooq.tables.records.IClassRecord;

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
public class IClassDao extends DAOImpl<IClassRecord, com.pingyueryou.ishare.jooq.tables.pojos.IClass, Long> {

    /**
     * Create a new IClassDao without any configuration
     */
    public IClassDao() {
        super(IClass.I_CLASS, com.pingyueryou.ishare.jooq.tables.pojos.IClass.class);
    }

    /**
     * Create a new IClassDao with an attached configuration
     */
    public IClassDao(Configuration configuration) {
        super(IClass.I_CLASS, com.pingyueryou.ishare.jooq.tables.pojos.IClass.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.pingyueryou.ishare.jooq.tables.pojos.IClass object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IClass> fetchById(Long... values) {
        return fetch(IClass.I_CLASS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IClass fetchOneById(Long value) {
        return fetchOne(IClass.I_CLASS.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IClass> fetchByName(String... values) {
        return fetch(IClass.I_CLASS.NAME, values);
    }

    /**
     * Fetch records that have <code>grade_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IClass> fetchByGradeId(Long... values) {
        return fetch(IClass.I_CLASS.GRADE_ID, values);
    }

    /**
     * Fetch records that have <code>order IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IClass> fetchByOrder(Integer... values) {
        return fetch(IClass.I_CLASS.ORDER, values);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IClass> fetchByCreatedAt(Timestamp... values) {
        return fetch(IClass.I_CLASS.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IClass> fetchByUpdatedAt(Timestamp... values) {
        return fetch(IClass.I_CLASS.UPDATED_AT, values);
    }
}
