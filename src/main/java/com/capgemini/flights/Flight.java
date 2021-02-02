package com.capgemini.flights;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class Flight implements Iterable<Integer>, Comparable<Flight> {
    private int seats;
    private int passengers;
    private List<Integer> ids;
    public int reflection;

    public Flight(int number){
        seats=number;
        passengers=0;
        ids = new ArrayList<>();
        for (int i=0;i<5;i++){
            ids.add(i);
        }
    }

    public Flight() {
        seats=150;
        passengers=0;
        ids = new ArrayList<>();
        for (int i=0;i<5;i++){
            ids.add(i);
        }
    }

    public void addPassenger() {
        if(passengers<seats)
            passengers++;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return ids.iterator();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "seats=" + seats +
                ", passengers=" + passengers +
                ", ids=" + ids +
                ", reflection=" + reflection +
                '}';
    }

    @Override
    public int compareTo(Flight o) {
        return Integer.compare(this.seats,o.getSeats());
    }
}
