package cac.components.io;

import java.nio.file.Paths;

import cac.components.path.File;

public class Resource {
    public static File getMainFile(String resourcePath) {
        File file = new File(getFilePath(resourcePath, "main"));
        if (!file.exists()) {
            throw new IllegalArgumentException("Could not find resource with path \"" + resourcePath + "\"");
        }
        return file;
    }

    public static File getTestFile(String resourcePath) {
        File file = new File(getFilePath(resourcePath, "test"));
        if (!file.exists()) {
            throw new IllegalArgumentException("Could not find resource with path \"" + resourcePath + "\"");
        }
        return file;
    }

    private static String getFilePath(String resourcePath, String baseFolder) {
        return Paths.get("").toAbsolutePath().toString() + "\\src\\" + baseFolder + "\\resources\\" + resourcePath;
    }

    private Resource() {
    }
}
