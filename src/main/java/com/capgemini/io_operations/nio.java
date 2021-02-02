package com.capgemini.io_operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class nio {

    public static void main(String[] args) {

        long timer;
        Path path;


        timer = System.currentTimeMillis();
        path = Paths.get("src/main/resources/example.txt");
        try {
            Files.readAllLines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("TIME IS UP: %dms\n",System.currentTimeMillis()-timer);

        timer = System.currentTimeMillis();
        path = Paths.get("src/main/resources/example.txt");
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String string;
            while((string = reader.readLine()) != null)
                System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("TIME IS UP: %dms\n",System.currentTimeMillis()-timer);



    }
}
