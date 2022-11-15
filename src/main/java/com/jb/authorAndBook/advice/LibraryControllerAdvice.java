package com.jb.authorAndBook.advice;
/*

Hila Gannot
11/13/2022 2:41

*/

import com.jb.authorAndBook.Exaption.LibraryCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryControllerAdvice {

    @ExceptionHandler(value = {LibraryCustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handle(Exception e) {
        return new ErrDetails(e.getMessage());
    }
}
