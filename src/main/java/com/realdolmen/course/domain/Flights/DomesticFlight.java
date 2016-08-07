package com.realdolmen.course.domain.Flights;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stannisbaratheon on 04/07/16.
 */

@Entity
@DiscriminatorValue(value = "D")
public class DomesticFlight extends Flight {

    private String airlineCompany;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> references = new ArrayList<>();


    public DomesticFlight(String number, LocalDateTime departureTime, LocalDateTime arrivalTime, String airlineCompany) {
        super(number, departureTime, arrivalTime);
        this.airlineCompany = airlineCompany;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getReferences() {
        return references;
    }

    public void addReferences(String reference) {
        references.add(reference);
    }




}
