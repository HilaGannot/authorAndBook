package com.jb.authorAndBook.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*

Hila Gannot
11/13/2022 1:23

*/
@Component
public class Print {

    @Value("${SIZE}")
    private int SIZE;

    public void print(String txt){
        int side = (SIZE - txt.length()) / 2;
        System.out.print("@".repeat(side));
        System.out.print(txt);
        System.out.println("@".repeat(side));
    }
}

