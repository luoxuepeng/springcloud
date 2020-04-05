package com.lxp2020.user.center.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String serverName;
    private String id;
    private List<Product> productList;
    private String desc;
    private String userId;
    private double price;
    private int count;
}
