package com.example.damzxynostore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class OrderTableDTO {
    private int orderId;
    private int customerId;
    private Date orderDate;
    private String shippingAddress;
    private String recipientName;
    private String recipientPhone;
    private String paymentMethod;
    private double orderTotal;
    private int orderStatus;
}
