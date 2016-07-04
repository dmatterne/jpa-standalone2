package com.realdolmen.course.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by stannisbaratheon on 04/07/16.
 */
@Entity
@DiscriminatorValue(value = "I")
public class InternationalFlight extends Flight {

    private boolean blacklisted;
    private String regulations;

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
