package com.lxp2020.order.system.db;

import com.lxp2020.order.system.OrderSystemApplication;
import com.lxp2020.order.system.model.Order;
import com.lxp2020.order.system.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DataStore {
    private static List<Product> productList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();
    private static final Random random = new Random();
    private static final int MAX_LEN = 10;

    static {
        for(int i =0; i<MAX_LEN ;i++){
            BigDecimal bg = new BigDecimal(random.nextInt(2000) / 100.00);
            Product product = Product.builder()
                    .id(UUID.randomUUID().toString().replaceAll("-",""))
                    .name(UUID.randomUUID().toString().substring(2,12))
                    .desc("computer")
                    .price(bg.setScale(2, RoundingMode.HALF_UP).doubleValue())
                    .serverName(OrderSystemApplication.serverName)
                    .build();
            productList.add(product);
        }
        for(int i =0; i<MAX_LEN ;i++){
            BigDecimal bg = new BigDecimal(random.nextInt(2000) / 100.00);
            Order order = Order.builder()
                    .id(UUID.randomUUID().toString().replaceAll("-",""))
                    .count(random.nextInt(100))
                    .price(bg.setScale(2, RoundingMode.HALF_UP).doubleValue())
                    .desc("product "+ i)
                    .serverName(OrderSystemApplication.serverName)
                    .build();
            orderList.add(order);
        }
    }

    public static Order getOrderByUserId(String userId){
        Order order = orderList.get(random.nextInt(MAX_LEN));
        ArrayList<Product> products = new ArrayList<>();
        int len = random.nextInt(MAX_LEN);
        for(int i =0; i<len; i++){
            products.add(productList.get(random.nextInt(MAX_LEN)));
        }
        order.setServerName(OrderSystemApplication.serverName);
        order.setProductList(products);
        return order;
    }

    public static Product getProductById(String id){
        Product product = productList.get(random.nextInt(MAX_LEN));
        product.setId(id);
        product.setServerName(OrderSystemApplication.serverName);
        return product;
    }
}
