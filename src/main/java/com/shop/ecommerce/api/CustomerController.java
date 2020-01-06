package com.shop.ecommerce.api;

import com.shop.ecommerce.entity.Customer;
import com.shop.ecommerce.service.CustomerService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        Customer inserted = customerService.save(customer);
        return ResponseEntity.ok(inserted);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Customer customer) {
    	Customer updated = customerService.save(customer);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
    	Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
        customerService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
