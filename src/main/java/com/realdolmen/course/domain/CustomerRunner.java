package com.realdolmen.course.domain;

/**
 * Created by stannisbaratheon on 01/07/16.
 */
public class CustomerRunner {
    public static void main(String[] args) {
        Customer c = new Customer();
        Address a = new Address();

        c.assignInvoiceAddress(a);
    }
}
