package com.project.flights.controller;

import java.time.LocalDate;
// import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.project.flights.dto.FlightHistoryDto;
import com.project.flights.entity.Flight;
import com.project.flights.entity.FlightHistory;

import com.project.flights.repository.FlightHistoryRepo;
import com.project.flights.repository.FlightRepo;


@RestController
public class FlightHistoryController {
    @Autowired
    FlightHistoryRepo flightHistoryRepo;
    @Autowired
    FlightRepo flightRepo;

    @GetMapping("/alls")
     public ResponseEntity<?> history(){
      try{
        List<FlightHistory> flightHistories =flightHistoryRepo.findAll();
            if(flightHistories.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
            }
        List<FlightHistoryDto> flightHistoryDtos=new ArrayList<>();
        for(FlightHistory fh:flightHistories){
         FlightHistoryDto fhd= new FlightHistoryDto();
         fhd.setAircraft(fh.getAircraft());
         fhd.setArrivalDate(fh.getArrivalDate());
         fhd.setArrivalTime(fh.getArrivalTime());
         fhd.setDeparturDate(fh.getDeparturDate());
         fhd.setDurationMinutes(fh.getDurationMinutes());
         fhd.setFlightHistoryId(fh.getFlightHistoryId());
         fhd.setDepartureTime(fh.getDepartureTime());
         fhd.setRemarks(fh.getRemarks());
         fhd.setFromCity(fh.getFromCity().getCityCode());
         fhd.setToCity(fh.getToCity().getCityCode());
         fhd.setFlightNo(fh.getFlightNo().getFlightNo());
         flightHistoryDtos.add(fhd);

        }return ResponseEntity.ok(flightHistoryDtos);

      }catch(Exception ex){
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured while processing");

      }
     }
//4
     @GetMapping("/flighthistory/{flightNo}")
     public ResponseEntity<?> flightHistories(@PathVariable ("flightNo") String flightNo){

      try{
         List<FlightHistory> flightHistories=  flightHistoryRepo.findByFlightFlightNo(flightNo);
         if(flightHistories.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight number does not exist");
         }

      List<FlightHistoryDto> flightHistoryDtos =new ArrayList<>();

      for(FlightHistory fh : flightHistories){
         FlightHistoryDto fhd= new FlightHistoryDto();
         fhd.setAircraft(fh.getAircraft());
         fhd.setArrivalDate(fh.getArrivalDate());
         fhd.setArrivalTime(fh.getArrivalTime());
         fhd.setDeparturDate(fh.getDeparturDate());
         fhd.setDurationMinutes(fh.getDurationMinutes());
         fhd.setFlightHistoryId(fh.getFlightHistoryId());
         fhd.setDepartureTime(fh.getDepartureTime());
         fhd.setRemarks(fh.getRemarks());
         fhd.setFromCity(fh.getFromCity().getCityCode());
         fhd.setToCity(fh.getToCity().getCityCode());
         fhd.setFlightNo(fh.getFlightNo().getFlightNo());
         flightHistoryDtos.add(fhd);
      } return ResponseEntity.ok(flightHistoryDtos);
   }catch(Exception ex){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured while processing");
   }
     }
//8
    @GetMapping("/delayedflight/{minutes}")

