package com.accenture.flowershop.be.access.Flower;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FlowerDAOImpl implements FlowerDAO{
    @PersistenceContext
    private EntityManager em;

    public List<Flower> findAll() {
        return em.createQuery("FROM Flower p").getResultList();
    }

    public Flower findByName(String name) {
        return (Flower) em.createQuery("from Flower where name=:findname").
                setParameter("findname", name.toLowerCase()).getResultList().get(0);
    }
    @Transactional
    public boolean orderFlower(String name, int amount) {
        Flower flower = findByName(name);
        em.createQuery("update Flower set stock = :newStock where name = :oldName")
                .setParameter("newStock", flower.getStock() - amount)
                .setParameter("oldName", flower.getName().toLowerCase())
                .executeUpdate();
        return true;
    }

    @Transactional
    public boolean updateFlowerStock(Flower flower) {
        em.createQuery("update Flower set stock = :newStock where name = :oldName")
                .setParameter("newStock", flower.getStock())
                .setParameter("oldName", flower.getName().toLowerCase())
                .executeUpdate();
        return true;
    }
}