package com.hotel_booking.repository;

import com.hotel_booking.model.BookingDetails;
import com.hotel_booking.model.FavoriteHotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteHotelsRepository extends JpaRepository<FavoriteHotels, Long> {
    Boolean existsByHotelId(String hotelId);
}
