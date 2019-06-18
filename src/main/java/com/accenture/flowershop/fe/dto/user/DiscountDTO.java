package com.accenture.flowershop.fe.dto.user;

public class DiscountDTO {
    String login;
    int discount;

    public DiscountDTO() {
    }

    public DiscountDTO(String login, int discount) {
        this.login = login;
        this.discount = discount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountDTO{" +
                "login='" + login + '\'' +
                ", discount=" + discount +
                '}';
    }
}
