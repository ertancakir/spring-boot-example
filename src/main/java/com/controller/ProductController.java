package com.controller;

import com.domain.Product;
import com.service.OrderService;
import com.service.ProductService;
import com.service.dto.OrderDTO;
import com.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResponseEntity getIndex(){
        List<ProductDTO> dtoList = service.findAll();
        return ResponseEntity.status(200).body(dtoList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity addProduct(@RequestBody ProductDTO productDTO){
        ProductDTO dto = service.save(productDTO);
        return ResponseEntity.status(201).body(dto);
    }

    @RequestMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity getProductById(@PathVariable("id") Long id){
        ProductDTO productDTO = service.findById(id);
        return ResponseEntity.status(200).body(productDTO);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);

        return ResponseEntity.status(200).body("<h1>İlgili kayıt silindi</h1>");
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllOrders(@PathVariable("id") Long uid){
        List<OrderDTO> orders = orderService.findOrdersByUserID(uid);
        return ResponseEntity.status(200).body(orders);
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST, consumes = "application/json", produces = "text/html")
    public ResponseEntity addOrderToUser(@RequestBody OrderDTO orderDTO){
        System.out.println("A: " +orderDTO.getAddressID() + " U:"+orderDTO.getUserID() + " P:" + orderDTO.getProductID());
        orderService.save(orderDTO);
        return ResponseEntity.status(201).body("<h1> Order oluşturuldu </h1>");
    }
}
