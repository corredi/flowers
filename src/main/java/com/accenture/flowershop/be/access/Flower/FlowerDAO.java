package com.accenture.flowershop.be.access.Flower;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//import static org.hibernate.jpa.AvailableSettings.PERSISTENCE_UNIT_NAME;
@Service
public interface FlowerDAO {
    public List<Flower> findAll();
    public Flower findByName(String name);
    public boolean orderFlower(String name, int amount);
    public boolean updateFlowerStock(Flower flower);
}
