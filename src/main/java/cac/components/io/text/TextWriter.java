package cac.components.io.text;

import cac.components.path.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriter {
    private static final Logger LOGGER = LogManager.getLogger();

    private PrintWriter rep;

    public TextWriter(File file) {
        try {
            rep = new PrintWriter(new BufferedWriter(new FileWriter(file.getPath())));
        } catch (IOException exception) {
            LOGGER.error(exception);
        }
    }

    public void write(boolean b) {
        this.rep.print(b);
    }

    public void write(char c) {
        this.rep.print(c);
    }

    public void write(int i) {
        this.rep.print(i);
    }

    public void write(double d) {
        this.rep.print(d);
    }

    public void write(String s) {
        this.rep.print(s);
    }

    public void write(Object o) {
        this.rep.print(o);
    }

    public void writeLine() {
        this.rep.println();
    }

    public void writeLine(boolean b) {
        this.rep.println(b);
    }

    public void writeLine(char c) {
        this.rep.println(c);
    }

    public void writeLine(int i) {
        this.rep.println(i);
    }

    public void writeLine(double d) {
        this.rep.println(d);
    }

    public void writeLine(String s) {
        this.rep.println(s);
    }

    public void writeLine(Object o) {
        this.rep.println(o);
    }

    public void close() {
        this.rep.close();
    }
}
