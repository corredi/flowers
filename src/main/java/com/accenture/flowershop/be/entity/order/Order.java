package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.user.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDERID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence_gen")
    @SequenceGenerator(name = "order_sequence_gen", sequenceName = "ORDER_SEQ",allocationSize = 1)
    private long orderId;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "TOTAL")
    private double totalCost;
    /*
    @Column(name = "STATE")
    private String state;
    */
    @Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    private State state;
    @Column(name = "OPENDATE")
    private LocalDateTime openDate;
    @Column(name = "CLOSEDATE")
    private LocalDateTime closeDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    //@JoinColumn(name = "orderId")
    private List<OrderInfo> orderInfo = new LinkedList<OrderInfo>();

    public Order() {
    }

    public Order(String login){
        this.setLogin(login);
        this.state=State.OPENED;
    }
    public Order(Customer customer){
        this.setLogin(customer.getLogin());
        this.state=State.OPENED;
    }

    public Order(List<Flower> flowers, Customer customer){
        //List<OrderInfo> orderInfo=new LinkedList<OrderInfo>();
        for(Flower flower:flowers){
            OrderInfo temp=new OrderInfo();
            temp.setFlower(flower.getName());
            temp.setCost(flower.getCost());
            temp.setFloweramount(flower.getStock());
            temp.setOrder(this);
            orderInfo.add(temp);
            //this.addOrderInfo(temp);
        }
        //this.setOrderInfo(orderInfo);
        this.setState(State.PAID);
        this.setLogin(customer.getLogin());
    }
    public Order(int orderId, String login, double totalCost, State state, LocalDateTime openDate,
                 LocalDateTime closeDate, List<OrderInfo> orderInfo) {
        this.orderId = orderId;
        this.login = login;
        this.totalCost = totalCost;
        this.state = state;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.orderInfo = orderInfo;
    }

    public void addOrderInfo(OrderInfo orderInfo) {
        this.orderInfo.add(orderInfo);
        orderInfo.setOrder(this);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<OrderInfo> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<OrderInfo> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", login='" + login + '\'' +
                ", totalCost=" + totalCost +
                ", state='" + state + '\'' +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", orderInfo=" + orderInfo +
                '}';
    }
}
