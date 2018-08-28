package com.service.dto;

import com.domain.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Long productID;

    private String productName;

    private float productPrice;

    private int productStock;

    public ProductDTO(){}

    public ProductDTO(Long productID, String productName, float productPrice, int productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
