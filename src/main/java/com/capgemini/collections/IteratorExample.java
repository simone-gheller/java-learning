package com.capgemini.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class IteratorExample {

    int data;

    public IteratorExample() {
        Random random = new Random();
        data = random.nextInt(50);
        System.out.println(data);
    }

    public static void main(String[] args) {

        List<IteratorExample> list = new ArrayList<>();
        list.add(new IteratorExample());
        list.add(new IteratorExample());
        list.add(new IteratorExample());

        for(IteratorExample it : list) {
            IteratorExample temp = it;
            if(it.data > 20)
                list.remove(temp);
        }

        Iterator<IteratorExample> iterator = list.iterator();
        while(iterator.hasNext()) {
            IteratorExample temp = iterator.next();
            if(temp.data > 20)
                iterator.remove();
        }

    }
}
