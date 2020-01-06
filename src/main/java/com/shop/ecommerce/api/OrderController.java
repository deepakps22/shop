package com.shop.ecommerce.api;

import com.shop.ecommerce.entity.Customer;
import com.shop.ecommerce.entity.Order;
import com.shop.ecommerce.entity.OrderProduct;
import com.shop.ecommerce.entity.Product;
import com.shop.ecommerce.exception.InvalidProductException;
import com.shop.ecommerce.model.OrderItemsRequest;
import com.shop.ecommerce.model.OrderProductRequest;
import com.shop.ecommerce.service.CustomerService;
import com.shop.ecommerce.service.OrderService;
import com.shop.ecommerce.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customers/{customerId}/orders")
public class OrderController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;

    public OrderController(CustomerService customerService, ProductService productService, OrderService orderService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@PathVariable("customerId") long customerId, @RequestBody OrderItemsRequest orderItemsRequest) {
    	Optional<Customer> customer = customerService.findById(customerId);

        if(!customer.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

        for(OrderProductRequest orderProductRequest: orderItemsRequest.getItems()){
        	Optional<Product>  product = productService.findById(orderProductRequest.getId());
            if(!product.isPresent()) {
                return ResponseEntity.badRequest().body("invalid productId: " + orderProductRequest.getId());
            }
            orderProducts.add(new OrderProduct(product.get(), orderProductRequest.getAmount()));
        }

        try {
            Order order = orderService.createOrder(customer.get(), orderProducts);
            return ResponseEntity.ok(order);
        } catch (InvalidProductException e) {
            return ResponseEntity.badRequest().body("product not available in stock. detail: " + e.getMessage());
        }

    }
}
