/*
 * This file is generated by jOOQ.
 */
package com.accenture.flowershop.be.entity.jooqent.information_schema.tables.records;


import com.accenture.flowershop.be.entity.jooqent.information_schema.tables.TypeInfo;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.TableRecordImpl;


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
public class TypeInfoRecord extends TableRecordImpl<TypeInfoRecord> implements Record14<String, Integer, Integer, String, String, String, Boolean, Short, Short, Integer, Integer, Boolean, Short, Short> {

    private static final long serialVersionUID = -284272057;

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.TYPE_NAME</code>.
     */
    public void setTypeName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.TYPE_NAME</code>.
     */
    public String getTypeName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.DATA_TYPE</code>.
     */
    public void setDataType(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.DATA_TYPE</code>.
     */
    public Integer getDataType() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.PRECISION</code>.
     */
    public void setPrecision(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.PRECISION</code>.
     */
    public Integer getPrecision() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.PREFIX</code>.
     */
    public void setPrefix(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.PREFIX</code>.
     */
    public String getPrefix() {
        return (String) get(3);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.SUFFIX</code>.
     */
    public void setSuffix(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.SUFFIX</code>.
     */
    public String getSuffix() {
        return (String) get(4);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.PARAMS</code>.
     */
    public void setParams(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.PARAMS</code>.
     */
    public String getParams() {
        return (String) get(5);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.AUTO_INCREMENT</code>.
     */
    public void setAutoIncrement(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.AUTO_INCREMENT</code>.
     */
    public Boolean getAutoIncrement() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.MINIMUM_SCALE</code>.
     */
    public void setMinimumScale(Short value) {
        set(7, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.MINIMUM_SCALE</code>.
     */
    public Short getMinimumScale() {
        return (Short) get(7);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.MAXIMUM_SCALE</code>.
     */
    public void setMaximumScale(Short value) {
        set(8, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.MAXIMUM_SCALE</code>.
     */
    public Short getMaximumScale() {
        return (Short) get(8);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.RADIX</code>.
     */
    public void setRadix(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.RADIX</code>.
     */
    public Integer getRadix() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.POS</code>.
     */
    public void setPos(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.POS</code>.
     */
    public Integer getPos() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.CASE_SENSITIVE</code>.
     */
    public void setCaseSensitive(Boolean value) {
        set(11, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.CASE_SENSITIVE</code>.
     */
    public Boolean getCaseSensitive() {
        return (Boolean) get(11);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.NULLABLE</code>.
     */
    public void setNullable(Short value) {
        set(12, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.NULLABLE</code>.
     */
    public Short getNullable() {
        return (Short) get(12);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.SEARCHABLE</code>.
     */
    public void setSearchable(Short value) {
        set(13, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.SEARCHABLE</code>.
     */
    public Short getSearchable() {
        return (Short) get(13);
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, Integer, Integer, String, String, String, Boolean, Short, Short, Integer, Integer, Boolean, Short, Short> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, Integer, Integer, String, String, String, Boolean, Short, Short, Integer, Integer, Boolean, Short, Short> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TypeInfo.TYPE_INFO.TYPE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TypeInfo.TYPE_INFO.DATA_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return TypeInfo.TYPE_INFO.PRECISION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TypeInfo.TYPE_INFO.PREFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TypeInfo.TYPE_INFO.SUFFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TypeInfo.TYPE_INFO.PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return TypeInfo.TYPE_INFO.AUTO_INCREMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field8() {
        return TypeInfo.TYPE_INFO.MINIMUM_SCALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field9() {
        return TypeInfo.TYPE_INFO.MAXIMUM_SCALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return TypeInfo.TYPE_INFO.RADIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return TypeInfo.TYPE_INFO.POS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field12() {
        return TypeInfo.TYPE_INFO.CASE_SENSITIVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field13() {
        return TypeInfo.TYPE_INFO.NULLABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field14() {
        return TypeInfo.TYPE_INFO.SEARCHABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getDataType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getPrecision();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getSuffix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component7() {
        return getAutoIncrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component8() {
        return getMinimumScale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component9() {
        return getMaximumScale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getRadix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getPos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component12() {
        return getCaseSensitive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component13() {
        return getNullable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component14() {
        return getSearchable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getDataType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getPrecision();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSuffix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getAutoIncrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value8() {
        return getMinimumScale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value9() {
        return getMaximumScale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getRadix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getPos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value12() {
        return getCaseSensitive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value13() {
        return getNullable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value14() {
        return getSearchable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value1(String value) {
        setTypeName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value2(Integer value) {
        setDataType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value3(Integer value) {
        setPrecision(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value4(String value) {
        setPrefix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value5(String value) {
        setSuffix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value6(String value) {
        setParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value7(Boolean value) {
        setAutoIncrement(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value8(Short value) {
        setMinimumScale(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value9(Short value) {
        setMaximumScale(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value10(Integer value) {
        setRadix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value11(Integer value) {
        setPos(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value12(Boolean value) {
        setCaseSensitive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value13(Short value) {
        setNullable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord value14(Short value) {
        setSearchable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfoRecord values(String value1, Integer value2, Integer value3, String value4, String value5, String value6, Boolean value7, Short value8, Short value9, Integer value10, Integer value11, Boolean value12, Short value13, Short value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TypeInfoRecord
     */
    public TypeInfoRecord() {
        super(TypeInfo.TYPE_INFO);
    }

    /**
     * Create a detached, initialised TypeInfoRecord
     */
    public TypeInfoRecord(String typeName, Integer dataType, Integer precision, String prefix, String suffix, String params, Boolean autoIncrement, Short minimumScale, Short maximumScale, Integer radix, Integer pos, Boolean caseSensitive, Short nullable, Short searchable) {
        super(TypeInfo.TYPE_INFO);

        set(0, typeName);
        set(1, dataType);
        set(2, precision);
        set(3, prefix);
        set(4, suffix);
        set(5, params);
        set(6, autoIncrement);
        set(7, minimumScale);
        set(8, maximumScale);
        set(9, radix);
        set(10, pos);
        set(11, caseSensitive);
        set(12, nullable);
        set(13, searchable);
    }
}
