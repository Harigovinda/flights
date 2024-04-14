package com.project.flights.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.flights.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight,String>{

    List<Flight> findByFromCityCityCodeAndToCityCityCode(String fromCity, String toCity);

    List<Flight> findByFlightNo(String flightNo);


    
}



