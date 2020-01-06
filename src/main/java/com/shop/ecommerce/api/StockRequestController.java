package com.shop.ecommerce.api;

import com.shop.ecommerce.entity.StockItem;
import com.shop.ecommerce.entity.StockRequest;
import com.shop.ecommerce.model.StockItemRequest;
import com.shop.ecommerce.model.StockItemResponse;
import com.shop.ecommerce.model.StockRequestItem;
import com.shop.ecommerce.model.StockRequestRequest;
import com.shop.ecommerce.service.ProductService;
import com.shop.ecommerce.service.StockService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stockRequest")
public class StockRequestController {

    private final StockService stockService;
    private final ProductService productService;

    public StockRequestController(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StockRequestRequest stockRequestRequest) {
        for (StockRequestItem stockRequestItem: stockRequestRequest.getItems()) {

        	Optional<StockItem> stockItem = stockService.findByProductId(stockRequestItem.getProductId());

            if (!stockItem.isPresent()) {
                return ResponseEntity.badRequest().body("the store does not work with this type of product. id:" + stockRequestItem.getProductId());
            } else {
                stockItem.get().setAmount(stockItem.get().getAmount() + stockRequestItem.getAmount());
                stockService.save(stockItem.get());
            }
        }
        return ResponseEntity.ok("stock has been updated");
    }
}
