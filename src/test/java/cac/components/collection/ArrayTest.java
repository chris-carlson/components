package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTest {
    private Array<Integer> instance;

    @Test
    void checkValidIndex() {
        instance = new Array<>(3);
        Assertions.assertTrue(instance.isValid(2));
    }

    @Test
    void checkInvalidIndex() {
        instance = new Array<>(3);
        Assertions.assertFalse(instance.isValid(3));
    }

    @Test
    void checkSetIndex() {
        instance = ArrayCreator.create("1,2,3");
        Assertions.assertTrue(instance.isSet(2));
    }

    @Test
    void checkUnsetIndex() {
        instance = new Array<>(3);
        Assertions.assertFalse(instance.isSet(2));
    }

    @Test
    void cannotCheckIfInvalidIndexIsSet() {
        instance = new Array<>(3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.isSet(3));
    }

    @Test
    void getLength() {
        instance = new Array<>(3);
        Assertions.assertEquals(3, instance.length());
    }

    @Test
    void getElement() {
        instance = ArrayCreator.create("1,2,3");
        Assertions.assertEquals(Integer.valueOf(2), instance.get(1));
    }

    @Test
    void cannotGetElementWhenIndexIsLessThanZero() {
        instance = ArrayCreator.create("1,2,3");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(-1));
    }

    @Test
    void cannotGetElementWhenIndexIsPastUpperBound() {
        instance = ArrayCreator.create("1,2,3");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(3));
    }

    @Test
    void cannotGetElementWhenElementIsNull() {
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
        instance = ArrayCreator.create("1,2,3");
        instance.set(1, 4);
        Assertions.assertEquals(Integer.valueOf(4), instance.get(1));
    }

    @Test
    void cannotSetElementWhenIndexIsLessThanZero() {
        instance = ArrayCreator.create("1,2,3");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(-1, 2));
    }

    @Test
    void cannotSetElementWhenIndexIsPastUpperBound() {
        instance = ArrayCreator.create("1,2,3");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(3, 2));
    }

    @Test
    void cannotSetElementWhenElementIsNull() {
        instance = new Array<>(3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(1, null));
    }
}
