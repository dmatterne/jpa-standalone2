package com.realdolmen.course.domain.Flights;

import com.realdolmen.course.domain.Flights.Ticket;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by stannisbaratheon on 01/07/16.
 */
@Entity
public abstract class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "flight")
    private Collection<Ticket> tickets = new ArrayList<>();


    public Flight(String number, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket ticket) {

        tickets.add(ticket);
    }
}
