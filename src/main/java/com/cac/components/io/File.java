package com.cac.components.io;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class File {
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
        File other = (File) obj;
        return new EqualsBuilder().append(rep, other.rep).isEquals();
    }

    @Override
    public String toString() {
        return rep.getAbsolutePath();
    }
}
