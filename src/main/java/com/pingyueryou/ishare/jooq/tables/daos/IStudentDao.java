/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.daos;


import com.pingyueryou.ishare.jooq.tables.IStudent;
import com.pingyueryou.ishare.jooq.tables.records.IStudentRecord;

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
public class IStudentDao extends DAOImpl<IStudentRecord, com.pingyueryou.ishare.jooq.tables.pojos.IStudent, Long> {

    /**
     * Create a new IStudentDao without any configuration
     */
    public IStudentDao() {
        super(IStudent.I_STUDENT, com.pingyueryou.ishare.jooq.tables.pojos.IStudent.class);
    }

    /**
     * Create a new IStudentDao with an attached configuration
     */
    public IStudentDao(Configuration configuration) {
        super(IStudent.I_STUDENT, com.pingyueryou.ishare.jooq.tables.pojos.IStudent.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.pingyueryou.ishare.jooq.tables.pojos.IStudent object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IStudent> fetchById(Long... values) {
        return fetch(IStudent.I_STUDENT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IStudent fetchOneById(Long value) {
        return fetchOne(IStudent.I_STUDENT.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IStudent> fetchByName(String... values) {
        return fetch(IStudent.I_STUDENT.NAME, values);
    }

    /**
     * Fetch records that have <code>class_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IStudent> fetchByClassId(Long... values) {
        return fetch(IStudent.I_STUDENT.CLASS_ID, values);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IStudent> fetchByCreatedAt(Timestamp... values) {
        return fetch(IStudent.I_STUDENT.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IStudent> fetchByUpdatedAt(Timestamp... values) {
        return fetch(IStudent.I_STUDENT.UPDATED_AT, values);
    }
}
