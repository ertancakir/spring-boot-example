package com.service;

import com.service.dto.OrderDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface OrderService {

    OrderDTO save(OrderDTO orderDTO);

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    List<OrderDTO> findOrdersByUserID(Long id);

}
