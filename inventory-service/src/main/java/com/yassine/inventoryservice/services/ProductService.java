package com.yassine.inventoryservice.services;

import com.yassine.inventoryservice.entities.Product;
import com.yassine.inventoryservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 **/
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {

        Product existingProduct = findById(id);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
