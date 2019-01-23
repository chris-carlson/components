package com.cac.components.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private static final Logger LOGGER = LogManager.getLogger();

    private BufferedReader rep;
    private String currentLine;

    public Reader(String filePath) {
        try {
            rep = new BufferedReader(new FileReader(filePath));
            currentLine = rep.readLine();
        } catch (IOException exception) {
            LOGGER.error(exception);
        }
    }

    public boolean hasInput() {
        return currentLine != null;
    }

    public String readLine() {
        String line = currentLine;
        try {
            currentLine = rep.readLine();
        } catch (IOException exception) {
            LOGGER.error(exception);
        }
        return line;
    }

    public void close() {
        try {
            this.rep.close();
        } catch (IOException exception) {
            LOGGER.error(exception);
        }
    }
}
