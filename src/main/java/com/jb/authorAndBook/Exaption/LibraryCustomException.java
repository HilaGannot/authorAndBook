package com.jb.authorAndBook.Exaption;
/*

Hila Gannot
11/13/2022 11;44

*/

public class LibraryCustomException extends Exception{

    private String msg;

    public LibraryCustomException(ErrMsg errMsg) {
        super(errMsg.name());
        this.msg = msg;
    }
}
