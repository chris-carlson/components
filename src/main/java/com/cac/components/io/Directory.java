package com.cac.components.io;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Directory {
    private java.io.File rep;
    private List<File> files;
    private List<Directory> directories;

    public Directory(String path) {
        rep = new java.io.File(path);
        if (!rep.isDirectory()) {
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rep).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Directory other = (Directory) obj;
        return new EqualsBuilder().append(rep, other.rep).isEquals();
    }

    @Override
    public String toString() {
        return rep.getAbsolutePath();
    }
}
