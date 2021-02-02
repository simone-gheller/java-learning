package com.capgemini.streams;

import java.util.*;

public class Streams{

    ArrayList<Product> list = new ArrayList<>(5);

    Streams() {
        list.add(new Product(1, "test"));
        list.add(new Product(50, "heavy"));
        list.add(new Product(30, "medium"));
    }

    void FilterOverAvgSortedByName() {
        OptionalDouble avg = list.stream().mapToInt(Product::getWeight).average();
        list.stream()
                .filter(product -> product.getWeight() > avg.orElse(0))
                .sorted((Product s1, Product s2) -> s1.getName().compareTo(s2.getName()) )
                .sorted()
                .map(Product::getName)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        Object[] obj = new Object[5];

        Arrays.stream(obj).count();
        Arrays.sort(new int[]{Integer.compare(obj.length, obj.hashCode())});

        List<String> list = Arrays.asList("obj", "o", "oca", "ciao", "banaan", "casa");
        list.forEach(s -> {
            if(s.contains("o"))
                System.out.println(s);
        });

        //------------

        Streams stream = new Streams();
        stream.FilterOverAvgSortedByName();


    }


    private class Product implements Comparable<Product>{
        int weight;
        String name;

        public int getWeight() {
            return weight;
        }

        public String getName() {
            return name;
        }


        Product(int weight, String name) {
            this.weight = weight;
            this.name = name;
        }

        @Override
        public int compareTo(Product o) {
            return o.getName().compareTo(name);
        }
    }


}
