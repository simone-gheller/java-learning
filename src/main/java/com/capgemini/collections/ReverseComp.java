package com.capgemini.collections;

import java.util.Comparator;

public class ReverseComp <T> implements Comparator<T> {

    private final Comparator<T> comp;

    public ReverseComp(Comparator<T> comp){
        this.comp = comp;
    }

    @Override
    public int compare(T o1, T o2) {
        return comp.compare(o1,o2)*-1;
    }
}
