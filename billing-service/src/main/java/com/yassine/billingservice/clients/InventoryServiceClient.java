package com.yassine.billingservice.clients;

import com.yassine.billingservice.dtos.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author pc
 **/
@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
