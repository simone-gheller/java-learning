package com.capgemini.io_operations;

import static java.nio.file.StandardCopyOption.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;

public class files {
    public static void main(String[] args) {
        try {
            Path examples = Paths.get("src/main/resources/example.txt");
            Path path = Paths.get("src/main/resources/copy.txt");
            Files.copy(examples,path, REPLACE_EXISTING);
        } catch ( IOException e) {
            e.printStackTrace();
        }

    }
}
