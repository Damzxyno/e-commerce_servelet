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
    private double orderTotal;
    private String orderStatus;
}
