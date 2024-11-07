package com.example.RVIP_lab1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {

    private Long id;
    private String name;
    private String species;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;
}

