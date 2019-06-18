package com.accenture.flowershop.fe.SOAP;

import org.springframework.test.context.ContextConfiguration;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@WebService//(name = "increaseFlowersStockSize")
public interface FlowerStockWebService {
    @WebMethod
    public boolean increaseFlowersStockSize(int count);
}
