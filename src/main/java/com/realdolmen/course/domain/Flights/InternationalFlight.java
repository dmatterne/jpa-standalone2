package com.realdolmen.course.domain.Flights;

import com.realdolmen.course.domain.Flights.Flight;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by stannisbaratheon on 04/07/16.
 */
@Entity
@DiscriminatorValue(value = "I")
public class InternationalFlight extends Flight {

    private boolean blacklisted;
    private String regulations;

    public InternationalFlight(String number, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean blacklisted, String regulations) {
        super(number, departureTime, arrivalTime);
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
