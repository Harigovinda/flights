package com.project.flights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.flights.entity.City;
import com.project.flights.repository.CityRepo;



@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityRepo cityRepo;
//1
    // @GetMapping("/cities") 
    // public List<String> allCities(){     
    //     return cityRepo.allCities();
    // }
  
    @GetMapping("/allcities")
    public ResponseEntity<?> allCitiess(){
        try{
           List<City> city=cityRepo.findAll();
           if(city.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        }
        return ResponseEntity.ok(city);
    }
     catch(ResponseStatusException e){
        throw e;
       }
    }

    //9
    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/addcity")
     public City addCity(@RequestBody City city){
            try{
                cityRepo.save(city);
                return city;
            }catch(Exception ex){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid data");
            }
     }
    @PreAuthorize("hasRole('Admin')")
     @DeleteMapping("/deletecity/{citycode}")
     public void deletecity(@PathVariable("citycode") String cityCode){
        var citys =cityRepo.findById(cityCode);
        if(citys.isPresent()){
            cityRepo.deleteById(cityCode);
           
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"City code not found");
        }
              
     }
     @PreAuthorize("hasRole('Admin')")

     @PutMapping("updatecity/{cityCode}")
     public City updatingCity(@PathVariable("cityCode") String city,@RequestParam("country") String country){
        var citys=  cityRepo.findById(city);
        if(citys.isPresent()){
            var cityss=citys.get();
            cityss.setCityName(country);
            cityRepo.save(cityss);
            return cityss;
        }else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"City code not found");
        

     }

}
