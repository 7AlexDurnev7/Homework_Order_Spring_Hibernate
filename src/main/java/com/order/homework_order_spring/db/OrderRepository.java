package com.order.homework_order_spring.db;

import org.springframework.data.repository.CrudRepository;

// DAO - interface
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
