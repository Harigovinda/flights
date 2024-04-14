package com.project.flights.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class City {
    @Id
    @Column(unique = true)
    private String cityCode;

    @Column(name = "city_name",nullable = false,unique = true)
    private String cityName;

    @Column(name = "minutes_from_utc")
    private String minutesFromUtc;

    private String country;
   
    @JsonIgnore
    @OneToMany(mappedBy = "fromCity",cascade = CascadeType.ALL)
    private List<Flight> flightComingFrom;

    @JsonIgnore
    @OneToMany(mappedBy = "toCity",cascade = CascadeType.ALL)
    private List<Flight> flightGoingTo;

    public City() {
    }
    public City(String cityCode, String cityName, String minutesFromUtc, String country) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.minutesFromUtc = minutesFromUtc;
        this.country = country;
    }



    public String getCityCode() {
        return cityCode;
    }



    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }



    public String getCityName() {
        return cityName;
    }



    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    public String getMinutesFromUtc() {
        return minutesFromUtc;
    }



    public void setMinutesFromUtc(String minutesFromUtc) {
        this.minutesFromUtc = minutesFromUtc;
    }



    public String getCountry() {
        return country;
    }



    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() {
        return "City [cityCode=" + cityCode + ", cityName=" + cityName + ", minutesFromUtc=" + minutesFromUtc
                + ", country=" + country + "]";
    }

    



    

    
}
