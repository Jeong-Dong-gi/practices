package org.example.ordersystempractice.service;

import org.example.ordersystempractice.domain.CreateCustomer;
import org.example.ordersystempractice.domain.Customer;
import org.example.ordersystempractice.domain.CustomerDto;
import org.example.ordersystempractice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDto newCustomer(CreateCustomer customer) {
        Customer entity = Customer.newCustomer(customer);
        Customer saved = customerRepository.save(entity);
        return CustomerDto.builder()
                .address(saved.getAddress())
                .name(saved.getName())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
