package com.bookmyshow.controllers;

import com.bookmyshow.dtos.SignUpRequestDTO;
import com.bookmyshow.dtos.SignUpResponseDTO;
import com.bookmyshow.enums.ResponseStatus;
import com.bookmyshow.models.User;
import com.bookmyshow.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignUpResponseDTO signUp(@RequestBody SignUpRequestDTO requestDTO) {
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try {
            User user = userService.signUp(requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUserId(user.getId());
            responseDTO.setMessage("User is created");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
        	responseDTO.setMessage(e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
    
}
