package com.yassine.customerservice.repositories;

import com.yassine.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pc
 **/
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
