package com.geekster.EcommerceAPI.controllers;

import com.geekster.EcommerceAPI.models.Order;
import com.geekster.EcommerceAPI.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public String addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
}
