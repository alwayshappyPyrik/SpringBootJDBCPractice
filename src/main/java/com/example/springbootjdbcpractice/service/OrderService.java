package com.example.springbootjdbcpractice.service;

import com.example.springbootjdbcpractice.repository.OrderDAO;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public String getByNameProduct(String firstname) {
        return orderDAO.getProductName(firstname);
    }
}
