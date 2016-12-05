package com.axway.academy;

import org.apache.commons.lang3.StringUtils;
import com.axway.academy.utils.EmptyClass;

public class HelloWorld {
    static EmptyClass emptyClass;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        for (String s : args) {
            System.out.println(StringUtils.length(s) +  ":" + s);
        }
    }
}

