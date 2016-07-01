package com.realdolmen.course;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import org.hibernate.PropertyValueException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by stannisbaratheon on 30/06/16.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();


    @Test
    public void flightCanBeRetrievedById() throws Exception {
        assertEquals("-1", entityManager().find(Flight.class, -1L).getId());
        assertEquals("-1", entityManager().find(Flight.class, -1L).getId());
    }

    @Test
    public void passengerCanStoreManyEmails()  throws Exception {
        Passenger pass = new Passenger("465789123", "Peter", "D", 1000, LocalDate.of(1985,12,17), LocalDateTime.of(2014,12,17,14,36), PassengerType.REGULAR);

        pass.addEmails("peter@incognite.com");
        pass.addEmails("peter@findme.com");

        entityManager().persist(pass);


    }

    @Test
    public void passCanBePersisted() throws Exception {
        //Long id, String ssn, String firstName, String lastName, Integer frequentFlyerMiles



        Passenger pass = new Passenger("465789123", "Kevin", "V", 1000, LocalDate.of(1985,12,17), LocalDateTime.of(2014,12,17,14,36), PassengerType.REGULAR);
        entityManager().persist(pass);
        assertNotNull(pass.getId());
    }

//    @Test(expected = PersistenceException.class)
//    public void bookCanNotBePersistedWithoutTitle() throws Exception {
//        Passenger pass = new Passenger(null, "John Doe", Passenger.Genre.thriller);
//        entityManager().persist(pass);
//    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("David", entityManager().find(Passenger.class, 11L).getFirstName());
        assertEquals("M", entityManager().find(Passenger.class, 11L).getLastName());
    }

    @Test
    public void dobCannotBeNull() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        boolean b = false;
        Passenger pass = null;

        pass = new Passenger("465789123", "David", "Y", 1000, null, LocalDateTime.of(2014,12,17,14,36), PassengerType.REGULAR);


        try {
            entityManager().persist(pass);
            b = true;
        } catch (PersistenceException e) {
            b = false;
        }

        assertTrue(!b);
    }

    @Test
    public void dobCannotBeUpdate() {
        Passenger pass = null;

        pass = new Passenger("465789123", "Tomas", "V", 1000, LocalDate.of(1985,12,17), LocalDateTime.of(2014,12,17,14,36), PassengerType.REGULAR);

        entityManager().persist(pass);
        try {
            pass.setDateOfBirth(LocalDate.of(1986,12,17));
            entityManager().persist(pass);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }


        Assert.assertNotEquals(LocalDate.of(1986,12,17).toString(), pass.getDateOfBirth());



            System.out.println(pass.getDateOfBirth());
            Assert.assertEquals(LocalDate.of(1985,12,17).toString(), pass.getDateOfBirth());


    }


}
