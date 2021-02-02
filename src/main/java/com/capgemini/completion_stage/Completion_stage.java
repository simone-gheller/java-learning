package com.capgemini.completion_stage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Completion_stage {

    public static void main(String[] args) {
        CompletableFuture<Void> cf =
                CompletableFuture.runAsync(()-> System.out.println("this is running in parallel"));
        cf.complete(null);

        CompletableFuture<String> cf2 =
                CompletableFuture.supplyAsync(()-> "This is a supplier " + Thread.currentThread().getName());
        //cf2.complete("test");

        System.out.println(cf2.join());



    }
}
