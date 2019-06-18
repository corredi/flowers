package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import com.accenture.flowershop.be.entity.user.Admin;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.flower.FlowerDTO;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.order.OrderInfoDTO;
import com.accenture.flowershop.fe.dto.user.AdminDTO;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Map {
    private DozerBeanMapper mapper;


    public Map() {
        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));
    }

    User userToEntity(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    UserDTO entityToUser(User user) {
        return mapper.map(user, UserDTO.class);
    }

    FlowerDTO entityToFlower(Flower flower) {
        return mapper.map(flower, FlowerDTO.class);
    }

    Flower flowerToEntity(FlowerDTO flowerDTO) {
        return mapper.map(flowerDTO, Flower.class);
    }

    Order orderToEntity(OrderDTO orderDTO) {
        return mapper.map(orderDTO, Order.class);
    }

    OrderDTO entityToOrder(Order order) {
        return mapper.map(order, OrderDTO.class);
    }

    OrderInfo orderInfoToEntity(OrderInfoDTO orderInfoDTO) {
        return mapper.map(orderInfoDTO, OrderInfo.class);
    }

    OrderInfoDTO orderInfoToEntity(OrderInfo orderInfo) {
        return mapper.map(orderInfo, OrderInfoDTO.class);
    }

    Admin adminToEntity(AdminDTO adminDTO) {
        return mapper.map(adminDTO, Admin.class);
    }

    AdminDTO entityToAdmin(Admin admin) {
        return mapper.map(admin, AdminDTO.class);
    }

    Customer customerToEntity(CustomerDTO customerDTO) {
        return mapper.map(customerDTO, Customer.class);
    }

    CustomerDTO entityToCustomer(Customer customer) {
        return mapper.map(customer, CustomerDTO.class);
    }

    List<OrderDTO> listToOrderDTO(List<Order> orders) {
        List<OrderDTO> temp = new ArrayList<>();
        for (Order order : orders) {
            temp.add(entityToOrder(order));
        }
        return temp;
    }

    List<Order> listToOrderEntity(List<OrderDTO> orderDTOs) {
        List<Order> temp = new ArrayList<>();
        for (OrderDTO orderDTO : orderDTOs) {
            temp.add(orderToEntity(orderDTO));
        }
        return temp;
    }

    List<FlowerDTO> listToFlowerDTO(List<Flower> flowers) {
        List<FlowerDTO> temp = new ArrayList<>();
        for (Flower flower : flowers) {
            temp.add(entityToFlower(flower));
        }
        return temp;
    }
}
