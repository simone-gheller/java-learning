package com.capgemini.collections;

import com.capgemini.flights.Flight;

import java.util.Comparator;

public class SeatsComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return Integer.compare(o1.getSeats(), o2.getSeats());
    }
}
