package com.project.flights.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightHistoryDto {

    private Long flightHistoryId;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private int durationMinutes;
    private  String fromCity;
    private String toCity;
    private String aircraft;
    private String flightNo;
    private String remarks;
    private LocalDate departurDate;
    private LocalDate arrivalDate;

    public FlightHistoryDto() {
    }

    public Long getFlightHistoryId() {
        return flightHistoryId;
    }

    public void setFlightHistoryId(Long flightHistoryId) {
        this.flightHistoryId = flightHistoryId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getDeparturDate() {
        return departurDate;
    }

    public void setDeparturDate(LocalDate departurDate) {
        this.departurDate = departurDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
   
    


}
