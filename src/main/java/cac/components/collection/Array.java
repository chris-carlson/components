package cac.components.collection;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@EqualsAndHashCode
@ToString
public class Array<E> implements Iterable<E> {
    private final List<E> rep;

    public Array(int length) {
        rep = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            rep.add(null);
        }
    }

    Array(List<E> rep) {
        this.rep = rep;
    }

    public boolean isValid(int index) {
        return index >= 0 && index < rep.size();
    }

    public boolean isSet(int index) {
        if (!isValid(index)) {
            throw new IllegalArgumentException("Index \"" + index + "\" is not in the bounds of the array");
        }
        return rep.get(index) != null;
    }

    public int length() {
        return rep.size();
    }

    public E get(int index) {
        if (!isValid(index)) {
            throw new IllegalArgumentException("Index \"" + index + "\" is not in the bounds of the array");
        }
        if (!isSet(index)) {
            throw new IllegalArgumentException("Index \"" + index + "\" has not been set");
        }
        return rep.get(index);
    }

    public void set(int index, E element) {
        if (!isValid(index)) {
            throw new IllegalArgumentException("Index \"" + index + "\" is not in the bounds of the array");
        }
        if (element == null) {
            throw new IllegalArgumentException("An array cannot have any null elements");
        }
        rep.set(index, element);
    }

    public Stream<E> stream() {
        return rep.stream();
    }

    @Override
    public Iterator<E> iterator() {
        return rep.iterator();
    }
}
