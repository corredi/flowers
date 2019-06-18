import com.accenture.flowershop.be.access.Flower.FlowerDAO;
import com.accenture.flowershop.be.access.Flower.FlowerDAOImpl;
import com.accenture.flowershop.be.entity.flower.Flower;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FlowerTest extends TestCase {

    private SessionFactory sessionFactory;
    private Session session;

    Log logger = LogFactory.getLog(this.getClass());

    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("Connection successfully established!");
    }

    public void testGetAllFlowers() {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            FlowerDAO flowerDAO = ctx.getBean(FlowerDAO.class);
            List<Flower> result = flowerDAO.findAll();
            assertEquals(result.size(), 3);
            /*
            assertEquals(result.get(1).getName().toUpperCase(), "CHAMOMILE");
            assertEquals(result.get(2).getName().toUpperCase(), "CARNATION");
            assertEquals(result.get(0).getStock(), 50);
            assertEquals(result.get(1).getStock(), 100);
            assertEquals(result.get(2).getStock(), 200);
            assertEquals(result.get(0).getCost(), 10.0);
            assertEquals(result.get(1).getCost(), 5.0);
            assertEquals(result.get(2).getCost(), 8.0);
            */
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }

    public void testGetFlowerByName() {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
            FlowerDAO test = ctx.getBean(FlowerDAO.class);
            Flower ROSE = test.findByName("ROSE");
            Flower CHAMOMILE = test.findByName("CHAMOMILE");
            Flower CARNATION = test.findByName("CARNATION");
            assertEquals(ROSE.getName().toUpperCase(), "ROSE");
            assertEquals(CHAMOMILE.getName().toUpperCase(), "CHAMOMILE");
            assertEquals(CARNATION.getName().toUpperCase(), "CARNATION");
            assertEquals(ROSE.getStock(), 50);
            assertEquals(CHAMOMILE.getStock(), 100);
            assertEquals(CARNATION.getStock(), 200);
            assertEquals(ROSE.getCost(), 10.0);
            assertEquals(CHAMOMILE.getCost(), 5.0);
            assertEquals(CARNATION.getCost(), 8.0);
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }
    public void testUpdateFlowerStock() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
        FlowerDAO test = ctx.getBean(FlowerDAO.class);
        try {
            Flower cham=new Flower("CHAMOMILE",5.0,50);
            assertTrue(test.updateFlowerStock(cham));
            Flower CHAMOMILE = test.findByName("CHAMOMILE");
            assertEquals(CHAMOMILE.getName().toUpperCase(), "CHAMOMILE");
            assertEquals(CHAMOMILE.getStock(), 50);
            assertEquals(CHAMOMILE.getCost(), 5.0);
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        finally {
            Flower temp=new Flower("CHAMOMILE",5.0,100);
            assertTrue(test.updateFlowerStock(temp));
        }
    }
    public void testOrderFlower() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/Spring.xml");
        FlowerDAO test = ctx.getBean(FlowerDAO.class);
        try {
            assertTrue(test.orderFlower("CHAMOMILE",10));
            System.out.println("done");
            Flower CHAMOMILE = test.findByName("CHAMOMILE");
            assertEquals(CHAMOMILE.getName().toUpperCase(), "CHAMOMILE");
            assertEquals(CHAMOMILE.getStock(), 90);
            assertEquals(CHAMOMILE.getCost(), 5.0);
        } catch (AssertionFailedError e) {
            //logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        finally {
            Flower temp=new Flower("CHAMOMILE",5.0,100);
            assertTrue(test.updateFlowerStock(temp));
        }
    }

}
