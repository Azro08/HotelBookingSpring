package com.hotel_booking.repository;

import com.hotel_booking.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findByUserId(String userId);

}
