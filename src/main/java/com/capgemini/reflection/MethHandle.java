package com.capgemini.reflection;

import com.capgemini.flights.Flight;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MethHandle {

    public static void main(String[] args) throws Throwable {
        Lookup lookup = MethodHandles.lookup();

        MethodType constructor_t = MethodType.methodType(void.class,int.class);
        MethodHandle construct = lookup.findConstructor(Flight.class, constructor_t);

        Object o = construct.invoke(200);

        System.out.println(o);

        MethodType methodType = MethodType.methodType(void.class);
        MethodHandle methodHandle = lookup.findVirtual(Flight.class, "addPassenger", methodType );

        methodHandle.invoke(o);

        System.out.println(o);

    }
}
