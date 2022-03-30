package com.example.damzxynostore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductDTO {
    private int productId;
    private String productName;
    private byte image;
    private double price;
    private String description;
    private int categoryId;
}
