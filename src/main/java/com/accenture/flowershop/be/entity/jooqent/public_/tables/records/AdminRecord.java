/*
 * This file is generated by jOOQ.
 */
package com.accenture.flowershop.be.entity.jooqent.public_.tables.records;


import com.accenture.flowershop.be.entity.jooqent.public_.tables.Admin;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class AdminRecord extends UpdatableRecordImpl<AdminRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 794612784;

    /**
     * Setter for <code>PUBLIC.ADMIN.LOGIN</code>.
     */
    public void setLogin(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.ADMIN.LOGIN</code>.
     */
    public String getLogin() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PUBLIC.ADMIN.PASSWORD</code>.
     */
    public void setPassword(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.ADMIN.PASSWORD</code>.
     */
    public String getPassword() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Admin.ADMIN.LOGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Admin.ADMIN.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getLogin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getLogin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdminRecord value1(String value) {
        setLogin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdminRecord value2(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdminRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AdminRecord
     */
    public AdminRecord() {
        super(Admin.ADMIN);
    }

    /**
     * Create a detached, initialised AdminRecord
     */
    public AdminRecord(String login, String password) {
        super(Admin.ADMIN);

        set(0, login);
        set(1, password);
    }
}
