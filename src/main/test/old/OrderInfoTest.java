import com.accenture.flowershop.be.access.Order.OrderInfo;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrderInfoTest extends TestCase {
    private SessionFactory sessionFactory;
    private Session session;

    Log logger = LogFactory.getLog(this.getClass());

    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("Connection successfully established!");
    }

    public void testGetAllOrderInfo() {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            OrderInfo test = ctx.getBean(OrderInfo.class);
            List<com.accenture.flowershop.be.entity.order.OrderInfo> result = test.getAllOrderInfo();
            assertEquals(result.size(),5);
            System.out.println(result.get(0).getFlower());
            System.out.println(result.get(1).getFlower());
            System.out.println(result.get(2).getFlower());
            System.out.println(result.get(3).getFlower());
            System.out.println(result.get(4).getFlower());
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }
    public void testAdd() {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            OrderInfo test = ctx.getBean(OrderInfo.class);
            test.addOrderInfo(new com.accenture.flowershop.be.entity.order.OrderInfo("sel",10,10));
            List<com.accenture.flowershop.be.entity.order.OrderInfo> result = test.getAllOrderInfo();
            assertEquals(result.size(),6);
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }
}
