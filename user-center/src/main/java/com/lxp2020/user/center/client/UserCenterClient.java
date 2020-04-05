package com.lxp2020.user.center.client;

import com.lxp2020.user.center.client.impl.UserCenterClientFallback;
import com.lxp2020.user.center.model.Order;
import com.lxp2020.user.center.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "ORDER-SYSTEM", fallback = UserCenterClientFallback.class, qualifier = "userCenterClient")
public interface UserCenterClient {

    @RequestMapping(value = "/order/info", method = RequestMethod.GET)
    Order getOrderByUserId(@RequestParam("userId") String userId);

    @RequestMapping(value = "/order/product", method = RequestMethod.GET)
    Product getProductById(@RequestParam("id") String id);
}

