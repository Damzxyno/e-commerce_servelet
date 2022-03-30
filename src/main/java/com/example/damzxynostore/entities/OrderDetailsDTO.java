package com.example.damzxynostore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderDetailsDTO {
    private int orderId;
    private int product_id;
    private int quantity;
    private int subTotal;
}
