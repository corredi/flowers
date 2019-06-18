/*
 * This file is generated by jOOQ.
 */
package com.accenture.flowershop.be.entity.jooqent.public_.tables;


import com.accenture.flowershop.be.entity.jooqent.public_.Indexes;
import com.accenture.flowershop.be.entity.jooqent.public_.Keys;
import com.accenture.flowershop.be.entity.jooqent.public_.Public;
import com.accenture.flowershop.be.entity.jooqent.public_.tables.records.CustomerRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
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
        "jOOQ version:3.11.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customer extends TableImpl<CustomerRecord> {

    private static final long serialVersionUID = 957096931;

    /**
     * The reference instance of <code>PUBLIC.CUSTOMER</code>
     */
    public static final Customer CUSTOMER = new Customer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerRecord> getRecordType() {
        return CustomerRecord.class;
    }

    /**
     * The column <code>PUBLIC.CUSTOMER.LOGIN</code>.
     */
    public final TableField<CustomerRecord, String> LOGIN = createField("LOGIN", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.PASSWORD</code>.
     */
    public final TableField<CustomerRecord, String> PASSWORD = createField("PASSWORD", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.ADDRESS</code>.
     */
    public final TableField<CustomerRecord, String> ADDRESS = createField("ADDRESS", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.PHONE</code>.
     */
    public final TableField<CustomerRecord, String> PHONE = createField("PHONE", org.jooq.impl.SQLDataType.CHAR(10), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.MONEY</code>.
     */
    public final TableField<CustomerRecord, BigDecimal> MONEY = createField("MONEY", org.jooq.impl.SQLDataType.DECIMAL(10, 2), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.DISCOUNT</code>.
     */
    public final TableField<CustomerRecord, Integer> DISCOUNT = createField("DISCOUNT", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>PUBLIC.CUSTOMER</code> table reference
     */
    public Customer() {
        this(DSL.name("CUSTOMER"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.CUSTOMER</code> table reference
     */
    public Customer(String alias) {
        this(DSL.name(alias), CUSTOMER);
    }

    /**
     * Create an aliased <code>PUBLIC.CUSTOMER</code> table reference
     */
    public Customer(Name alias) {
        this(alias, CUSTOMER);
    }

    private Customer(Name alias, Table<CustomerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Customer(Name alias, Table<CustomerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Customer(Table<O> child, ForeignKey<O, CustomerRecord> key) {
        super(child, key, CUSTOMER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CustomerRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CustomerRecord>> getKeys() {
        return Arrays.<UniqueKey<CustomerRecord>>asList(Keys.CONSTRAINT_5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer as(String alias) {
        return new Customer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer as(Name alias) {
        return new Customer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(String name) {
        return new Customer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(Name name) {
        return new Customer(name, null);
    }
}
