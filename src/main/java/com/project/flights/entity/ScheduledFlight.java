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
public class ScheduledFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private long scheduleId;

     
    @ManyToOne
    @JoinColumn(name = "flight_no")
    private Flight flight;

    @Column(name = "departure_date")
    private LocalDate departurDate;  

    @Column(name="departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
     

    @ManyToOne
    @JoinColumn(name = "from_city_code")
    private City fromCity;

    @ManyToOne
    @JoinColumn(name = "to_city_code")
    private City toCity;

    @Column(name = "duration_minutes")
    private int durationMinutes;

    // @Column(name="status",nullable = false,columnDefinition = "varchar(255) Default'Active'")
    // private String status;

    public ScheduledFlight() {
    }

    public ScheduledFlight(Flight flightNo, LocalDate departurDate, LocalTime departureTime, LocalDate arrivalDate,
            LocalTime arrivalTime, City fromCity, City toCity, int durationMinutes) {
        this.flight = flightNo;
        this.departurDate = departurDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.durationMinutes = durationMinutes;
    }
    public long getScheduleId(){
        return scheduleId;
    }
    public Flight getFlightNo() {
        return flight;
    }

    public void setFlightNo(Flight flightNo) {
        this.flight = flightNo;
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

    @Override
    public String toString() {
        return "ScheduledFlight [scheduleId=" + scheduleId + ", flightNo=" + flight.getFlightNo() + ", departurDate=" + departurDate
                + ", departureTime=" + departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime
                + ", fromCity=" + fromCity.getCityCode()+ ", toCity=" + toCity.getCityCode()+ ", durationMinutes=" + durationMinutes + "]";
    }

    
    
    
    
}
