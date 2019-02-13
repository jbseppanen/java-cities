package com.lambdaschool.javacities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CityRepository extends JpaRepository<City, Long> {
    ArrayList<City> findByAffordabilityIndexLessThan(int affIndex);
    ArrayList<City> findByMedianHomePriceGreaterThan(double price);
}