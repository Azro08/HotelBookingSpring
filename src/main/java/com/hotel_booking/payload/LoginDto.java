package com.hotel_booking.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
