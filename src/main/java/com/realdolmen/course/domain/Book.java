package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Book {
    public enum Genre {
        biography, fantasy, thriller, fiction
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    private String title;

    @ManyToMany
    @JoinTable( name = "author_book", joinColumns = @JoinColumn(name = "a_id"),
            inverseJoinColumns = @JoinColumn(name = "b_id"),foreignKey = @ForeignKey(name="FK_BK_TO_BKAUTH"),
            inverseForeignKey =  @ForeignKey(name="FK_AUT_TO_BKAUTH"))
    private Collection<Author> authors = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Genre genre;


    /**
     * Used by JPA.
     */
    protected Book() {
    }

    public Book(String title, Collection author, Genre genre) {
        this.title = title;
        this.authors = author;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection getAuthor() {
        return authors;
    }

    public void setAuthor(Collection author) {
        this.authors = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
