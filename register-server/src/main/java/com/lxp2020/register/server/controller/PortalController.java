package com.lxp2020.register.server.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {

    public String home(){
        System.out.println("================> portal home ");
        return "success";
    }
}
