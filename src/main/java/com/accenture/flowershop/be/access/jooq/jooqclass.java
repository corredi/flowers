package com.accenture.flowershop.be.access.jooq;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class jooqclass {
    @Autowired
    DriverManagerDataSource dataSource;

    public void fgdjsak() throws SQLException {
        Connection connection = dataSource.getConnection();
        DSLContext create = DSL.using(connection, SQLDialect.H2);
        String sql = create.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                .from(table("BOOK"))
                .join(table("AUTHOR"))
                .on(field("BOOK.AUTHOR_ID").eq(field("AUTHOR.ID")))
                .where(field("BOOK.PUBLISHED_IN").eq(1948))
                .getSQL();
    }
}
