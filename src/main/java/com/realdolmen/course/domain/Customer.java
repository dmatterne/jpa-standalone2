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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void assignInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
        invoiceAddress.setCustomer(this);
    }
}

@Entity
class Address {

    @Id
    private Integer id;
    private String street;
    private String city;

    @OneToOne(mappedBy="invoiceAddress")
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

     void setCustomer(Customer customer) {

        this.customer = customer;
    }
}