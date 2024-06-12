package com.example.springbootjdbcpractice.controller;

import com.example.springbootjdbcpractice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("products/fetch-product")
    public String getByNameProduct(@RequestParam String firstname) {
        return orderService.getByNameProduct(firstname);
    }
}
