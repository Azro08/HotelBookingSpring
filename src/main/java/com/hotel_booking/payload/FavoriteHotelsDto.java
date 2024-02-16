package com.hotel_booking.payload;

import lombok.Data;

@Data
public class FavoriteHotelsDto {
    private String userId;
    private String hotelId;
    private String name;
    private String neighborhood;
    private String price;
    private String imageUrl;
    private Double review;
}