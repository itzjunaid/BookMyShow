package com.bookmyshow.models;

import com.bookmyshow.enums.ShowSeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel {
    //ShowSeat : Show
    //1 : 1
    //M : 1
    @ManyToOne
    private Show show;
    //ShowSeat : Seat
    //1 : 1
    //M : 1
    @ManyToOne
    private Seat seat;
    @Enumerated
    private ShowSeatStatus showSeatStatus;
}
