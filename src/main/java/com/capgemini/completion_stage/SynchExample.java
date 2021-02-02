package com.capgemini.completion_stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SynchExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Supplier<List<Long>> sup = ()-> {
            System.out.println(System.currentTimeMillis());
            System.out.println("supplier creating ids: " + Thread.currentThread().getName());
            return Arrays.asList(1L,2L,3L);
        };

        Function<List<Long>,List<Bean>> fun = (list) -> {
            List<Bean> lb = new ArrayList<>();
            list.forEach(id -> lb.add(new Bean(id)) );
            return lb;
        };

        Function<List<Long>,CompletableFuture<List<Bean>>> fun2 = (list) -> {
            System.out.println(System.currentTimeMillis());
            System.out.println("function mapper to Bean: " + Thread.currentThread().getName());
            Supplier<List<Bean>> supp = () ->
                    list.stream().map(Bean::new).collect(Collectors.toList());
            return CompletableFuture.supplyAsync(supp);
            //return list.stream().map(Bean::new).collect(Collectors.toList());
        };

        Consumer<List<Bean>> cons = (list) -> {
            System.out.println(System.currentTimeMillis());
            System.out.println("consumer printing beans: " + Thread.currentThread().getName());
            list.forEach((bean)->System.out.format("%s%n",bean));

        };

        System.out.println("pre cf" + System.currentTimeMillis());
        CompletableFuture<List<Long>> cf = CompletableFuture.supplyAsync(sup,executor);
        System.out.println("pre cfb" + System.currentTimeMillis());
        //CompletableFuture<List<Bean>> cfb = cf.thenApplyAsync(fun2);
        CompletableFuture<List<Bean>> cfb = cf.thenCompose(fun2);
        System.out.println("pre consumer" + System.currentTimeMillis());
        cfb.thenAcceptAsync(cons);


        Thread.sleep(500);
        executor.shutdown();
    }

}
