package cac.components.path;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;

@EqualsAndHashCode
@ToString
public class File {
    private static final Logger LOGGER = LogManager.getLogger();

    private java.io.File rep;

    public File(String path) {
        rep = new java.io.File(path);
    }

    public boolean exists() {
        return rep.exists();
    }

    public String getName() {
        return rep.getName();
    }

    public String getStem() {
        String name = rep.getName();
        return name.substring(0, name.indexOf('.'));
    }

    public String getSuffix() {
        String name = rep.getName();
        return name.substring(name.indexOf('.'));
    }

    public String getPath() {
        return rep.getAbsolutePath();
    }

    public String getDirectoryPath() {
        String absolutePath = rep.getAbsolutePath();
        return absolutePath.substring(0, absolutePath.lastIndexOf('\\'));
    }

    public void delete() {
        try {
            Files.delete(Path.of(rep.getAbsolutePath()));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not delete file \"{0}\"", rep.getAbsolutePath()));
        }
    }
}
