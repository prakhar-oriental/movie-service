package com.example.model;

import lombok.Data;

@Data
public class TheaterDTO {
    private Long id;
    private String name;
    private String location;
    private int totalScreens;
    private int seatingCapacity;
}