package com.yassine.inventoryservice.repositories;

import com.yassine.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pc
 **/
public interface ProductRepository extends JpaRepository<Product,Long> {
}
