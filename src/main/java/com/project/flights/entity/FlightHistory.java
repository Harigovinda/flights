package com.project.flights.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FlightHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_history_id")
    private Long flightHistoryId;


    @Column(name = "departure_date")
    private LocalDate departurDate;

    @Column(name="departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
    @ManyToOne
    @JoinColumn(name = "from_city")
    private City fromCity;
    @ManyToOne
    @JoinColumn(name="to_city")
    private City toCity;

    @Column(name = "duration_minutes")
    private int durationMinutes;

    private String aircraft;
    private String remarks;

    @ManyToOne()
    @JoinColumn(name = "flight_no")
    private Flight flight;


    public FlightHistory() {
    }


    public FlightHistory(Long flightHistoryId, LocalDate departurDate, LocalTime departureTime, LocalDate arrivalDate,
            LocalTime arrivalTime, City fromCity, City toCity, int durationMinutes, String aircraft, String remarks,
            Flight flight) {
        this.flightHistoryId = flightHistoryId;
        this.departurDate = departurDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.durationMinutes = durationMinutes;
        this.aircraft = aircraft;
        this.remarks = remarks;
        this.flight = flight;
    }

    public Long getFlightHistoryId() {
        return flightHistoryId;
    }

    public LocalDate getDeparturDate() {
        return departurDate;
    }


    public void setDeparturDate(LocalDate departurDate) {
        this.departurDate = departurDate;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }


    public LocalDate getArrivalDate() {
        return arrivalDate;
    }


    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public LocalTime getArrivalTime() {
        return arrivalTime;
    }


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setFlightHistoryId(Long flightHistoryId) {
        this.flightHistoryId = flightHistoryId;
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
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getAircraft() {
        return aircraft;
    }
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Flight getFlightNo() {
        return flight;
    }

    public void setFlightNo(Flight flightNo) {
        this.flight = flightNo;
    }
    @Override
    public String toString() {
        return "FlightHistory [flightHistoryId=" + flightHistoryId + ", departurDate=" + departurDate
                + ", departureTime=" + departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime
                + ", fromCity=" + fromCity.getCityCode()+ ", toCity=" + toCity.getCityCode() + ", durationMinutes=" + durationMinutes
                + ", aircraft=" + aircraft + ", remarks=" + remarks + ", flightNo=" + flight.getFlightNo() + "]";
    }


    
    
    
    


    



    
}
