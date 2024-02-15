package com.hotel_booking.controller;

import com.hotel_booking.model.BookingDetails;
import com.hotel_booking.payload.BookingDetailsDto;
import com.hotel_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/book_hotel")
    public ResponseEntity<String> bookHotel(@RequestBody BookingDetailsDto bookingDetailsDto){

        BookingDetails bookingDetails = new BookingDetails();

        bookingDetails.setHotelName(bookingDetailsDto.getHotelName());
        bookingDetails.setUserId(bookingDetailsDto.getUserId());
        bookingDetails.setFirstName(bookingDetailsDto.getFirstName());
        bookingDetails.setLastName(bookingDetailsDto.getLastName());
        bookingDetails.setEmail(bookingDetailsDto.getEmail());
        bookingDetails.setPhoneNum(bookingDetailsDto.getPhoneNum());
        bookingDetails.setCheckInDate(bookingDetailsDto.getCheckInDate());
        bookingDetails.setCheckOutDate(bookingDetailsDto.getCheckOutDate());
        bookingDetails.setAdultNumber(bookingDetailsDto.getAdultNumber());
        bookingDetails.setChildrenNum(bookingDetailsDto.getChildrenNum());
        bookingDetails.setPaymentType(bookingDetailsDto.getPaymentType());
        bookingDetails.setCardNumber(bookingDetailsDto.getCardNumber());
        bookingDetails.setApproved(bookingDetailsDto.isApproved());
        bookingDetails.setTotalPrice(bookingDetailsDto.getTotalPrice());

        bookingRepository.save(bookingDetails);

        return new ResponseEntity<>("Hotel booked", HttpStatus.OK);

    }

}
