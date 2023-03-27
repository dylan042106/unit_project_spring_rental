package com.unitproject.Unit.Project.Spring.Base.services;

import com.unitproject.Unit.Project.Spring.Base.contollers.CustomerController;
import com.unitproject.Unit.Project.Spring.Base.entities.Customer;
import com.unitproject.Unit.Project.Spring.Base.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> compareToOthers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getByEmail(String custEmail) {
        return customerRepository.getByEmail(custEmail);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
