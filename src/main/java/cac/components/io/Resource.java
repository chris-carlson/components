package cac.components.io;

import cac.components.path.File;

import java.nio.file.Paths;

public class Resource {
    public static File getMainFile(String resourcePath) {
        return new File(getFilePath(resourcePath, "main"));
    }

    public static File getTestFile(String resourcePath) {
        return new File(getFilePath(resourcePath, "test"));
    }

    private static String getFilePath(String resourcePath, String baseFolder) {
        return Paths.get("").toAbsolutePath() + "\\src\\" + baseFolder + "\\resources\\" + resourcePath;
    }

    private Resource() {
    }
}
