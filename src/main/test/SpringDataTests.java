import com.accenture.flowershop.be.access.repositories.AdminRepository;
import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.accenture.flowershop.be.access.repositories.FlowerRepository;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.user.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="../META-INF/Spring.xml")
public class SpringDataTests {
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testFindAllFlowers() {
        assertNotNull(flowerRepository);
        Iterable<Flower> flowers=flowerRepository.findAll();
        for(Flower flower:flowers){
            System.out.println(flower.getName());
        }
        Flower flower=((List<Flower>) flowers).get(0);
        //flower.setStock(500);
        flowerRepository.save(flower);
    }
    @Test
    public void testFindAllFlowersSortedByNameDesc() {
        assertNotNull(flowerRepository);
        Iterable<Flower> flowers=flowerRepository.findAll(new Sort(Sort.Direction.DESC,"stock"));
        for(Flower flower:flowers){
            System.out.println(flower.getName());
        }
        Flower flower=((List<Flower>) flowers).get(0);
        //flower.setStock(500);
        flowerRepository.save(flower);
    }
    @Test
    public void testFindAllFlowersSortedByNameAsc() {
        assertNotNull(flowerRepository);
        Iterable<Flower> flowers=flowerRepository.findAll(new Sort(Sort.Direction.ASC,"stock"));
        for(Flower flower:flowers){
            System.out.println(flower.getName());
        }
        Flower flower=((List<Flower>) flowers).get(0);
        //flower.setStock(500);
        flowerRepository.save(flower);
    }

    @Test
    public void testFindAllFlowersBetween() {
        assertNotNull(flowerRepository);
        Iterable<Flower> flowers=flowerRepository.findByStockBetween(300,500);
        for(Flower flower:flowers){
            System.out.println(flower.getName());
        }
        Flower flower=((List<Flower>) flowers).get(0);
        //flower.setStock(500);
        flowerRepository.save(flower);
    }

    @Test
    public void testFindByNameLike() {
        assertNotNull(flowerRepository);
        Iterable<Flower> flowers=flowerRepository.findByNameLike("%a%");
        for(Flower flower:flowers){
            System.out.println(flower.getName());
        }
        Flower flower=((List<Flower>) flowers).get(0);
        //flower.setStock(500);
        flowerRepository.save(flower);
    }

    @Test
    public void testFindAllCustomers(){
        assertNotNull(customerRepository);
        assertTrue(customerRepository.exists("test"));
        customerRepository.exists("test");
        Iterable<Customer> customers=customerRepository.findAll();
        for(Customer customer:customers){
            System.out.println(customer.getLogin());
        }
    }
    @Test
    public void testFindByLoginAndPassword(){
        assertNotNull(customerRepository.findByLoginAndPassword("test","test"));
        assertNull(customerRepository.findByLoginAndPassword("saewsxscd","dfhsjmk"));
    }
    @Test
    public void testFindAdminByLoginAndPassword(){
        assertNotNull(adminRepository.findByLoginAndPassword("admin","admin123"));
        assertNull(customerRepository.findByLoginAndPassword("saewsxscd","dfhsjmk"));
    }
    @Test
    public void testFindAdminByLogin(){
        assertNotNull(adminRepository.findByLogin("admin"));
        assertNull(adminRepository.findByLogin("saewsxscd"));
    }
}
