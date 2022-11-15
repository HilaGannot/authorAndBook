package com.jb.authorAndBook.repos;

import com.jb.authorAndBook.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*

Hila Gannot
11/13/2022 11:26

*/
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByYearBetween(int startYear, int endYear);
    @Query(value = "select avg (year) from books", nativeQuery = true)
    double avgAllYear();

    @Query(value = "select avg (year) from books where (author_id=?)", nativeQuery = true)
    double avgAllYearByAuthorId(int id);
}
