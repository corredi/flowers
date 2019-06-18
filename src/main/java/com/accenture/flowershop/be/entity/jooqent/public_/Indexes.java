/*
 * This file is generated by jOOQ.
 */
package com.accenture.flowershop.be.entity.jooqent.public_;


import com.accenture.flowershop.be.entity.jooqent.public_.tables.Admin;
import com.accenture.flowershop.be.entity.jooqent.public_.tables.Customer;
import com.accenture.flowershop.be.entity.jooqent.public_.tables.Flower;
import com.accenture.flowershop.be.entity.jooqent.public_.tables.FlywaySchemaHistory;
import com.accenture.flowershop.be.entity.jooqent.public_.tables.OrderInfo;
import com.accenture.flowershop.be.entity.jooqent.public_.tables.Orders;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_3 = Indexes0.PRIMARY_KEY_3;
    public static final Index PRIMARY_KEY_5 = Indexes0.PRIMARY_KEY_5;
    public static final Index PRIMARY_KEY_7 = Indexes0.PRIMARY_KEY_7;
    public static final Index PRIMARY_KEY_8 = Indexes0.PRIMARY_KEY_8;
    public static final Index PRIMARY_KEY_4 = Indexes0.PRIMARY_KEY_4;
    public static final Index PRIMARY_KEY_6 = Indexes0.PRIMARY_KEY_6;
    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_S_IDX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_3 = Internal.createIndex("PRIMARY_KEY_3", Admin.ADMIN, new OrderField[] { Admin.ADMIN.LOGIN }, true);
        public static Index PRIMARY_KEY_5 = Internal.createIndex("PRIMARY_KEY_5", Customer.CUSTOMER, new OrderField[] { Customer.CUSTOMER.LOGIN }, true);
        public static Index PRIMARY_KEY_7 = Internal.createIndex("PRIMARY_KEY_7", Flower.FLOWER, new OrderField[] { Flower.FLOWER.NAME }, true);
        public static Index PRIMARY_KEY_8 = Internal.createIndex("PRIMARY_KEY_8", Orders.ORDERS, new OrderField[] { Orders.ORDERS.ORDERID }, true);
        public static Index PRIMARY_KEY_4 = Internal.createIndex("PRIMARY_KEY_4", OrderInfo.ORDER_INFO, new OrderField[] { OrderInfo.ORDER_INFO.ID }, true);
        public static Index PRIMARY_KEY_6 = Internal.createIndex("PRIMARY_KEY_6", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
    }
}
