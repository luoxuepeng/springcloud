package com.lxp2020.order.system.controller;

import com.lxp2020.order.system.model.Order;
import com.lxp2020.order.system.model.Product;
import com.lxp2020.order.system.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/info")
    public Order getOrderInfo(String  userId){
        Order order = orderService.getOrderInfoByUserId(userId);
        log.info("order : " + order.toString());
        return order;
    }

    @GetMapping("/product")
    public Product queryProductInfo(String id){
        Product product = orderService.queryProductById(id);
        log.info("product : " + product.toString());
        return product;
    }
}
