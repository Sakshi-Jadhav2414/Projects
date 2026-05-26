package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment doPayment(@RequestBody Payment payment){
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment getPayment(@PathVariable int orderId){
        return service.getPayment(orderId);
    }
}