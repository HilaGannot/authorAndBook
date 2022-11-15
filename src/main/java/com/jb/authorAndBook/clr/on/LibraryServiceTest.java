package com.jb.authorAndBook.clr.on;
/*

Hila Gannot
11/13/2022 1:17

*/

import com.jb.authorAndBook.beans.Author;
import com.jb.authorAndBook.beans.Book;
import com.jb.authorAndBook.service.LibraryService;
import com.jb.authorAndBook.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class LibraryServiceTest implements CommandLineRunner {

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private Print print;

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("lord of the rings", 2001);
        Book book2 = new Book("the hobbit", 2010);

        Book book3 = new Book("assassin's apprentice",2008);
        Book book4 = new Book("royal assassin",2012);

        Author author1 = Author.builder()
                .name("J.R.R tolkien")
                .books(List.of(book1, book2))
                .build();

        book1.setAuthor(author1);
        book2.setAuthor(author1);

        Author author2 = Author.builder()
                .name("robin hobb")
                .books(List.of(book3,book4))
                .build();

        book3.setAuthor(author2);
        book4.setAuthor(author2);

        //Add author
        print.print("ADD AUTHOR");
        libraryService.addAuthor(author1);
        libraryService.addAuthor(author2);
        libraryService.getAllAuthor().forEach(System.out::println);

        //Delete author
        print.print("DELETE AUTHOR");
        libraryService.deleteAuthor(1);
        libraryService.getAllAuthor().forEach(System.out::println);

        //Get one author
        print.print("GET ONE AUTHOR");
        System.out.println(libraryService.getSingletAuthor(2));

        //Books between years
        print.print("BOOKS BETWEEN YEARS");
        System.out.println(libraryService.findByYearBetween(2003,2020));

        //Avg all books
        print.print("AVG YEARS FOR ALL BOOKS");
        System.out.println(libraryService.avgAllYear());

        //Avg all books by author
        print.print("AVG YEARS FOR ALL BOOKS BY AUTHOR ID");
        System.out.println(libraryService.avgAllYearByAuthorId(3));
    }
}
