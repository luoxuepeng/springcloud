package com.lxp2020.order.system.model;

import com.lxp2020.order.system.OrderSystemApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String serverName;
    private String id;
    private String desc;
    private double price;
    private String name;
}
