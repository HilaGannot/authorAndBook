package com.jb.authorAndBook.repos;

import com.jb.authorAndBook.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*

Hila Gannot
11/13/2022 11:26

*/
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
