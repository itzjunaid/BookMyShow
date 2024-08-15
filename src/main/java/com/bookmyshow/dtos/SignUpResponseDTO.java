package com.bookmyshow.dtos;

import com.bookmyshow.enums.ResponseStatus;

import lombok.Data;

@Data
public class SignUpResponseDTO {
    private Long userId;
    private String message;
    private ResponseStatus responseStatus;
}
