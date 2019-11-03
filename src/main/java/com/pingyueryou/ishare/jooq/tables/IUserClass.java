/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables;


import com.pingyueryou.ishare.jooq.Indexes;
import com.pingyueryou.ishare.jooq.Ishare;
import com.pingyueryou.ishare.jooq.Keys;
import com.pingyueryou.ishare.jooq.tables.records.IUserClassRecord;

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
public class IUserClass extends TableImpl<IUserClassRecord> {

    private static final long serialVersionUID = -1288787466;

    /**
     * The reference instance of <code>ishare.i_user_class</code>
     */
    public static final IUserClass I_USER_CLASS = new IUserClass();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IUserClassRecord> getRecordType() {
        return IUserClassRecord.class;
    }

    /**
     * The column <code>ishare.i_user_class.id</code>.
     */
    public final TableField<IUserClassRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>ishare.i_user_class.user_id</code>.
     */
    public final TableField<IUserClassRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ishare.i_user_class.class_id</code>.
     */
    public final TableField<IUserClassRecord, Long> CLASS_ID = createField("class_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ishare.i_user_class.created_at</code>.
     */
    public final TableField<IUserClassRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>ishare.i_user_class.updated_at</code>.
     */
    public final TableField<IUserClassRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>ishare.i_user_class</code> table reference
     */
    public IUserClass() {
        this(DSL.name("i_user_class"), null);
    }

    /**
     * Create an aliased <code>ishare.i_user_class</code> table reference
     */
    public IUserClass(String alias) {
        this(DSL.name(alias), I_USER_CLASS);
    }

    /**
     * Create an aliased <code>ishare.i_user_class</code> table reference
     */
    public IUserClass(Name alias) {
        this(alias, I_USER_CLASS);
    }

    private IUserClass(Name alias, Table<IUserClassRecord> aliased) {
        this(alias, aliased, null);
    }

    private IUserClass(Name alias, Table<IUserClassRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.I_USER_CLASS_PRIMARY, Indexes.I_USER_CLASS_UK_USER_CLASS_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<IUserClassRecord, Long> getIdentity() {
        return Keys.IDENTITY_I_USER_CLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<IUserClassRecord> getPrimaryKey() {
        return Keys.KEY_I_USER_CLASS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<IUserClassRecord>> getKeys() {
        return Arrays.<UniqueKey<IUserClassRecord>>asList(Keys.KEY_I_USER_CLASS_PRIMARY, Keys.KEY_I_USER_CLASS_UK_USER_CLASS_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserClass as(String alias) {
        return new IUserClass(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUserClass as(Name alias) {
        return new IUserClass(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IUserClass rename(String name) {
        return new IUserClass(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public IUserClass rename(Name name) {
        return new IUserClass(name, null);
    }
}