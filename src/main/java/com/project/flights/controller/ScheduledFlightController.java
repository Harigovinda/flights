package com.project.flights.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.flights.dto.ScheduledFlightDto;
import com.project.flights.entity.Flight;
import com.project.flights.entity.ScheduledFlight;
import com.project.flights.repository.FlightRepo;
import com.project.flights.repository.ScheduledFlightRepo;

@RestController
@RequestMapping("/ScheduledFlight")
public class ScheduledFlightController {
    @Autowired 
     ScheduledFlightRepo scheduledFlightRepo;
     @Autowired
     FlightRepo flightRepo;
     @GetMapping("/show")
     ResponseEntity<?> showall(){
     try{
          List< ScheduledFlight> scheduledFlight =scheduledFlightRepo.findAll();
          if(scheduledFlight.isEmpty()){
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
          }
       List<ScheduledFlightDto>   scheduledFlightDtos=new ArrayList<>();
       for(ScheduledFlight fh:scheduledFlight){
            ScheduledFlightDto fhd= new ScheduledFlightDto();
            
            fhd.setArrivalDate(fh.getArrivalDate());
            fhd.setArrivalTime(fh.getArrivalTime());
            fhd.setDeparturDate(fh.getDeparturDate());
            fhd.setDurationMinutes(fh.getDurationMinutes());
            fhd.setScheduleId(fh.getScheduleId());
            fhd.setDepartureTime(fh.getDepartureTime());
            fhd.setFromCity(fh.getFromCity().getCityCode());
            fhd.setToCity(fh.getToCity().getCityCode());
            fhd.setFlightNo(fh.getFlightNo().getFlightNo());

            scheduledFlightDtos.add(fhd);

       }  return ResponseEntity.ok(scheduledFlightDtos);
     }catch(ResponseStatusException e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
     }
}

//     @PostMapping("/add")
//      public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight){
//             scheduledFlightRepo.save(scheduledFlight);
//             return scheduledFlight;
//      }


//10
     @GetMapping("/allflights/{departurDate}/{cityCode}")
    public ResponseEntity<?> allflights(@RequestParam ("departurDate") LocalDate departurDate,@RequestParam ("cityCode") String cityCode){

          try{
               List< ScheduledFlight> scheduledFlight =scheduledFlightRepo.findAllByDeparturDateAndFromCityCityCode(departurDate,cityCode);
               if(scheduledFlight.isEmpty()){
                     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
               }
          
     List<ScheduledFlightDto>   scheduledFlightDtos=new ArrayList<>();
     for(ScheduledFlight fh:scheduledFlight){
          ScheduledFlightDto fhd= new ScheduledFlightDto();
          
          fhd.setArrivalDate(fh.getArrivalDate());
          fhd.setArrivalTime(fh.getArrivalTime());
          fhd.setDeparturDate(fh.getDeparturDate());
          fhd.setDurationMinutes(fh.getDurationMinutes());
          fhd.setScheduleId(fh.getScheduleId());
          fhd.setDepartureTime(fh.getDepartureTime());
          fhd.setFromCity(fh.getFromCity().getCityCode());
          fhd.setToCity(fh.getToCity().getCityCode());
          fhd.setFlightNo(fh.getFlightNo().getFlightNo());

          scheduledFlightDtos.add(fhd);

     }  return ResponseEntity.ok(scheduledFlightDtos);          
    }catch(Exception ex){
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");

    }
}
//5
     @PreAuthorize("hasRole('Admin')")
    @PostMapping("/adding/{flightNo}/{departurDate}/{arrivalDate}")
    public ResponseEntity<?>addingflight(@RequestParam("flightNo") String flightNo,@RequestParam("departurDate") LocalDate departurDate,@RequestParam("arrivalDate") LocalDate arrivalDate){
      try{
          List<Flight>flights= flightRepo.findByFlightNo(flightNo);
          if(flights.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid flight number");
            }
              ScheduledFlight scheduledFlight=new ScheduledFlight();
              scheduledFlight.setArrivalDate(arrivalDate);
              scheduledFlight.setDeparturDate(departurDate);
             
             for (Flight f : flights) {
               scheduledFlight.setArrivalTime(f.getArrivalTime());
               scheduledFlight.setFlightNo(f);
               scheduledFlight.setFromCity(f.getFromCity());
               scheduledFlight.setToCity(f.getToCity());
               scheduledFlight.setDurationMinutes(f.getDurationMinutes());
               scheduledFlight.setDepartureTime(f.getDepartureTime());
                  
             }
             scheduledFlightRepo.save(scheduledFlight);
           return  ResponseEntity.ok().body("Successfully added");
    }catch(Exception e){
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
    }
}
//7


     @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/cancelallflights/{start}/{end}")
    public ResponseEntity<?> all(@RequestParam ("start")LocalDate start,@RequestParam ("end")LocalDate end){
     try{
          List<ScheduledFlight> scheduledFlights= scheduledFlightRepo.findAllByDeparturDateBetween(start,end);
          if(scheduledFlights.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
          }
               for(ScheduledFlight sf:scheduledFlights){
                    scheduledFlightRepo.deleteById(sf.getScheduleId());
               }

               return ResponseEntity.ok().body("Deleted successfully");
    }catch(Exception e){
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");


    }
}
}
