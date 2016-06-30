package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by stannisbaratheon on 30/06/16.
 */
@Entity
public class Passenger {

    @Id
    private Long id;

    private String ssn;

    private String firstName;

    private String lastName;

    private Integer frequentFlyerMiles;

    public Passenger() {

    }

    public Passenger(Long id, String ssn, String firstName, String lastName, Integer frequentFlyerMiles) {
        this.id = id;
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
