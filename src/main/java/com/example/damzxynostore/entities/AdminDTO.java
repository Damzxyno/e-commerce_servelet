package com.example.damzxynostore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AdminDTO {
    private int adminId;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
}
