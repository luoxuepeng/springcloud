package com.lxp2020.user.center.client.impl;

import com.lxp2020.user.center.client.UserCenterClient;
import com.lxp2020.user.center.model.Order;
import com.lxp2020.user.center.model.Product;
import org.springframework.stereotype.Component;

@Component
public class UserCenterClientFallback implements UserCenterClient {
   @Override
    public Order getOrderByUserId(String userId) {
        Order order = Order.builder()
                .id("default")
                .count(0)
                .desc("default")
                .price(0.00)
                .userId(userId)
                .build();
        return order;
    }

    @Override
    public Product getProductById(String id) {
        Product product = Product.builder()
                .id("default")
                .name("default")
                .price(0.00)
                .desc("default")
                .build();
        return product;
    }
}
