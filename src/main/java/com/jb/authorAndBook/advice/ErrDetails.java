package com.jb.authorAndBook.advice;
/*

Hila Gannot
11/13/2022 2:42

*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrDetails {

    private final String key = "Java-151";
    private String value;
}
