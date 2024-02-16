package com.hotel_booking.controller;

import com.hotel_booking.model.FavoriteHotels;
import com.hotel_booking.payload.FavoriteHotelsDto;
import com.hotel_booking.repository.FavoriteHotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteHotelsController {

    @Autowired
    FavoriteHotelsRepository favoriteHotelsRepository;

    @PostMapping("/save_hotel")
    public ResponseEntity<String> saveHotel(@RequestBody FavoriteHotelsDto favoriteHotelsDto) {

        if (favoriteHotelsRepository.existsByHotelId(favoriteHotelsDto.getHotelId())) {
            return new ResponseEntity<>("Hotel is already saved!", HttpStatus.BAD_REQUEST);
        }

        FavoriteHotels favoriteHotel = new FavoriteHotels();
        favoriteHotel.setUserId(favoriteHotelsDto.getUserId());
        favoriteHotel.setHotelId(favoriteHotelsDto.getHotelId());
        favoriteHotel.setName(favoriteHotelsDto.getHotelId());
        favoriteHotel.setNeighborhood(favoriteHotelsDto.getHotelId());
        favoriteHotel.setPrice(favoriteHotelsDto.getPrice());
        favoriteHotel.setReview(favoriteHotelsDto.getReview());

        favoriteHotelsRepository.save(favoriteHotel);

        return new ResponseEntity<>("Hotel saved", HttpStatus.OK);
    }

}
