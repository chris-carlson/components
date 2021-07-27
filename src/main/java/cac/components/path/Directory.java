package cac.components.path;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@EqualsAndHashCode
@ToString
public class Directory {
    private static final Logger LOGGER = LogManager.getLogger();

    private java.io.File rep;
    private List<File> files;
    private List<Directory> directories;

    public Directory(String path) {
        rep = new java.io.File(path);
        if (rep.exists() && !rep.isDirectory()) {
            throw new IllegalArgumentException("Path \"" + path + "\" is not a directory");
        }
        files = new ArrayList<>();
        directories = new ArrayList<>();
        for (java.io.File file : Objects.requireNonNull(rep.listFiles())) {
            if (file.isDirectory()) {
                directories.add(new Directory(file.getAbsolutePath()));
            } else {
                files.add(new File(file.getAbsolutePath()));
            }
        }
    }

    public boolean exists() {
        return rep.exists();
    }

    public String getName() {
        return rep.getName();
    }

    public String getPath() {
        return rep.getAbsolutePath();
    }

    public Directory join(String path) {
        return new Directory(rep.getAbsolutePath() + '\\' + path);
    }

    public boolean hasFile(String name) {
        return files.stream().anyMatch(file -> file.getName().equals(name));
    }

    public File getFile(String name) {
        Optional<File> optionalFile = files.stream().filter(file -> file.getName().equals(name)).findFirst();
        if (optionalFile.isPresent()) {
            return optionalFile.get();
        }
        throw new IllegalArgumentException("Directory \"" + getPath() + "\" does not have file \"" + name + "\"");
    }

    public List<File> getFiles() {
        return files;
    }

    public boolean hasDirectory(String name) {
        return directories.stream().anyMatch(directory -> directory.getName().equals(name));
    }

    public Directory getDirectory(String name) {
        Optional<Directory> optionalFile =
                directories.stream().filter(directory -> directory.getName().equals(name)).findFirst();
        if (optionalFile.isPresent()) {
            return optionalFile.get();
        }
        throw new IllegalArgumentException("Directory \"" + getPath() + "\" does not have directory \"" + name + "\"");
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void delete() {
        try {
            Files.delete(Path.of(rep.getAbsolutePath()));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not delete directory \"{0}\"", rep.getAbsolutePath()));
        }
    }
}
