package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by stannisbaratheon on 01/07/16.
 */
@Entity
public class Ticket {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "seq_ticket")
    private Long id;

    private double price =0.0;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
        @JoinTable( name = "ticket_flights", joinColumns = @JoinColumn(name = "f_id"),
            inverseJoinColumns = @JoinColumn(name = "t_id"),foreignKey = @ForeignKey(name="FK_TCK_TO_FLGHT_TCK"),
            inverseForeignKey =  @ForeignKey(name="FK_FLGHT_TO_FLGHT_TCK"))
    private Flight flight;


    public Ticket(double price, Passenger passenger, Flight flight) {
        this.price = price;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