     public ResponseEntity<?> allHistories(@RequestParam("minutes") int minutes){

      try{
         List<FlightHistory> flightHistories= flightHistoryRepo.allflights(minutes);
         if(flightHistories.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flights are delayed");
         }

      List<FlightHistoryDto> flightHistoryDtos =new ArrayList<>();

      for(FlightHistory fh : flightHistories){
         FlightHistoryDto fhd= new FlightHistoryDto();
         fhd.setAircraft(fh.getAircraft());
         fhd.setArrivalDate(fh.getArrivalDate());
         fhd.setArrivalTime(fh.getArrivalTime());
         fhd.setDeparturDate(fh.getDeparturDate());
         fhd.setDurationMinutes(fh.getDurationMinutes());
         fhd.setFlightHistoryId(fh.getFlightHistoryId());
         fhd.setDepartureTime(fh.getDepartureTime());
         fhd.setRemarks(fh.getRemarks());
         fhd.setFromCity(fh.getFromCity().getCityCode());
         fhd.setToCity(fh.getToCity().getCityCode());
         fhd.setFlightNo(fh.getFlightNo().getFlightNo());
         flightHistoryDtos.add(fhd);
      } return ResponseEntity.ok(flightHistoryDtos);
     }catch(Exception ex){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured while processing");

     }
}
@PreAuthorize("hasRole('Admin')")
@PostMapping("/adding/{flightNo}/{departurDate}/{arrivalDate}/{remarks}")
public ResponseEntity<?> addingflight(@RequestParam("flightNo") String flightNo,@RequestParam("departurDate") LocalDate departurDate,@RequestParam("arrivalDate") LocalDate arrivalDate,@RequestParam("remarks") String remarks){
   try{
      List<Flight>flights= flightRepo.findByFlightNo(flightNo);
      if(flights.isEmpty()){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid flight number");
      }
   
   //List<Flight>flights= flightRepo.findByFlightNo(flightNo);
       FlightHistory flightHistory=new FlightHistory();
       
     
       flightHistory.setArrivalDate(arrivalDate);
       flightHistory.setDeparturDate(departurDate);
       flightHistory.setRemarks(remarks);
      
      for (Flight f : flights) {
        flightHistory.setArrivalTime(f.getArrivalTime());
        flightHistory.setFlightNo(f);
        flightHistory.setFromCity(f.getFromCity());
        flightHistory.setToCity(f.getToCity());
        flightHistory.setDurationMinutes(f.getDurationMinutes());
        flightHistory.setDepartureTime(f.getDepartureTime());
        flightHistory.setAircraft(f.getAircraft());

        
      }
      flightHistoryRepo.save(flightHistory);
      return ResponseEntity.ok().body("Successfully added");
}catch(Exception e){
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured while processing");

}
}

// @PreAuthorize("hasRole('Admin')")
// @PostMapping("/adding/{flightNo}/{departurDate}/{arrivalDate}/{remarks}/{arrivaltime}/{durationminutes}")
// public ResponseEntity<?> addingflights(@RequestParam("flightNo") String flightNo,@RequestParam("departurDate") LocalDate departurDate,@RequestParam("arrivalDate") LocalDate arrivalDate,@RequestParam("remarks") String remarks,@RequestParam ("arrivaltime") LocalTime arrivaltime,@RequestParam("durationminutes") int duratiominutes){
//    try{
//       List<Flight>flights= flightRepo.findByFlightNo(flightNo);
//       if(flights.isEmpty()){
//          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid flight number");
//       }
   
//    //List<Flight>flights= flightRepo.findByFlightNo(flightNo);
//        FlightHistory flightHistory=new FlightHistory();
       
     
//        flightHistory.setArrivalDate(arrivalDate);
//        flightHistory.setDeparturDate(departurDate);
//        flightHistory.setRemarks(remarks);
//        flightHistory.setArrivalTime(arrivaltime);
//        flightHistory.setDurationMinutes(duratiominutes);
      
//       for (Flight f : flights) {
//        // flightHistory.setArrivalTime(f.getArrivalTime());
//         flightHistory.setFlightNo(f);
//         flightHistory.setFromCity(f.getFromCity());
//         flightHistory.setToCity(f.getToCity());
//        // flightHistory.setDurationMinutes(f.getDurationMinutes());
//         flightHistory.setDepartureTime(f.getDepartureTime());
//         flightHistory.setAircraft(f.getAircraft());

        
//       }
//       flightHistoryRepo.save(flightHistory);
//       return ResponseEntity.ok().body("Successfully added");
// }catch(Exception e){
//    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured while processing");

// }
// }
}
