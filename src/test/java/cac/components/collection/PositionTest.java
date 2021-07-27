package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {
    private Position instance;

    @Test
    void cannotCreateInstanceWhenNumRowsIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Position(-1, 0));
    }

    @Test
    void cannotCreateInstanceWhenNumColumnsIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Position(0, -1));
    }

    @Test
    void getRow() {
        instance = new Position(1, 2);
        Assertions.assertEquals(1, instance.getRow());
    }

    @Test
    void getColumn() {
        instance = new Position(1, 2);
        Assertions.assertEquals(2, instance.getColumn());
    }
}
