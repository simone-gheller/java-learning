package com.capgemini.generics;

import sun.net.www.content.text.Generic;

import java.util.ArrayList;
import java.util.List;

public class generic {

    private List<Person> people;

    public void add(List<? super Person> person) {
        people.add((Person) person.get(0));
    }

    public generic() {
        people = new ArrayList<>();
    }

    public void print() {
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {

        Person p = new Person(32,"Person");
        Manager m = new Manager(40, "Manager");
        Employee e = new Employee(20, "Employee");

        generic generic = new generic();
        //generic.add(p);
        //generic.add(m);
        //generic.add(e);
        generic.print();
    }
}
