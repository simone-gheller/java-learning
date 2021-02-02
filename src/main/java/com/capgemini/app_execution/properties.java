package com.capgemini.app_execution;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class properties {
    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/prop.properties");
        Path pathXML = Paths.get("src/main/resources/prop.xml");

        Properties properties = new Properties();
        properties.setProperty("property1","1");
        properties.setProperty("quality", "medium");

        try(Writer writer = Files.newBufferedWriter(path)) {
            properties.store(writer,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(Reader reader = Files.newBufferedReader(path);
            OutputStream out = Files.newOutputStream(pathXML)) {

            properties.load(reader);
            properties.setProperty("quality", "high");
            properties.storeToXML(out,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
