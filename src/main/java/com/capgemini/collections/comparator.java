package com.capgemini.collections;

import com.capgemini.flights.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparator {

    public static void main(String[] args) {
        List<Flight> list = new ArrayList<>();
        list.add(new Flight(900));
        list.add(new Flight(1));
        list.add(new Flight(5));
        list.add(new Flight(26));

        list.sort((f1,f2)->Integer.compare(f1.getPassengers(), f2.getPassengers()));
        list.sort(Comparator.comparingInt(Flight::getSeats).reversed());
        System.out.println(list);
        list.sort(Comparator.comparingInt(Flight::getSeats));
        list.sort(new SeatsComparator() {
            @Override
            public int compare(Flight o1, Flight o2) {
                return super.compare(o1,o2)*-1;
            }
        });
        System.out.println(list);
        list.sort(Comparator.comparingInt(f->f.getSeats()));
        list.sort(new ReverseComp<>(new SeatsComparator()));
        System.out.println(list);

        ReverseComp<Flight> comp = new ReverseComp<>(new SeatsComparator());
    }

}
