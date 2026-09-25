package com.yassine.inventoryservice.controllers;

import com.yassine.inventoryservice.entities.Product;
import com.yassine.inventoryservice.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pc
 **/
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product) {

        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
