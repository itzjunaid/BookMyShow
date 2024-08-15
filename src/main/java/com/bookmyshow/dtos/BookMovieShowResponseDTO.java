package com.bookmyshow.dtos;

import com.bookmyshow.enums.ResponseStatus;

import lombok.Data;

@Data
public class BookMovieShowResponseDTO {
    private Long bookingId;
    private double amount;
    private ResponseStatus responseStatus;
}
