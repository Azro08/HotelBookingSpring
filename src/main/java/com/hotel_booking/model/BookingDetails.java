package com.hotel_booking.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "booking_details")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String hotelName;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private String checkInDate;
    private String checkOutDate;
    private int adultNumber;
    private int childrenNum;
    private String paymentType;
    private int cardNumber;
    private boolean isApproved;
    private double totalPrice;
}
