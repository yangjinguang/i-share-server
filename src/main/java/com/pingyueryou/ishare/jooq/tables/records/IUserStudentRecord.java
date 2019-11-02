/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.records;


import com.pingyueryou.ishare.jooq.tables.IUserStudent;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class IUserStudentRecord extends UpdatableRecordImpl<IUserStudentRecord> implements Record6<Long, Long, Long, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = 2101322555;

    /**
     * Setter for <code>ishare.i_user_student.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ishare.i_user_student.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ishare.i_user_student.user_id</code>.
     */
    public void setUserId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>ishare.i_user_student.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>ishare.i_user_student.student_id</code>.
     */
    public void setStudentId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>ishare.i_user_student.student_id</code>.
     */
    public Long getStudentId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>ishare.i_user_student.relation</code>.
     */
    public void setRelation(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>ishare.i_user_student.relation</code>.
     */
    public String getRelation() {
        return (String) get(3);
    }

    /**
     * Setter for <code>ishare.i_user_student.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>ishare.i_user_student.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>ishare.i_user_student.updated_at</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>ishare.i_user_student.updated_at</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, Long, Long, String, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, Long, Long, String, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return IUserStudent.I_USER_STUDENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return IUserStudent.I_USER_STUDENT.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return IUserStudent.I_USER_STUDENT.STUDENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return IUserStudent.I_USER_STUDENT.RELATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return IUserStudent.I_USER_STUDENT.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return IUserStudent.I_USER_STUDENT.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getStudentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getRelation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getStudentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getRelation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord value2(Long value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord value3(Long value) {
        setStudentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord value4(String value) {
        setRelation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord value5(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord value6(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserStudentRecord values(Long value1, Long value2, Long value3, String value4, Timestamp value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IUserStudentRecord
     */
    public IUserStudentRecord() {
        super(IUserStudent.I_USER_STUDENT);
    }

    /**
     * Create a detached, initialised IUserStudentRecord
     */
    public IUserStudentRecord(Long id, Long userId, Long studentId, String relation, Timestamp createdAt, Timestamp updatedAt) {
        super(IUserStudent.I_USER_STUDENT);

        set(0, id);
        set(1, userId);
        set(2, studentId);
        set(3, relation);
        set(4, createdAt);
        set(5, updatedAt);
    }
}
