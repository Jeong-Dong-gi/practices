package org.example.ordersystempractice.repository;

import org.example.ordersystempractice.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
