package com.cac.components.collection;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTest {
    private Array<Integer> instance;

    @Test
    void reportLength() {
        instance = new Array<>(3);
        Assertions.assertEquals(3, instance.getLength());
    }

    @Test
    void reportElement() {
        instance = getTestInstance1();
        Assertions.assertEquals(Integer.valueOf(2), instance.get(1));
    }

    @Test
    void doNotReportElementWhenIndexIsLessThanZero() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(-1));
    }

    @Test
    void doNotReportElementWhenIndexIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(3));
    }

    @Test
    void doNotReportElementWhenElementIsNull() {
        instance = new Array<>(3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(1));
    }

    @Test
    void setElementOnUntouchedIndex() {
        instance = new Array<>(3);
        instance.set(1, 2);
        Assertions.assertEquals(Integer.valueOf(2), instance.get(1));
    }

    @Test
    void setElementOnTouchedIndex() {
        instance = getTestInstance1();
        instance.set(1, 4);
        Assertions.assertEquals(Integer.valueOf(4), instance.get(1));
    }

    @Test
    void doNotSetElementWhenIndexIsLessThanZero() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(-1, 2));
    }

    @Test
    void doNotSetElementWhenIndexIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(3, 2));
    }

    @Test
    void doNotSetElementWhenElementIsNull() {
        instance = new Array<>(3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(1, null));
    }

    @Test
    void checkEquals() {
        new EqualsTester().addEqualityGroup(getTestInstance1(), getTestInstance1())
            .addEqualityGroup(getTestInstance2(), getTestInstance2()).testEquals();
    }

    @Test
    void checkToString() {
        instance = getTestInstance1();
        Assertions.assertEquals("[1, 2, 3]", instance.toString());
    }

    private Array<Integer> getTestInstance1() {
        return ArrayCreator.create("1,2,3");
    }

    private Array<Integer> getTestInstance2() {
        return ArrayCreator.create("1,2,4");
    }
}
