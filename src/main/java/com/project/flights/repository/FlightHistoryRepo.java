package com.project.flights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.flights.entity.FlightHistory;
@Repository
public interface FlightHistoryRepo  extends JpaRepository<FlightHistory,Long> {
    //     @Query(value = "Select * from flight_history where flight_no = :flightno",nativeQuery = true)
    // List<FlightHistory> FindByFlightNo(@Param ("flightno")String flightno);

    List<FlightHistory> findByFlightFlightNo(String flightNo);
  @Query(value ="select fh.* from  flight_history fh join flight f on f.flight_no = fh.flight_no where  fh.duration_minutes - f.duration_minutes = :minutes" ,nativeQuery = true)
        List<FlightHistory> allflights(@Param("minutes") int minutes);

}