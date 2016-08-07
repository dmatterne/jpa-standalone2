package com.realdolmen.course.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by stannisbaratheon on 01/07/16.
 */
@Entity
public class Author {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "seq_author")
    private Integer id;

    String name;

    @ManyToMany(mappedBy = "authors")
    private Collection<Book> books = new ArrayList<>();
}
