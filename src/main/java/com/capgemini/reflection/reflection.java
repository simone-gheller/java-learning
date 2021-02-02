package com.capgemini.reflection;

import com.capgemini.flights.Flight;

import java.lang.reflect.*;

public class reflection {

    public static void main(String[] args) {
        try {
            Class<?> myclass = Class.forName("com.capgemini.flights.Flight");
            Object o = myclass.newInstance();
            Constructor constructor = myclass.getConstructor(int.class);
            o = constructor.newInstance(2);
            System.out.println(myclass);
            System.out.println(constructor);

            Class<?> test = o.getClass();
            Class<?> test1 = Flight.class;
            System.out.println(test.getModifiers() >= Modifier.PUBLIC);
            System.out.println(test==test1);

            Field[] fields = test.getDeclaredFields();
            for (int i=0;i<fields.length;i++) {
                System.out.println(fields[i].getType());
            }

            Method[] methods = test.getDeclaredMethods();
            Method m = test.getMethod("addPassenger");
            m.invoke(o);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
