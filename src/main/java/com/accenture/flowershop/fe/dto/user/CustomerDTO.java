package com.accenture.flowershop.fe.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.RoundingMode;

@XmlRootElement
public class CustomerDTO extends UserDTO {
    @XmlElement
    private String address;
    @XmlElement
    private String phone;
    @XmlElement
    private BigDecimal money;
    @XmlElement
    private int discount;

    public CustomerDTO() {
    }

    public CustomerDTO(String login, String password, String address, String phone) {
        super(login, password);
        this.address = address;
        this.phone = phone;
        //Форматирование и тд.
        this.setMoney(new BigDecimal(2000));
        this.discount = 0;
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", discount=" + discount +
                '}';
    }
}
