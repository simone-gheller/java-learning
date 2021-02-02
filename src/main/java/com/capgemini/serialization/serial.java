package com.capgemini.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;

public class serial {
    public static void main(String[] args) {
        Oggetto ogg = new Oggetto(2,"test");

        Path nfile = Paths.get("src/main/resources/serial.dat");

        try(ObjectOutputStream out = new ObjectOutputStream
                (Files.newOutputStream(nfile))) {
            out.writeObject(ogg);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(nfile))) {
            while(in.available()>=0){
                Oggetto temp = (Oggetto) in.readObject();
                System.out.println(temp);
            }
        } catch (IOException e) {
            if(e.getClass()!=EOFException.class)
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
