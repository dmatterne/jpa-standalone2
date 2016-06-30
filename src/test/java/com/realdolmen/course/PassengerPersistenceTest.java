package com.realdolmen.course;

import com.realdolmen.course.domain.Passenger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by stannisbaratheon on 30/06/16.
 */
public class PassengerPersistenceTest extends PassDataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();


    @Test
    public void bookCanBePersisted() throws Exception {
        //Long id, String ssn, String firstName, String lastName, Integer frequentFlyerMiles
        Passenger pass = new Passenger(3L,"465789123","Kevin","V",1000);
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
        assertEquals("David", entityManager().find(Passenger.class, 0L).getFirstName());
        assertEquals("M", entityManager().find(Passenger.class, 0L).getLastName());
    }
}
