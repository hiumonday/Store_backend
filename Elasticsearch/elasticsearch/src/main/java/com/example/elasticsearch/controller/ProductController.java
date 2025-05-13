package com.example.elasticsearch.controller;

import com.example.elasticsearch.model.Product;
import com.example.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product Product) {
        return productService.saveProduct(Product);
    }

    @GetMapping("/getAll")
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam String name) {
        return productService.findByName(name);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
    }
}
