/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.records;


import com.pingyueryou.ishare.jooq.tables.IClass;

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
public class IClassRecord extends UpdatableRecordImpl<IClassRecord> implements Record6<Long, String, Long, Integer, Timestamp, Timestamp> {

    private static final long serialVersionUID = 1269880172;

    /**
     * Setter for <code>ishare.i_class.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ishare.i_class.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ishare.i_class.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ishare.i_class.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ishare.i_class.grade_id</code>.
     */
    public void setGradeId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>ishare.i_class.grade_id</code>.
     */
    public Long getGradeId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>ishare.i_class.order</code>.
     */
    public void setOrder(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ishare.i_class.order</code>.
     */
    public Integer getOrder() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>ishare.i_class.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>ishare.i_class.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>ishare.i_class.updated_at</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>ishare.i_class.updated_at</code>.
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
    public Row6<Long, String, Long, Integer, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, Long, Integer, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return IClass.I_CLASS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return IClass.I_CLASS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return IClass.I_CLASS.GRADE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return IClass.I_CLASS.ORDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return IClass.I_CLASS.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return IClass.I_CLASS.UPDATED_AT;
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
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getGradeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getOrder();
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getGradeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getOrder();
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
    public IClassRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IClassRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IClassRecord value3(Long value) {
        setGradeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IClassRecord value4(Integer value) {
        setOrder(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IClassRecord value5(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IClassRecord value6(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IClassRecord values(Long value1, String value2, Long value3, Integer value4, Timestamp value5, Timestamp value6) {
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
     * Create a detached IClassRecord
     */
    public IClassRecord() {
        super(IClass.I_CLASS);
    }

    /**
     * Create a detached, initialised IClassRecord
     */
    public IClassRecord(Long id, String name, Long gradeId, Integer order, Timestamp createdAt, Timestamp updatedAt) {
        super(IClass.I_CLASS);

        set(0, id);
        set(1, name);
        set(2, gradeId);
        set(3, order);
        set(4, createdAt);
        set(5, updatedAt);
    }
}
