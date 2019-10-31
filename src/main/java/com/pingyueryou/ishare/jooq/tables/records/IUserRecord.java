/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.records;


import com.pingyueryou.ishare.jooq.tables.IUser;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class IUserRecord extends UpdatableRecordImpl<IUserRecord> implements Record9<Long, String, Integer, Timestamp, String, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1697717947;

    /**
     * Setter for <code>ishare.i_user.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ishare.i_user.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ishare.i_user.nick_name</code>.
     */
    public void setNickName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ishare.i_user.nick_name</code>.
     */
    public String getNickName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ishare.i_user.gender</code>.
     */
    public void setGender(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>ishare.i_user.gender</code>.
     */
    public Integer getGender() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>ishare.i_user.birthday</code>.
     */
    public void setBirthday(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>ishare.i_user.birthday</code>.
     */
    public Timestamp getBirthday() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>ishare.i_user.open_id</code>.
     */
    public void setOpenId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>ishare.i_user.open_id</code>.
     */
    public String getOpenId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>ishare.i_user.union_id</code>.
     */
    public void setUnionId(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>ishare.i_user.union_id</code>.
     */
    public String getUnionId() {
        return (String) get(5);
    }

    /**
     * Setter for <code>ishare.i_user.avatar_url</code>.
     */
    public void setAvatarUrl(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>ishare.i_user.avatar_url</code>.
     */
    public String getAvatarUrl() {
        return (String) get(6);
    }

    /**
     * Setter for <code>ishare.i_user.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>ishare.i_user.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>ishare.i_user.updated_at</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>ishare.i_user.updated_at</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, Integer, Timestamp, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, Integer, Timestamp, String, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return IUser.I_USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return IUser.I_USER.NICK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return IUser.I_USER.GENDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return IUser.I_USER.BIRTHDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return IUser.I_USER.OPEN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return IUser.I_USER.UNION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return IUser.I_USER.AVATAR_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return IUser.I_USER.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return IUser.I_USER.UPDATED_AT;
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
        return getNickName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getOpenId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getUnionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getAvatarUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
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
        return getNickName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getOpenId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getUnionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAvatarUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value2(String value) {
        setNickName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value3(Integer value) {
        setGender(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value4(Timestamp value) {
        setBirthday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value5(String value) {
        setOpenId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value6(String value) {
        setUnionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value7(String value) {
        setAvatarUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value8(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord value9(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserRecord values(Long value1, String value2, Integer value3, Timestamp value4, String value5, String value6, String value7, Timestamp value8, Timestamp value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IUserRecord
     */
    public IUserRecord() {
        super(IUser.I_USER);
    }

    /**
     * Create a detached, initialised IUserRecord
     */
    public IUserRecord(Long id, String nickName, Integer gender, Timestamp birthday, String openId, String unionId, String avatarUrl, Timestamp createdAt, Timestamp updatedAt) {
        super(IUser.I_USER);

        set(0, id);
        set(1, nickName);
        set(2, gender);
        set(3, birthday);
        set(4, openId);
        set(5, unionId);
        set(6, avatarUrl);
        set(7, createdAt);
        set(8, updatedAt);
    }
}
