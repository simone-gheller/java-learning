package com.capgemini.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Oggetto implements Serializable{

    private static final long serialVersionUID = -3500365377417175598L;
    int number;
    String string;

    public Oggetto(int n, String s) {
        this.number = n;
        this.string = s;
    }

    public Oggetto() {

    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("test");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        number = fields.get("number",0);
        string = (String) fields.get("string", "default");
        System.out.println("test");
    }


    @Override
    public String toString() {
        return String.format("Oggetto: number %d, string %s.",number,string);
    }
}
