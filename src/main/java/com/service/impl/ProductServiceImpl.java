package com.service.impl;

import com.domain.Product;
import com.repository.ProductRepository;
import com.service.ProductService;
import com.service.dto.ProductDTO;
import com.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    /*
    * Bu class ın değişmesi gerekiyor
    * Mapping işlemleri controller a alınmalı
    * Bu classtan controller ve repositorylere entity gönderilmeli*/

    @Autowired
    ProductRepository repository;

    public ProductDTO save(ProductDTO productDTO) {
        ProductMapper productMapper = new ProductMapper();
        Product p = productMapper.toEntity(productDTO);
        repository.save(p);
        return productDTO;
    }

    public List<ProductDTO> findAll() {
        ProductMapper productMapper = new ProductMapper();
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        Iterable<Product> products = repository.findAll();

        for(Product p : products){
            productDTOList.add(productMapper.toDto(p));
        }
        return productDTOList;
    }

    public ProductDTO findById(Long id) {
        Product p = repository.findProductByProductID(id);
        ProductMapper mapper = new ProductMapper();

        return mapper.toDto(p);
    }

    public void deleteProduct(Long id) {
        Product p = repository.findProductByProductID(id);
        repository.delete(p);
    }
}
