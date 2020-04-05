package com.lxp2020.user.center.controller;

import com.lxp2020.user.center.model.Order;
import com.lxp2020.user.center.model.Product;
import com.lxp2020.user.center.service.UserCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserCenterController {

    private final UserCenterService userCenterService;

    @Autowired
    public UserCenterController(UserCenterService userCenterService) {
        this.userCenterService = userCenterService;
    }

    @GetMapping("home")
    public String home(){
        log.info("============ >>>  success");
        return "success";
    }

    @GetMapping("order")
    public Order getOrderInfo(String userId) {
        Order order = userCenterService.getOrderByUserId(userId);
        log.info("order : " + order.toString());
        return order;
    }


    @GetMapping("product")
    public Product getProductById(String id) {
        Product product = userCenterService.getProductById(id);
        log.info("product : " + product.toString());
        return product;
    }
}
