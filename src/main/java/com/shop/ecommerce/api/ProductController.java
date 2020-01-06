package com.shop.ecommerce.api;

import com.shop.ecommerce.entity.Product;
import com.shop.ecommerce.service.ProductService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product) {
        Product inserted = productService.save(product);
        return ResponseEntity.ok(inserted);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product) {
        Product updated = productService.save(product);
        return ResponseEntity.ok(updated);
    }


    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
        productService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
