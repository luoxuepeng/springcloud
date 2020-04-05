package com.lxp2020.order.system.service;

import com.lxp2020.order.system.model.Order;
import com.lxp2020.order.system.model.Product;

public interface OrderService {
    Order getOrderInfoByUserId(String userId);

    Product queryProductById(String id);
}
