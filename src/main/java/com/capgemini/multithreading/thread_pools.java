package com.capgemini.multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class thread_pools {
    public static void main(String[] args) {

        Runnable task = ()->{
            for(int j=0;j<5;j++){
                Random random = new Random();
                Integer i = random.nextInt(50);
                System.out.printf("%s: integer %d%n",Thread.currentThread().getName(),i);
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            ex.submit(task);
        }
        ex.shutdown();
        try {
            if(!ex.awaitTermination(60, TimeUnit.SECONDS))
                System.out.println("bad");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //-----------------------------------------------

        Callable<Integer> callable = () -> {
            Random random = new Random();
            return random.nextInt(50);
        };

        Future<Integer>[] results = new Future[10];
        ex = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            results[i] = ex.submit(callable);
        }
        ex.shutdown();
        try {
            if(!ex.awaitTermination(60, TimeUnit.SECONDS))
                System.out.println("bad");
            else
            {
                for (Future<Integer> i:results) {
                    System.out.println(i.get());
                }
            }
        } catch (ExecutionException e) {
            System.out.println(e.getCause().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
