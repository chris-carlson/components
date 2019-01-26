package com.cac.components.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;

public class Resource {
    private static final Logger LOGGER = LogManager.getLogger();

    public static String getFilePath(String resourcePath) {
        return Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\" + resourcePath;
    }

    private Resource() {
    }
}
