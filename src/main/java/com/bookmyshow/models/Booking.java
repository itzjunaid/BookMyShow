package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

import com.bookmyshow.enums.BookingStatus;

@Data
@Entity(name = "bookings")
public class Booking extends BaseModel {
    //Booking : Show
    //1 : 1
    //M : 1
    @ManyToOne
    private Show show;
    private Double amount;

    //Booking : ShowSeat
    //1 : M
    //M : 1
    @ManyToMany
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    //Booking : User
    //1 : 1
    //M : 1
    @ManyToOne
    private User user;

    //Booking : Payment
    //1 : M
    //1 : 1
    @OneToMany
    private List<Payment> payments;
    private Date bookedAt;
}
