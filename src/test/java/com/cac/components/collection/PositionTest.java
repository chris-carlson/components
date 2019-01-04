package com.cac.components.collection;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {
    private Position instance;

    @Test
    void doNotCreateInstanceWhenNumRowsIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Position(-1, 0));
    }

    @Test
    void doNotCreateInstanceWhenNumColumnsIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Position(0, -1));
    }

    @Test
    void reportRow() {
        instance = getTestInstance1();
        Assertions.assertEquals(1, instance.getRow());
    }

    @Test
    void reportColumn() {
        instance = getTestInstance1();
        Assertions.assertEquals(2, instance.getColumn());
    }

    @Test
    void checkEquals() {
        new EqualsTester().addEqualityGroup(getTestInstance1(), getTestInstance1())
            .addEqualityGroup(getTestInstance2(), getTestInstance2()).testEquals();
    }

    @Test
    void checkToString() {
        instance = getTestInstance1();
        Assertions.assertEquals("(1, 2)", instance.toString());
    }

    private Position getTestInstance1() {
        return new Position(1, 2);
    }

    private Position getTestInstance2() {
        return new Position(2, 1);
    }
}
