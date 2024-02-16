package com.hotel_booking.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "favorite_hotels")
public class FavoriteHotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private String hotelId;
    private String name;
    private String neighborhood;
    private String price;
    private String imageUrl;
    private Double review;
}
