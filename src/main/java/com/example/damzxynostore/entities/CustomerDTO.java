package com.example.damzxynostore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class CustomerDTO {
    private int customerId;
    private String email;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String password;
    private Date date;
}
