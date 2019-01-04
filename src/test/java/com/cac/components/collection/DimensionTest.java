package com.cac.components.collection;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DimensionTest {
    private Dimension instance;

    @Test
    void doNotCreateInstanceWhenNumRowsIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Dimension(-1, 0));
    }

    @Test
    void doNotCreateInstanceWhenNumColumnsIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Dimension(0, -1));
    }

    @Test
    void reportNumRows() {
        instance = getTestInstance1();
        Assertions.assertEquals(1, instance.getNumRows());
    }

    @Test
    void reportNumColumns() {
        instance = getTestInstance1();
        Assertions.assertEquals(2, instance.getNumColumns());
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

    private Dimension getTestInstance1() {
        return new Dimension(1, 2);
    }

    private Dimension getTestInstance2() {
        return new Dimension(2, 1);
    }
}
