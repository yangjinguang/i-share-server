/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables;


import com.pingyueryou.ishare.jooq.Indexes;
import com.pingyueryou.ishare.jooq.Ishare;
import com.pingyueryou.ishare.jooq.Keys;
import com.pingyueryou.ishare.jooq.tables.records.IStudentRecord;

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
public class IStudent extends TableImpl<IStudentRecord> {

    private static final long serialVersionUID = 1126354142;

    /**
     * The reference instance of <code>ishare.i_student</code>
     */
    public static final IStudent I_STUDENT = new IStudent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IStudentRecord> getRecordType() {
        return IStudentRecord.class;
    }

    /**
     * The column <code>ishare.i_student.id</code>.
     */
    public final TableField<IStudentRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>ishare.i_student.name</code>.
     */
    public final TableField<IStudentRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>ishare.i_student.class_id</code>.
     */
    public final TableField<IStudentRecord, Long> CLASS_ID = createField("class_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ishare.i_student.created_at</code>.
     */
    public final TableField<IStudentRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>ishare.i_student.updated_at</code>.
     */
    public final TableField<IStudentRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>ishare.i_student</code> table reference
     */
    public IStudent() {
        this(DSL.name("i_student"), null);
    }

    /**
     * Create an aliased <code>ishare.i_student</code> table reference
     */
    public IStudent(String alias) {
        this(DSL.name(alias), I_STUDENT);
    }

    /**
     * Create an aliased <code>ishare.i_student</code> table reference
     */
    public IStudent(Name alias) {
        this(alias, I_STUDENT);
    }

    private IStudent(Name alias, Table<IStudentRecord> aliased) {
        this(alias, aliased, null);
    }

    private IStudent(Name alias, Table<IStudentRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.I_STUDENT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<IStudentRecord, Long> getIdentity() {
        return Keys.IDENTITY_I_STUDENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<IStudentRecord> getPrimaryKey() {
        return Keys.KEY_I_STUDENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<IStudentRecord>> getKeys() {
        return Arrays.<UniqueKey<IStudentRecord>>asList(Keys.KEY_I_STUDENT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IStudent as(String alias) {
        return new IStudent(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IStudent as(Name alias) {
        return new IStudent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IStudent rename(String name) {
        return new IStudent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public IStudent rename(Name name) {
        return new IStudent(name, null);
    }
}