package com.project.flights.entity;

import java.time.LocalTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Flight {
    @Id
    @Column(name = "flight_no",unique = true)
    private String flightNo;
     
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "from_city")
    private  City fromCity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="to_city")
    private City toCity;

    @Column(name = "duration_minutes")
    private int durationMinutes;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name="arrival_time")
    private LocalTime arrivalTime;

    private String aircraft;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="flight" )
    private List<ScheduledFlight> ScheduledFlight;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "flight")
    private List<FlightHistory> flightHistory;


    public Flight() {
    }
    public Flight(String flightNo, City fromCity, City toCity, int durationMinutes, LocalTime departureTime,
            LocalTime arrivalTime, String aircraft) {
        this.flightNo = flightNo;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.durationMinutes = durationMinutes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraft = aircraft;
    }


    public String getFlightNo() {
        return flightNo;
    }


    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }


    public City getFromCity() {
        return fromCity;
    }


    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }


    public City getToCity() {
        return toCity;
    }


    public void setToCity(City toCity) {
        this.toCity = toCity;
    }


    public int getDurationMinutes() {
        return durationMinutes;
    }


    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }


    public LocalTime getArrivalTime() {
        return arrivalTime;
    }


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public String getAircraft() {
        return aircraft;
    }


    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }


    @Override
    public String toString() {
        return "Flight [flightNo=" + flightNo + ", fromCity=" + fromCity + ", toCity=" + toCity + ", durationMinutes="
                + durationMinutes + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", aircraft="
                + aircraft + "]";
    }
}