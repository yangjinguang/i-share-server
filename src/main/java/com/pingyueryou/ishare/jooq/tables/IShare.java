/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables;


import com.pingyueryou.ishare.jooq.Indexes;
import com.pingyueryou.ishare.jooq.Ishare;
import com.pingyueryou.ishare.jooq.Keys;
import com.pingyueryou.ishare.jooq.tables.records.IShareRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class IShare extends TableImpl<IShareRecord> {

    private static final long serialVersionUID = 1214935058;

    /**
     * The reference instance of <code>ishare.i_share</code>
     */
    public static final IShare I_SHARE = new IShare();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IShareRecord> getRecordType() {
        return IShareRecord.class;
    }

    /**
     * The column <code>ishare.i_share.id</code>.
     */
    public final TableField<IShareRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>ishare.i_share.title</code>.
     */
    public final TableField<IShareRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>ishare.i_share.media_url</code>.
     */
    public final TableField<IShareRecord, String> MEDIA_URL = createField("media_url", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>ishare.i_share.media_type</code>.
     */
    public final TableField<IShareRecord, Integer> MEDIA_TYPE = createField("media_type", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ishare.i_share.upload_user_id</code>.
     */
    public final TableField<IShareRecord, Long> UPLOAD_USER_ID = createField("upload_user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ishare.i_share.class_id</code>.
     */
    public final TableField<IShareRecord, Long> CLASS_ID = createField("class_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ishare.i_share.item_id</code>.
     */
    public final TableField<IShareRecord, Long> ITEM_ID = createField("item_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ishare.i_share.desc</code>.
     */
    public final TableField<IShareRecord, String> DESC = createField("desc", org.jooq.impl.SQLDataType.VARCHAR(500).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>ishare.i_share.created_at</code>.
     */
    public final TableField<IShareRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>ishare.i_share.updated_at</code>.
     */
    public final TableField<IShareRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>ishare.i_share</code> table reference
     */
    public IShare() {
        this(DSL.name("i_share"), null);
    }

    /**
     * Create an aliased <code>ishare.i_share</code> table reference
     */
    public IShare(String alias) {
        this(DSL.name(alias), I_SHARE);
    }

    /**
     * Create an aliased <code>ishare.i_share</code> table reference
     */
    public IShare(Name alias) {
        this(alias, I_SHARE);
    }

    private IShare(Name alias, Table<IShareRecord> aliased) {
        this(alias, aliased, null);
    }

    private IShare(Name alias, Table<IShareRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Ishare.ISHARE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.I_SHARE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<IShareRecord, Long> getIdentity() {
        return Keys.IDENTITY_I_SHARE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<IShareRecord> getPrimaryKey() {
        return Keys.KEY_I_SHARE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<IShareRecord>> getKeys() {
        return Arrays.<UniqueKey<IShareRecord>>asList(Keys.KEY_I_SHARE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShare as(String alias) {
        return new IShare(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IShare as(Name alias) {
        return new IShare(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IShare rename(String name) {
        return new IShare(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public IShare rename(Name name) {
        return new IShare(name, null);
    }
}
