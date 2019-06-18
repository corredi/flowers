import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static com.accenture.flowershop.be.entity.jooqent.tables.Customer.CUSTOMER;
import static com.accenture.flowershop.be.entity.jooqent.tables.Flower.FLOWER;
import static com.accenture.flowershop.be.entity.jooqent.tables.Orders.ORDERS;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"../META-INF/jooq-test.xml"})
public class JooqTest {

    @Autowired
    DSLContext create;

    @Test
    public void testJoin() throws Exception {
        String sql = create.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                .from(table("BOOK"))
                .join(table("AUTHOR"))
                .on(field("BOOK.AUTHOR_ID").eq(field("AUTHOR.ID")))
                .where(field("BOOK.PUBLISHED_IN").eq(1948))
                .getSQL();
        System.out.println("RESULT:");
        System.out.println(sql);
    }

    @Test
    public void testSelect() throws Exception {
        System.out.println(create.select().from(CUSTOMER).
                leftOuterJoin(ORDERS).on(CUSTOMER.LOGIN.eq(ORDERS.LOGIN)));
        Result<Record> result = create.select().from(CUSTOMER).
                leftOuterJoin(ORDERS).on(CUSTOMER.LOGIN.eq(ORDERS.LOGIN)).fetch();
        for (Record r : result) {
            System.out.println(r.getValue(ORDERS.TOTAL));
        }
    }

    @Test
    public void testUpdate() throws Exception {
        create.update(FLOWER)
                .set(field("STOCK"), 1000)
                .where(FLOWER.NAME.eq("Orchid"))
                .execute();

        create.update(FLOWER)
                .set(FLOWER.STOCK, 100)
                .where(FLOWER.NAME.eq("rose"))
                .execute();

    }
}