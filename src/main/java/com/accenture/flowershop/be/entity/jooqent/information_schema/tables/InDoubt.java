/*
 * This file is generated by jOOQ.
 */
package com.accenture.flowershop.be.entity.jooqent.information_schema.tables;


import com.accenture.flowershop.be.entity.jooqent.information_schema.InformationSchema;
import com.accenture.flowershop.be.entity.jooqent.information_schema.tables.records.InDoubtRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InDoubt extends TableImpl<InDoubtRecord> {

    private static final long serialVersionUID = 1021642314;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.IN_DOUBT</code>
     */
    public static final InDoubt IN_DOUBT = new InDoubt();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InDoubtRecord> getRecordType() {
        return InDoubtRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.IN_DOUBT.TRANSACTION</code>.
     */
    public final TableField<InDoubtRecord, String> TRANSACTION = createField("TRANSACTION", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.IN_DOUBT.STATE</code>.
     */
    public final TableField<InDoubtRecord, String> STATE = createField("STATE", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.IN_DOUBT</code> table reference
     */
    public InDoubt() {
        this(DSL.name("IN_DOUBT"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.IN_DOUBT</code> table reference
     */
    public InDoubt(String alias) {
        this(DSL.name(alias), IN_DOUBT);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.IN_DOUBT</code> table reference
     */
    public InDoubt(Name alias) {
        this(alias, IN_DOUBT);
    }

    private InDoubt(Name alias, Table<InDoubtRecord> aliased) {
        this(alias, aliased, null);
    }

    private InDoubt(Name alias, Table<InDoubtRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> InDoubt(Table<O> child, ForeignKey<O, InDoubtRecord> key) {
        super(child, key, IN_DOUBT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InDoubt as(String alias) {
        return new InDoubt(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InDoubt as(Name alias) {
        return new InDoubt(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InDoubt rename(String name) {
        return new InDoubt(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InDoubt rename(Name name) {
        return new InDoubt(name, null);
    }
}
