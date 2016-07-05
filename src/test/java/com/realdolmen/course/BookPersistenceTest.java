package com.realdolmen.course;

import com.realdolmen.course.domain.Books.Book;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void bookCanBePersisted() throws Exception {
        Collection a = new ArrayList<String>();
        a.add("George Orwell");
        Book book = new Book("Animal Farm", a, Book.Genre.thriller);
        entityManager().persist(book);
        assertNotNull(book.getId());
    }

    @Test(expected = PersistenceException.class)
    public void bookCanNotBePersistedWithoutTitle() throws Exception {
        Collection a = new ArrayList<String>();
        a.add("George Orwell");
        Book book = new Book(null, a, Book.Genre.thriller);
        entityManager().persist(book);
    }

    @Test
    public void bookCanBeRetrievedById() throws Exception {
        assertEquals("Nineteen Eighty Four", entityManager().find(Book.class, 1000).getTitle());
    }
}
