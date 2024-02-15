package com.hotel_booking.repository;

import com.hotel_booking.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingDetails, Long> {



}
