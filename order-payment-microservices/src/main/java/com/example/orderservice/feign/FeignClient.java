package com.example.orderservice.feign;

import com.example.orderservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PAYMENT-SERVICE", url = "http://localhost:8080/payment")
public interface PaymentFeignClient {

    @GetMapping("/{orderId}")
    Payment getPayment(@PathVariable int orderId);
}