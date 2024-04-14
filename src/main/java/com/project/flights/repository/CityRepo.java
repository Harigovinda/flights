package com.project.flights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.flights.entity.City;
@Repository
public interface CityRepo extends JpaRepository<City,String> {
    @Query("Select c.cityName from City c ")
    List<String> allCities();

    String getByCityCode(String fromCity);

}
