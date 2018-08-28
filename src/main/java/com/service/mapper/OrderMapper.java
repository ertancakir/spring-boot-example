package com.service.mapper;

import com.domain.Order;
import com.domain.User;
import com.service.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements EntityMapper<OrderDTO, Order> {

    public Order toEntity(OrderDTO dto) {
        Order order = new Order();

        order.setOrderAmount(dto.getOrderAmount());
        order.setOrderDate(dto.getOrderDate());

        return order;
    }

    public OrderDTO toDto(Order entity) {
        OrderDTO orderDTO = new OrderDTO();

        /* Columns */
        orderDTO.setOrderID(entity.getOrderID());
        orderDTO.setOrderAmount(entity.getOrderAmount());
        orderDTO.setOrderDate(entity.getOrderDate());

        /* Foreign Keys */
        orderDTO.setAddressID(entity.getAddress().getAddressID());
        orderDTO.setUserID(entity.getUser().getUserID());
        orderDTO.setProductID(entity.getProduct().getProductID());

        return orderDTO;
    }

    public List<Order> toEntity(List<OrderDTO> dtoList) {
        List<Order> entityList = new ArrayList<Order>();
        for(OrderDTO orderDTO : dtoList){
            entityList.add(toEntity(orderDTO));
        }
        return entityList;
    }

    public List<OrderDTO> toDto(List<Order> entityList) {
        List<OrderDTO> dtoList = new ArrayList<OrderDTO>();
        for(Order order : entityList){
            dtoList.add(toDto(order));
        }
        return dtoList;
    }
}
