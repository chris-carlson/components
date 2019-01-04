package com.cac.components.collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Array<E> {
    private List<E> rep;

    public Array(int length) {
        rep = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            rep.add(null);
        }
    }

    Array(List<E> rep) {
        this.rep = rep;
    }

    public int getLength() {
        return rep.size();
    }

    public E get(int index) {
        if (index < 0 || index >= rep.size()) {
            throw new IllegalArgumentException("Index \"" + index + "\" is not in the bounds of the array");
        }
        E element = rep.get(index);
        if (element == null) {
            throw new IllegalArgumentException("Index \"" + index + "\" has not been set");
        }
        return element;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= rep.size()) {
            throw new IllegalArgumentException("Index \"" + index + "\" is not in the bounds of the array");
        }
        if (element == null) {
            throw new IllegalArgumentException("An array cannot have any null elements");
        }
        rep.set(index, element);
    }

    boolean isSet(int index) {
        return rep.get(index) != null;
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
        Array<E> other = (Array<E>) obj;
        return new EqualsBuilder().append(rep, other.rep).isEquals();
    }

    @Override
    public String toString() {
        return rep.toString();
    }
}
