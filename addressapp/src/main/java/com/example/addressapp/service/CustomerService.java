package com.example.addressapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.addressapp.model.Customer;
import com.example.addressapp.form.CustomerForm;
import com.example.addressapp.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    public Customer find(Integer id) {
        return customerRepository.getOne(id);
    }

    public void update(CustomerForm customerForm) {
        Customer customer = customerRepository.getOne(customerForm.getId());
        customer.setName(customerForm.getName());
        customer.setAddress(customerForm.getAddress());
        customer.setPhoneNumber(customerForm.getPhoneNumber());
        customerRepository.save(customer);
    }

    public void insert(CustomerForm customerForm) {
        Customer customer = new Customer();
        customer.setName(customerForm.getName());
        customer.setAddress(customerForm.getAddress());
        customer.setPhoneNumber(customerForm.getPhoneNumber());
        customerRepository.save(customer);
    }
}