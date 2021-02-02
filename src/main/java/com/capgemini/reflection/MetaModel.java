package com.capgemini.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaModel<T> {

    private final Class<T> clss;

    public MetaModel(Class<T> clss){
        this.clss = clss;
    }

    public Field getPrimaryKey(){
        for (Field f: clss.getDeclaredFields()) {
            if(f.getAnnotation(PrimaryKey.class)!=null)
                return f;
        }
        throw new IllegalArgumentException();
    }

    public List<Field> getColums(){
        List<Field> list = new ArrayList<>();
        for (Field f: clss.getDeclaredFields()) {
            if(f.getAnnotation(Column.class)!=null)
                list.add(f);
        }
        return list;
    }




}
