package com.shop.ecommerce.model;

import java.util.Set;

public class OrderItemsRequest {
    Set<OrderProductRequest> items;

    public Set<OrderProductRequest> getItems() {
        return items;
    }

    public void setItems(Set<OrderProductRequest> items) {
        this.items = items;
    }
}
