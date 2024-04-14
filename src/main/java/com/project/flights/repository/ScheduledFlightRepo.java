package com.project.flights.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.flights.entity.ScheduledFlight;
@Repository
public interface ScheduledFlightRepo extends JpaRepository<ScheduledFlight,Long>{


    List<ScheduledFlight> findAllByDeparturDateAndFromCityCityCode(LocalDate departurDate, String cityCode);

    List<ScheduledFlight>  findAllByDeparturDateBetween(LocalDate startDate, LocalDate endDate);

}
