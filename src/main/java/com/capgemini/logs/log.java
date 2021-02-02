package com.capgemini.logs;

import java.io.IOException;
import java.util.logging.*;

public class log {
    private static final Logger logger = Logger.getLogger("test");

    public static void main(String[] args) {

        Handler handler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);

        handler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);

        //---------------------------------------

        try {
            Handler fileHandler = new FileHandler("src//main/resources/%g_log.log",1000,3);
            fileHandler.setFormatter(formatter);
            fileHandler.setLevel(Level.ALL);

            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.log(Level.ALL, "TEST");

    }
}
