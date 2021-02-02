package com.capgemini.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {

    HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Maps maps = new Maps();
        maps.map.put(0,"ciao");
        maps.map.put(1,"test");
        maps.map.put(2,"prova");
        maps.map.put(3,"ciao");

        //Set<Map.Entry<Integer, String>> set = maps.map.entrySet();
        // Map.Entry<Integer, String> entry = new Map.entry(4, "string");

        maps.map.forEach((a, b) -> {
            if (a > 1) {
                System.out.println(b);
            } else {
                System.out.println("no");
            }
        });

    }


}
