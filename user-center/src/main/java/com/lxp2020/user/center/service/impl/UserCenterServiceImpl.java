package com.lxp2020.user.center.service.impl;

import com.lxp2020.user.center.client.UserCenterClient;
import com.lxp2020.user.center.model.Order;
import com.lxp2020.user.center.model.Product;
import com.lxp2020.user.center.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserCenterServiceImpl implements UserCenterService {

    private final UserCenterClient userCenterClient;

    public UserCenterServiceImpl(@Qualifier("com.lxp2020.user.center.client.UserCenterClient") UserCenterClient userCenterClient) {
        this.userCenterClient = userCenterClient;
    }


    @Override
    public Order getOrderByUserId(String userId) {
        return userCenterClient.getOrderByUserId(userId);
    }

    @Override
    public Product getProductById(String id) {
        return userCenterClient.getProductById(id);
    }
}
