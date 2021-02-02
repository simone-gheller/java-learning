package com.capgemini.app_execution;

public class environment {
    public static void main(String[] args) {

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("java.version"));

        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("OS"));
        System.out.println(System.getenv("USERNAME"));

    }
}
