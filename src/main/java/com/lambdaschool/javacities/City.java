package com.lambdaschool.javacities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class City {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private double medianHomePrice;
    private int affordabilityIndex;

    public City() {
    }

    public City(String name, double medianHomePrice, int affordabilityIndex) {
        this.name = name;
        this.medianHomePrice = medianHomePrice;
        this.affordabilityIndex = affordabilityIndex;
    }
}
