package cac.components.path;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@EqualsAndHashCode
@ToString
public class Directory {
    private static final Logger LOGGER = LogManager.getLogger();

    private final java.io.File rep;

    public static Directory getCwd() {
        return new Directory(Paths.get("").toAbsolutePath().toString());
    }

    public static Directory getEnvironmentDirectory(String environmentVariable) {
        return new Directory(System.getenv(environmentVariable));
    }

    public Directory(String path) {
        rep = new java.io.File(path);
        if (rep.exists() && !rep.isDirectory()) {
            throw new IllegalArgumentException("Path \"" + path + "\" is not a directory");
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

    public Directory joinDirectory(String path) {
        return new Directory(rep.getAbsolutePath() + '\\' + path);
    }

    public File joinFile(String path) {
        return joinFile(path, "");
    }

    public File joinFile(String path, String extension) {
        return new File(rep.getAbsolutePath() + '\\' + path + extension);
    }

    public boolean hasFile(String name) {
        List<File> files = getFiles();
        return files.stream().anyMatch(file -> file.getName().equals(name));
    }

    public File getFile(String name) {
        List<File> files = getFiles();
        Optional<File> optionalFile = files.stream().filter(file -> file.getName().equals(name)).findFirst();
        if (optionalFile.isPresent()) {
            return optionalFile.get();
        }
        throw new IllegalArgumentException("Directory \"" + getPath() + "\" does not have file \"" + name + "\"");
    }

    public List<File> getFiles() {
        List<File> files = new ArrayList<>();
        for (java.io.File file : Objects.requireNonNull(rep.listFiles())) {
            if (!file.isDirectory()) {
                files.add(new File(file.getAbsolutePath()));
            }
        }
        return files;
    }

    public boolean hasDirectory(String name) {
        List<Directory> directories = getDirectories();
        return directories.stream().anyMatch(directory -> directory.getName().equals(name));
    }

    public Directory getDirectory(String name) {
        List<Directory> directories = getDirectories();
        Optional<Directory> optionalFile =
                directories.stream().filter(directory -> directory.getName().equals(name)).findFirst();
        if (optionalFile.isPresent()) {
            return optionalFile.get();
        }
        throw new IllegalArgumentException("Directory \"" + getPath() + "\" does not have directory \"" + name + "\"");
    }

    public List<Directory> getDirectories() {
        List<Directory> directories = new ArrayList<>();
        for (java.io.File file : Objects.requireNonNull(rep.listFiles())) {
            if (file.isDirectory()) {
                directories.add(new Directory(file.getAbsolutePath()));
            }
        }
        return directories;
    }

    public void rename(String name) {
        try {
            Files.move(Path.of(rep.getAbsolutePath()), Path.of(name));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not move directory \"{0}\"", rep.getAbsolutePath()));
        }
    }

    public void copy(String name) {
        try {
            Files.copy(Path.of(rep.getAbsolutePath()), Path.of(name));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not copy directory \"{0}\"", rep.getAbsolutePath()));
        }
    }

    public void delete() {
        try {
            Files.delete(Path.of(rep.getAbsolutePath()));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not delete directory \"{0}\"", rep.getAbsolutePath()));
        }
    }
}
