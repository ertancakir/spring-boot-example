package com.service;

import com.service.dto.ProductDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void deleteProduct(Long id);

}
