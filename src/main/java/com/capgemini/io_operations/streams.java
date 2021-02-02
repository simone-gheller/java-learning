package com.capgemini.io_operations;

import java.io.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streams {

    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();

        try (FileReader fileReader = new FileReader("src/main/resources/example.txt")){
            char[] buffer = new char[8];
            int length;
            while((length = fileReader.read(buffer)) >= 0){
                for(int i=0;i<length; i++){
                    System.out.print(buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("\nTIME IS UP: %dms%n",System.currentTimeMillis()-time1);
        System.out.println("--------------------------------------------");
        time1 = System.currentTimeMillis();

        try(BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/example.txt"))) {
            char[] buffer = new char[8];
            int length;
            while((length = buffReader.read(buffer)) >= 0){
                System.out.printf("%s",new String(buffer).substring(0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("\nTIME IS UP: %dms%n",System.currentTimeMillis()-time1);


        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/example.txt",true))){
            String string = "ciao";
            fileWriter.newLine();
            fileWriter.append(string);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
