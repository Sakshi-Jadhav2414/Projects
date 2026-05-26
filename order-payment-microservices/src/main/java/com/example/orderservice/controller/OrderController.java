package com.example.orderservice.controller;

import com.example.orderservice.dto.TransactionResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order saveOrder(@RequestBody Order order){
        return service.saveOrder(order);
    }

    @GetMapping("/{id}")
    public TransactionResponse getOrder(@PathVariable int id){
        return service.getOrder(id);
    }
}