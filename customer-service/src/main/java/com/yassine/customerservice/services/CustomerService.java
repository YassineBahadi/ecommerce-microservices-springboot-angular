package com.yassine.customerservice.services;

import com.yassine.customerservice.entities.Customer;
import com.yassine.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 **/
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;



    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Long id, Customer customer) {

        Customer existingCustomer = findById(id);

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());

        return customerRepository.save(existingCustomer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}
