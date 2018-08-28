package com.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_order", schema = "public")
public class Order implements Serializable {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", allocationSize = 1)
    private Long orderID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userID")
    private User user;

    @Column(name = "orderAmount")
    private float orderAmount;

    @Column(name = "orderDate")
    private String orderDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressID")
    private Address address;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "productID")
    private Product product;

    public Long getOrderID() {
        return orderID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
