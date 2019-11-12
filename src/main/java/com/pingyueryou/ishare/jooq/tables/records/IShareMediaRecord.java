/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.records;


import com.pingyueryou.ishare.jooq.tables.IShareMedia;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class IShareMediaRecord extends UpdatableRecordImpl<IShareMediaRecord> implements Record8<Long, String, Integer, Integer, Integer, Integer, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1664488453;

    /**
     * Setter for <code>ishare.i_share_media.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ishare.i_share_media.path</code>.
     */
    public void setPath(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.path</code>.
     */
    public String getPath() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ishare.i_share_media.duration</code>.
     */
    public void setDuration(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.duration</code>.
     */
    public Integer getDuration() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>ishare.i_share_media.size</code>.
     */
    public void setSize(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.size</code>.
     */
    public Integer getSize() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>ishare.i_share_media.width</code>.
     */
    public void setWidth(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.width</code>.
     */
    public Integer getWidth() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>ishare.i_share_media.height</code>.
     */
    public void setHeight(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>ishare.i_share_media.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>ishare.i_share_media.updated_at</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>ishare.i_share_media.updated_at</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, Integer, Integer, Integer, Integer, Timestamp, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, Integer, Integer, Integer, Integer, Timestamp, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return IShareMedia.I_SHARE_MEDIA.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return IShareMedia.I_SHARE_MEDIA.PATH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return IShareMedia.I_SHARE_MEDIA.DURATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return IShareMedia.I_SHARE_MEDIA.SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return IShareMedia.I_SHARE_MEDIA.WIDTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return IShareMedia.I_SHARE_MEDIA.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return IShareMedia.I_SHARE_MEDIA.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return IShareMedia.I_SHARE_MEDIA.UPDATED_AT;
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
        return getPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getWidth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
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
        return getPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getWidth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value2(String value) {
        setPath(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value3(Integer value) {
        setDuration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value4(Integer value) {
        setSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value5(Integer value) {
        setWidth(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value6(Integer value) {
        setHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value7(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord value8(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShareMediaRecord values(Long value1, String value2, Integer value3, Integer value4, Integer value5, Integer value6, Timestamp value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IShareMediaRecord
     */
    public IShareMediaRecord() {
        super(IShareMedia.I_SHARE_MEDIA);
    }

    /**
     * Create a detached, initialised IShareMediaRecord
     */
    public IShareMediaRecord(Long id, String path, Integer duration, Integer size, Integer width, Integer height, Timestamp createdAt, Timestamp updatedAt) {
        super(IShareMedia.I_SHARE_MEDIA);

        set(0, id);
        set(1, path);
        set(2, duration);
        set(3, size);
        set(4, width);
        set(5, height);
        set(6, createdAt);
        set(7, updatedAt);
    }
}