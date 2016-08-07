package com.realdolmen.course.domain.Flights;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stannisbaratheon on 30/06/16.
 */
@Entity
public class Passenger {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "seq_Passenger")
    private Long id;

    @Column(updatable=false, nullable=false)
    private String ssn;

    @Column(length=50)
    private String firstName;

    @Column(length=50)
    private String lastName;

    private Integer frequentFlyerMiles;

    private byte[] picture;


    @Column(updatable = false,nullable = false)
    private LocalDate dateOfBirth;

    @Transient
    private int age;

    private LocalDateTime lastFlight;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private PassengerType type;

    @ElementCollection
    @CollectionTable(name = "passenger_emails", joinColumns = @JoinColumn(name ="p_id"))
    @Column(name = "email")
    private List<String> emails = new ArrayList<>();


//    @OneToMany
//    @JoinTable( name = "passenger_tickets", joinColumns = @JoinColumn(name = "t_id"),
//            inverseJoinColumns = @JoinColumn(name = "p_id"),foreignKey = @ForeignKey(name="FK_PSS_TO_PSSTICK"),
//            inverseForeignKey =  @ForeignKey(name="FK_TICK_TO_PSSTICK"))
//    private Collection<Ticket> tickets = new ArrayList<>();


    public Passenger() {

    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, LocalDate dateOfBirth, LocalDateTime lastFlight, PassengerType type) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.lastFlight = lastFlight;
        this.type = type;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(LocalDateTime lastFlight) {
        this.lastFlight = lastFlight;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void addEmails(String newEmail) {
        if (newEmail == null || newEmail.trim().length() == 0) {
            throw new IllegalArgumentException("foute invoer");
        }
        this.emails.add(newEmail);
    }
}
