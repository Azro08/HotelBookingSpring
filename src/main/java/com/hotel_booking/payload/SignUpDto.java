package com.hotel_booking.payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String email;
    private String password;
    private String role;
}
