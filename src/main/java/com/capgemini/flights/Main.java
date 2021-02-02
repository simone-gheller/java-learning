package com.capgemini.flights;

public class Main {

    public static void main(String[] args) {
        Flight[] flights = new Flight[5];
        for(int i=0;i<5;i++) {
            flights[i] = new Flight();
        }

        for (Flight f: flights) {
            System.out.println(f);
        }

        for(Integer i: flights[0]) {
            System.out.println(i);
        }


    }

}
