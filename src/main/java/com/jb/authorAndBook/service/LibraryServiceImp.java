package com.jb.authorAndBook.service;
/*

Hila Gannot
11/13/2022 1:02

*/

import com.jb.authorAndBook.Exaption.ErrMsg;
import com.jb.authorAndBook.Exaption.LibraryCustomException;
import com.jb.authorAndBook.beans.Author;
import com.jb.authorAndBook.beans.Book;
import com.jb.authorAndBook.repos.AuthorRepository;
import com.jb.authorAndBook.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImp implements LibraryService{

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    @Override
    public void addAuthor(Author author) throws LibraryCustomException {
        int id = author.getId();
        if(authorRepository.existsById(id)){
            throw new LibraryCustomException(ErrMsg.ID_ALREADY_EXIST);
        }
        author.getBooks().forEach(a-> a.setAuthor(author));
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) throws LibraryCustomException {
        if(!authorRepository.existsById(id)){
            throw new LibraryCustomException(ErrMsg.ID_NOT_FOUND);
        }
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getSingletAuthor(int id) throws LibraryCustomException {
        return authorRepository.findById(id).orElseThrow(()->new LibraryCustomException(ErrMsg.ID_NOT_FOUND));
    }


    @Override
    public List<Book> findByYearBetween(int startYear, int endYear) throws LibraryCustomException {
        if(startYear > endYear){
            throw new LibraryCustomException(ErrMsg.STAR_YEAR_BIGGER);
        }
        return bookRepository.findByYearBetween(startYear, endYear);
    }

    @Override
    public double avgAllYear() {
        return bookRepository.avgAllYear();
    }

    @Override
    public double avgAllYearByAuthorId(int id) {
        return bookRepository.avgAllYearByAuthorId(id);
    }


}
