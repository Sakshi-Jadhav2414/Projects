package com.example.orderservice.service;

import com.example.orderservice.dto.Payment;
import com.example.orderservice.dto.TransactionResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.feign.PaymentFeignClient;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private PaymentFeignClient feignClient;

    public Order saveOrder(Order order){
        return repository.save(order);
    }

    public TransactionResponse getOrder(int id){

        Order order = repository.findById(id).orElse(null);

        Payment payment = feignClient.getPayment(id);

        double total = order.getQty() * order.getPrice();

        return new TransactionResponse(order,payment,total);
    }
}