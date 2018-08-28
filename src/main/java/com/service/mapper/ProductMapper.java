package com.service.mapper;


import com.domain.Product;
import com.service.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper implements EntityMapper<ProductDTO, Product> {

    public Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProcuctPrice(dto.getProductPrice());
        product.setProductName(dto.getProductName());
        product.setProductStock(dto.getProductStock());
        return product;
    }

    public ProductDTO toDto(Product entity) {
        ProductDTO dto = new ProductDTO(entity.getProductID(),entity.getProductName(),entity.getProcuctPrice(),entity.getProductStock());
        return dto;
    }

    public List<Product> toEntity(List<ProductDTO> dtoList) {
        List<Product> entityList = new ArrayList<Product>();
        for(ProductDTO dto : dtoList){
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    public List<ProductDTO> toDto(List<Product> entityList) {
        List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
        for(Product entity : entityList){
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
