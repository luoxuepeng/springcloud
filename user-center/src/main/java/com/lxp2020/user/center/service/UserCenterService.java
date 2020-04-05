package com.lxp2020.user.center.service;

import com.lxp2020.user.center.model.Order;
import com.lxp2020.user.center.model.Product;

public interface UserCenterService {
    Order getOrderByUserId(String userId);

    Product getProductById(String id);
}
