package com.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_product", schema = "public")
public class Product implements Serializable {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", allocationSize = 1)
    private Long productID;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private float productPrice;

    @Column(name = "productStock")
    private int productStock;

    public Long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProcuctPrice() {
        return productPrice;
    }

    public void setProcuctPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
