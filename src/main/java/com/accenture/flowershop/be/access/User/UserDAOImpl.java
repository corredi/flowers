package com.accenture.flowershop.be.access.User;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAOImpl implements UserDAO{

    public UserDAOImpl(){

    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean isAdmin(User user) {
        try{
            em.createQuery("from Admin where login=:findlogin and password=:findpassword")
                    .setParameter("findlogin",user.getLogin())
                    .setParameter("findpassword",user.getPassword())
                    .getResultList().get(0);
            return true;
        }
        catch (Exception e){
            //System.out.println("No user found");
            return false;
        }
    }

    @Override
    public boolean isCustomer(User user) {
        try{
            em.createQuery("from Customer where login=:findlogin and password=:findpassword")
                    .setParameter("findlogin",user.getLogin())
                    .setParameter("findpassword",user.getPassword())
                    .getResultList().get(0);
            return true;
        }
        catch (Exception e){
            //System.out.println("No user found");
            return false;
        }
    }

    public boolean isBusyByCustomer(String name){
        try{
            em.createQuery("from Customer where login=:findlogin")
                    .setParameter("findlogin",name)
                    .getResultList().get(0);
            return true;
        }
        catch (Exception e){
            //System.out.println("No user found");
            return false;
        }
    }
    public boolean isBusyByAdmin(String name){
        try{
            em.createQuery("from Admin where login=:findlogin")
                    .setParameter("findlogin",name)
                    .getResultList().get(0);
            return true;
        }
        catch (Exception e){
            //System.out.println("No user found");
            return false;
        }
    }
}
