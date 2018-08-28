package com.repository;

import com.domain.Order;
import com.domain.Product;
import com.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    /* Return Orders By Product */
    List<Order> getOrdersByProduct(Product p);

    /* Return Orders By Users */
    List<Order> getOrdersByUser(User u);
}
