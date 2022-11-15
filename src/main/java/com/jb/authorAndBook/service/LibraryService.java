package com.jb.authorAndBook.service;
/*

Hila Gannot
11/13/2022 1:01

*/

import com.jb.authorAndBook.Exaption.LibraryCustomException;
import com.jb.authorAndBook.beans.Author;
import com.jb.authorAndBook.beans.Book;

import java.util.List;

public interface LibraryService {
    void addAuthor(Author author) throws LibraryCustomException;
    void deleteAuthor(int id) throws LibraryCustomException;
    List<Author> getAllAuthor();
    Author getSingletAuthor(int id) throws LibraryCustomException;
    List<Book> findByYearBetween(int startYear, int endYear) throws LibraryCustomException;
    double avgAllYear();
    double avgAllYearByAuthorId(int id);
}
