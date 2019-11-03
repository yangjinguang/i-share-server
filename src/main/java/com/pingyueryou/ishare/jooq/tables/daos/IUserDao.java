/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.daos;


import com.pingyueryou.ishare.jooq.tables.IUser;
import com.pingyueryou.ishare.jooq.tables.records.IUserRecord;

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
public class IUserDao extends DAOImpl<IUserRecord, com.pingyueryou.ishare.jooq.tables.pojos.IUser, Long> {

    /**
     * Create a new IUserDao without any configuration
     */
    public IUserDao() {
        super(IUser.I_USER, com.pingyueryou.ishare.jooq.tables.pojos.IUser.class);
    }

    /**
     * Create a new IUserDao with an attached configuration
     */
    public IUserDao(Configuration configuration) {
        super(IUser.I_USER, com.pingyueryou.ishare.jooq.tables.pojos.IUser.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.pingyueryou.ishare.jooq.tables.pojos.IUser object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchById(Long... values) {
        return fetch(IUser.I_USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IUser fetchOneById(Long value) {
        return fetchOne(IUser.I_USER.ID, value);
    }

    /**
     * Fetch records that have <code>nick_name IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByNickName(String... values) {
        return fetch(IUser.I_USER.NICK_NAME, values);
    }

    /**
     * Fetch records that have <code>gender IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByGender(Integer... values) {
        return fetch(IUser.I_USER.GENDER, values);
    }

    /**
     * Fetch records that have <code>birthday IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByBirthday(Timestamp... values) {
        return fetch(IUser.I_USER.BIRTHDAY, values);
    }

    /**
     * Fetch records that have <code>open_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByOpenId(String... values) {
        return fetch(IUser.I_USER.OPEN_ID, values);
    }

    /**
     * Fetch a unique record that has <code>open_id = value</code>
     */
    public com.pingyueryou.ishare.jooq.tables.pojos.IUser fetchOneByOpenId(String value) {
        return fetchOne(IUser.I_USER.OPEN_ID, value);
    }

    /**
     * Fetch records that have <code>union_id IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByUnionId(String... values) {
        return fetch(IUser.I_USER.UNION_ID, values);
    }

    /**
     * Fetch records that have <code>avatar_url IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByAvatarUrl(String... values) {
        return fetch(IUser.I_USER.AVATAR_URL, values);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByCreatedAt(Timestamp... values) {
        return fetch(IUser.I_USER.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.pingyueryou.ishare.jooq.tables.pojos.IUser> fetchByUpdatedAt(Timestamp... values) {
        return fetch(IUser.I_USER.UPDATED_AT, values);
    }
}