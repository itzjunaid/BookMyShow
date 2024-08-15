package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.bookmyshow.enums.Feature;

@Data
@Entity(name = "screens")
public class Screen extends BaseModel {
    private String name;
    //Screen : Theatre
    //1 : 1
    //M : 1
    @ManyToOne
    private Theatre theatre;
    //Screen : Seat
    //1 : M
    //1 : 1
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
