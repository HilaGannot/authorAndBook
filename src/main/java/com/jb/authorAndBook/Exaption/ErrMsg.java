package com.jb.authorAndBook.Exaption;
/*

Hila Gannot
11/13/2022 11:45

*/

public enum ErrMsg {

    ID_NOT_FOUND("id not found"),
    ID_ALREADY_EXIST("id exist"),
    STAR_YEAR_BIGGER("start year is bigger then and year");

    private String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }
}
