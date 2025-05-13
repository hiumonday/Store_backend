package com.example.elasticsearch.service;

import com.example.elasticsearch.model.Product;
import com.example.elasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }


    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }


    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
