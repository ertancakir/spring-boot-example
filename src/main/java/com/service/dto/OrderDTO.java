package com.service.dto;


import java.io.Serializable;

public class OrderDTO implements Serializable {

    private Long orderID;

    private Long userID;

    private float orderAmount;

    private String orderDate;

    private Long addressID;

    private Long productID;

    public OrderDTO(){}


    public OrderDTO(Long orderID, Long userID, float orderAmount, String orderDate, Long addressID, Long productID) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.addressID = addressID;
        this.productID = productID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }
}
