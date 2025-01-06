package org.example.ordersystempractice.repository;

import org.example.ordersystempractice.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
