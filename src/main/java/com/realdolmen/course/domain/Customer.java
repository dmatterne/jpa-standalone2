package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by stannisbaratheon on 01/07/16.
 */
@Entity
public class Customer {
    @Id
    private Integer id;
    private String name;

    @OneToOne
    private Address invoiceAddress;
}

@Entity
class Address {

    @Id
    private Integer id;
    private String street;
    private String city;

    @OneToOne(mappedBy="invoiceAddress")
    private Customer customer;

        }