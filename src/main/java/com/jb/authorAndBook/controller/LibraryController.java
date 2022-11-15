package com.jb.authorAndBook.controller;
/*

Hila Gannot
11/13/2022 2:42

*/

import com.jb.authorAndBook.Exaption.LibraryCustomException;
import com.jb.authorAndBook.beans.Author;
import com.jb.authorAndBook.beans.Book;
import com.jb.authorAndBook.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    @GetMapping
    private List<Author> getAllAuthors(){
        return libraryService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public Author getSingleAuthor(@PathVariable int id) throws LibraryCustomException {
        return libraryService.getSingletAuthor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void addAuthor(@RequestBody Author author) throws LibraryCustomException {
        libraryService.addAuthor(author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteAuthor(@PathVariable int id) throws LibraryCustomException {
        libraryService.deleteAuthor(id);
    }


    @GetMapping("by/between-startYear-endYear")
    private List<Book> findByYearBetween(@RequestParam int startYear, @RequestParam int endYear) throws LibraryCustomException {
        return libraryService.findByYearBetween(startYear, endYear);
    }

    @GetMapping("year/avg")
    private double avgAllYear(){
        return libraryService.avgAllYear();
    }

    @GetMapping("author/year/avg")
    private double avgAllYearByAuthorId(@PathVariable int id){
        return libraryService.avgAllYearByAuthorId(id);
    }
}
