package com.accenture.flowershop.be.access.User;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public boolean registerUser(Customer customer) {
        em.persist(customer);
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            session.beginTransaction();
            UserDTO user=new UserDTO(customer.getLogin(),password);
            session.save(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("EEEEEEEEXC");
            return false;
        }
        finally {
            session.close();
        }
        */
        return true;
    }
    @Transactional
    public boolean deleteUserInfo(String name) {
        User user=new User();
        user.setLogin(name);
        Customer customer;
        customer=getUserInfo(user);
        em.remove(user);
        em.remove(customer);
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{

            session.beginTransaction();

            session.delete(customer);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("EEEEEEEEXC");
            return false;
        }
        finally {
            session.close();
        }
        */
        return true;
    }
    @Transactional
    public boolean deleteUser(String name) {
        User user=new User();
        user.setLogin(name);
        em.remove(user);
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            UserDTO user=new UserDTO();
            user.setLogin(name);
            session.delete(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("EEEEEEEEXC");
            return false;
        }
        finally {
            session.close();
        }
        /*/
        return true;
    }
    @Transactional
    public boolean updateUser(Customer customer){
        em.merge(customer);
        return true;
    }

    public Customer getUserInfo(User user) {
        return (Customer) em.createQuery("from Customer where login=:findlogin").
                setParameter("findlogin", user.getLogin()).getResultList().get(0);
    }
}
