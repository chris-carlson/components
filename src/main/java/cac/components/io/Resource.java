package cac.components.io;

import java.nio.file.Paths;

public class Resource {
    public static String getFilePath(String resourcePath) {
        return Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\" + resourcePath;
    }

    private Resource() {
    }
}
