package com.capgemini.strings;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class strings {

    public static void main(String[] args) {
        String a = "ciao ";
        String b = "mondo";
        a = a + b;
        System.out.println(a);

        Pattern pattern = Pattern.compile("\\w+\\b");
        Matcher matcher = pattern.matcher(a);
        while(matcher.find())
            System.out.println(matcher.group().toUpperCase());

    }
}
