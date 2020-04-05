package com.lxp2020.order.system.service.impl;

import com.lxp2020.order.system.db.DataStore;
import com.lxp2020.order.system.model.Order;
import com.lxp2020.order.system.model.Product;
import com.lxp2020.order.system.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderInfoByUserId(String userId) {
        return DataStore.getOrderByUserId(userId);
    }

    @Override
    public Product queryProductById(String id) {
        return DataStore.getProductById(id);
    }
}
