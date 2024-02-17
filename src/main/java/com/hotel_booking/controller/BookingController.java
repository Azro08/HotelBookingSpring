package com.hotel_booking.controller;

import com.hotel_booking.model.BookingDetails;
import com.hotel_booking.payload.BookingDetailsDto;
import com.hotel_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/book_hotel")
    public ResponseEntity<String> bookHotel(@RequestBody BookingDetailsDto bookingDetailsDto) {

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

    @GetMapping("/get_booked_hotels")
    public ResponseEntity<List<BookingDetails>> getBookedHotels(@RequestParam("userId") String userId) {
        List<BookingDetails> bookedHotels = bookingRepository.findByUserId(userId);
        if (bookedHotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // or any other appropriate response
        }
        return new ResponseEntity<>(bookedHotels, HttpStatus.OK);
    }

    @GetMapping("/get_booking_details")
    public ResponseEntity<BookingDetails> getBookingDetails(@RequestParam("bookingId") Long bookingId) {
        Optional<BookingDetails> bookingDetailsOptional = bookingRepository.findById(bookingId);
        if (bookingDetailsOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // or any other appropriate response
        }
        return new ResponseEntity<>(bookingDetailsOptional.get(), HttpStatus.OK);
    }

}
