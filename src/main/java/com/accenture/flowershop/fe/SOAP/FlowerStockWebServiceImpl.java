package com.accenture.flowershop.fe.SOAP;

import com.accenture.flowershop.be.access.repositories.FlowerRepository;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.accenture.flowershop.fe.SOAP.FlowerStockWebService")
public class FlowerStockWebServiceImpl implements FlowerStockWebService{
    @Autowired
    FlowerRepository flowerRepository;
    @WebMethod
    public boolean increaseFlowersStockSize(int count){
        List<Flower> flowers=flowerRepository.findAll();
        for(Flower flower:flowers){
            flower.setStock(
                    flower.getStock()+count);
        }
        flowerRepository.save(flowers);
        return true;
    }
}
