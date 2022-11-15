package com.jb.authorAndBook.beans;
/*

Hila Gannot
11/13/2022 11:01

*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String name;

    private int year;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Author author;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
