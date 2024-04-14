package com.project.flights.dto;

import java.time.LocalTime;

public class FlightResponseDto {
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private int durationMinutes;
    private  String fromCity;
    private String  toCity;
    private String aircraft;
    private String flightNo;
    public FlightResponseDto() {
    }
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public LocalTime getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
    public String getFromCity() {
        return fromCity;
    }
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
    public String getToCity() {
        return toCity;
    }
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
    public String getAircraft() {
        return aircraft;
    }
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    public String getFlightNo() {
        return flightNo;
    }
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    


}
