package ru.isupden.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Point {
    private double x;
    private double y;
    private double r;
    private Boolean hit;
    private LocalDateTime time;
    private long scriptTime;


}
