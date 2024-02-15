package com.hotel_booking.payload;

import lombok.Data;

@Data
public class BookingDetailsDto {
    private String bookId;
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