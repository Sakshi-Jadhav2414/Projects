package com.example.orderservice.dto;

import lombok.Data;

@Data
public class Payment {

    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}