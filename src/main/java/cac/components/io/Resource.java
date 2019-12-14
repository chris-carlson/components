package cac.components.io;

import java.nio.file.Paths;

import cac.components.path.File;

public class Resource {
    public static File getMainFile(String resourcePath) {
        return new File(getFilePath(resourcePath, "main"));
    }

    public static File getTestFile(String resourcePath) {
        return new File(getFilePath(resourcePath, "test"));
    }

    private static String getFilePath(String resourcePath, String baseFolder) {
        return Paths.get("").toAbsolutePath().toString() + "\\src\\" + baseFolder + "\\resources\\" + resourcePath;
    }

    private Resource() {
    }
}
