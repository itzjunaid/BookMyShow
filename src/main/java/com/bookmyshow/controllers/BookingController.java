package com.bookmyshow.controllers;

import com.bookmyshow.dtos.BookMovieShowRequestDTO;
import com.bookmyshow.dtos.BookMovieShowResponseDTO;
import com.bookmyshow.enums.ResponseStatus;
import com.bookmyshow.models.Booking;
import com.bookmyshow.services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

 
    @PostMapping("/booking")
    public BookMovieShowResponseDTO bookTicket(@RequestBody BookMovieShowRequestDTO requestDTO) {
    	System.out.println(requestDTO.getUserId() +" / "+requestDTO.getShowId() +" / "+requestDTO.getShowSeatIds());
        BookMovieShowResponseDTO responseDTO = new BookMovieShowResponseDTO();
        try {
            Booking booking = bookingService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatIds());
            responseDTO.setBookingId(booking.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
