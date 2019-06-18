package com.accenture.flowershop.be.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends User{
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "MONEY")
    private BigDecimal money;
    @Column(name = "DISCOUNT")
    private int discount;

    public Customer() {
    }

    public Customer(String login, String password, String address, String phone) {
        super(login,password);
        this.address = address;
        this.phone = phone;
        //Форматирование и тд.
        this.setMoney(new BigDecimal(2000));
        this.discount = 0;
    }

    public Customer(String address, String phone, BigDecimal money, int discount) {
        this.address = address;
        this.phone = phone;
        this.money = money;
        this.discount = discount;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMoney() {
        return money.setScale(2, RoundingMode.CEILING);
    }

    public void setMoney(BigDecimal money) {
        this.money = money.setScale(2, RoundingMode.CEILING);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


}
