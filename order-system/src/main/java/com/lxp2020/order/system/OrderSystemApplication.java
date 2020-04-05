package com.lxp2020.order.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class OrderSystemApplication {
    public static String serverName;

    public static void main(String[] args) {
        serverName = System.getProperty("type");
        log.info("======>>>>>>>>>>  current server is : " + serverName);
        SpringApplication.run(OrderSystemApplication.class, args);
    }

}
