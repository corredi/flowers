import com.accenture.flowershop.be.access.Flower.FlowerDAO;
import com.accenture.flowershop.be.access.Order.OrderDAOImpl;
import com.accenture.flowershop.be.access.Order.OrderDAO;
import com.accenture.flowershop.be.access.Order.OrderInfo;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.*;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrderTest extends TestCase {
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

    public void testGetAllOrders() {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            OrderDAO test = ctx.getBean(OrderDAO.class);
            List<Order> result = test.getAllOrders();
            assertEquals(result.size(),2);
            System.out.println(result.get(0).getOrderInfo().get(0).getFlower());
            System.out.println(result.get(0).getOrderInfo().get(0).getFlower());
            System.out.println(result.get(1).getOrderInfo().get(1).getFlower());
            System.out.println(result.get(1).getOrderInfo().get(1).getFlower());
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }

    public void testFindUserOrders () {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            OrderDAO test = ctx.getBean(OrderDAO.class);
            User user=new User();
            user.setLogin("test");
            List<Order> result = test.findUserOrders(user);
            assertEquals(result.size(),2);
            System.out.println(result.get(0).getOrderInfo().get(0).getFlower());
            System.out.println(result.get(0).getOrderInfo().get(0).getFlower());
            System.out.println(result.get(1).getOrderInfo().get(1).getFlower());
            System.out.println(result.get(1).getOrderInfo().get(1).getFlower());
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }

    public void testCloseOrder () {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            OrderDAO test = ctx.getBean(OrderDAO.class);
            User user=new User();
            user.setLogin("test");
            List<Order> result = test.findUserOrders(user);
            boolean flag;
            if(result.get(0).getState().equals("opened")){
                flag=test.closeOrder(result.get(0));
            }
            else{
                flag=test.closeOrder(result.get(1));
            }
            assertTrue(flag);
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }

    public void testCreateOrder () {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            FlowerDAO flowerDAO = ctx.getBean(FlowerDAO.class);
            List<Flower> flowers=flowerDAO.findAll();
            OrderDAOImpl test = ctx.getBean(OrderDAOImpl.class);
            Customer customer=new Customer();
            customer.setLogin("test");
            assertTrue(test.makeOrder(flowers,customer));
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }
}