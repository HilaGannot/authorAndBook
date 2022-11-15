package com.jb.authorAndBook.clr.on;

import com.jb.authorAndBook.beans.Author;
import com.jb.authorAndBook.beans.Book;
import com.jb.authorAndBook.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/*

Hila Gannot
11/13/2022 11;30

*/
@Component
@Order(1)
public class Init implements CommandLineRunner {
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("harry potter and the philosopher's stone",2004);
        Book book2 = new Book("harry potter and the chamber of secrets",2005);

        Book book3 = new Book("six years",2020);
        Book book4 = new Book("tell no one",2021);

        Author author1 = Author.builder()
                .name("J.K Rowling")
                .books(List.of(book1, book2))
                .build();

        book1.setAuthor(author1);
        book2.setAuthor(author1);

        Author author2 = Author.builder()
                .name("harlan coben")
                .books(List.of(book3,book4))
                .build();

        book3.setAuthor(author2);
        book4.setAuthor(author2);

        authorRepository.saveAll(List.of(author1,author2));

        authorRepository.findAll().forEach(System.out::println);
    }
}
