package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.repositories.FlowerRepository;
import com.accenture.flowershop.be.access.repositories.OrderRepository;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import com.accenture.flowershop.be.entity.order.State;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.flower.FlowerDTO;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class CatalogController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private Map map;
    @Autowired
    BagController bagController;

    public Order createBag(String login) {
        Order bag = new Order(login);
        bag = orderRepository.save(bag);
        bag = orderRepository.findOrderByLoginAndState(login, State.OPENED);
        return bag;
    }

    public void findBag(HttpSession session) throws IOException {
        Customer customer = map.customerToEntity((CustomerDTO) session.getAttribute("customer"));
        Order bag = orderRepository.findOrderByLoginAndState(customer.getLogin(), State.OPENED);
        if (bag == null) {
            bag = createBag(customer.getLogin());
        }
        session.setAttribute("bag",
                map.entityToOrder(bag));
        return;
    }

    public void addToBag(HttpServletRequest request, FlowerDTO flowerDTO) throws IOException {
        HttpSession session = request.getSession();
        Order bag = map.orderToEntity((OrderDTO) session.getAttribute("bag"));
        Customer customer = map.customerToEntity((CustomerDTO) session.getAttribute("customer"));
        List<OrderInfo> bagItems = bag.getOrderInfo();
        for (OrderInfo item : bagItems) {
            if (item.getFlower().equals(flowerDTO.getName())) {
                item.setFloweramount(
                        item.getFloweramount() + flowerDTO.getStock()
                );
                bagController.calculateTotal(bag, customer);
                bag = orderRepository.save(bag);
                bag = orderRepository.findOrderByLoginAndState(customer.getLogin(), State.OPENED);
                session.setAttribute("bag",
                        map.entityToOrder(bag));
                //orderDAO.updateBag(bag);
                return;
            }
        }
        bag.addOrderInfo(new OrderInfo(flowerDTO, bag));
        bagController.calculateTotal(bag, customer);
        bag = orderRepository.save(bag);
        bag = orderRepository.findOrderByLoginAndState(customer.getLogin(), State.OPENED);
        session.setAttribute("bag",
                map.entityToOrder(bag));
        //orderDAO.updateBag(bag);
        //bag=orderDAO.getBag(customer);
        return;
    }

    public List<Flower> sortCatalog(HttpServletRequest request) {
        String sortBy = request.getParameter("sortBy");
        List<Flower> flowers;
        //Dangerous
        if (sortBy == null || sortBy.equals("name")) {
            flowers = flowerRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
        } else if (sortBy.equals("cost")) {
            flowers = flowerRepository.findAll(new Sort(Sort.Direction.ASC, "cost"));
        } else {
            flowers = flowerRepository.findAll(new Sort(Sort.Direction.ASC, "stock"));
        }
        return flowers;
    }

    public void checkFlowers(HttpServletRequest request, List<Flower> flowers) throws IOException {
        for (Flower flower : flowers) {
            if (request.getParameter(flower.getName()) != null) {
                {
                    try {
                        int amount = Integer.parseInt(
                                request.getParameter(flower.getName()));
                        if (amount != 0) {
                            FlowerDTO flowerDTO = map.entityToFlower(flower);
                            flowerDTO.setStock(amount);
                            System.out.println(flower);
                            System.out.println(amount);
                            this.addToBag(request, flowerDTO);
                        }
                    } catch (NumberFormatException e) {
                        return;
                    }
                }
            }
        }
    }

    public void controll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        this.findBag(session);
        //List<Flower> flowers = flowerDAO.findAll();
        List<Flower> flowers=sortCatalog(request);
        List<Order> orders = orderRepository.findOrdersByLogin(
                (map.customerToEntity((CustomerDTO) session.getAttribute("customer")).getLogin()));
        //List<Order> orders=orderDAO.findUserOrders((User)session.getAttribute("customer"));
        session.setAttribute("orders",
                map.listToOrderDTO(orders));
        checkFlowers(request,flowers);

        System.out.println("FLOWERS TO JSP DONE");
        session.setAttribute("flowers",
                map.listToFlowerDTO(flowers));
    }

}
