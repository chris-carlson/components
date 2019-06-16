package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionIteratorTest {
    private PositionIterator instance;

    @Test
    void hasNext() {
        instance = new PositionIterator(new Dimension(2, 2), 1, 1);
        Assertions.assertTrue(instance.hasNext());
    }

    @Test
    void doesNotHaveNext() {
        instance = new PositionIterator(new Dimension(2, 2), 2, 0);
        Assertions.assertFalse(instance.hasNext());
    }

    @Test
    void next() {
        instance = new PositionIterator(new Dimension(2, 2), 1, 1);
        Assertions.assertEquals(new Position(1, 1), instance.next());
    }

    @Test
    void cannotGetNext() {
        instance = new PositionIterator(new Dimension(2, 2), 2, 0);
        assertThrows(NoSuchElementException.class, () -> instance.next());
    }
}
