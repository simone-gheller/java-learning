package com.capgemini.reflection;

import java.lang.reflect.Field;
import java.util.Scanner;

public class BeanManager {

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write the full name of the class you want to extract info from:");
        System.out.println(SampleBean.class.getName());
        String clzz = scan.nextLine();
        MetaModel<?> mm;
        if(clzz.isEmpty())
            mm = new MetaModel<>(SampleBean.class);
        else
            mm = new MetaModel<>(Class.forName(clzz));

        Field pk = mm.getPrimaryKey();
        Field[] columns = mm.getColums().toArray(new Field[0]);

        System.out.printf("PrimaryKey: field_type=%s - field_name=%s%n",pk.getType().getSimpleName(),pk.getName());
        for (Field f: columns) {
            System.out.printf("Column: field_type=%s - field_name=%s%n",f.getType().getSimpleName(),f.getName());
        }

    }
}
