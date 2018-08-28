package com.service.impl;

import com.domain.Address;
import com.domain.Order;
import com.domain.Product;
import com.domain.User;
import com.repository.AddressRepository;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import com.repository.UserRepository;
import com.service.OrderService;
import com.service.dto.OrderDTO;
import com.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderDTO save(OrderDTO orderDTO) {
        OrderMapper mapper = new OrderMapper();

        Product p = productRepository.findProductByProductID(orderDTO.getProductID());
        User u = userRepository.findUserByUserID(orderDTO.getUserID());
        Address a = addressRepository.findAddressByAddressID(orderDTO.getAddressID());

        Order order = mapper.toEntity(orderDTO);

        order.setUser(u);
        order.setProduct(p);
        order.setAddress(a);

        orderRepository.save(order);

        return null;
    }

    public List<OrderDTO> findAll() {
        return null;
    }

    public OrderDTO findById(Long id) {
        return null;
    }

    public List<OrderDTO> findOrdersByUserID(Long id) {
        return null;
    }
}
