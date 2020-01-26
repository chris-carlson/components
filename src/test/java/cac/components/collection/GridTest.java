package cac.components.collection;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridTest {
    private Grid<Integer> instance;

    @Test
    void reportDimension() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertEquals(dimension, instance.getDimension());
    }

    @Test
    void checkPositionIsValid() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertTrue(instance.isValid(new Position(1, 2)));
    }

    @Test
    void checkPositionIsInvalid() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertFalse(instance.isValid(new Position(2, 2)));
    }

    @Test
    void reportElement() {
        instance = getTestInstance1();
        Assertions.assertEquals(Integer.valueOf(5), instance.get(new Position(1, 1)));
    }

    @Test
    void doNotReportElementWhenPositionRowIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(new Position(2, 0)));
    }

    @Test
    void doNotReportElementWhenPositionColumnIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(new Position(0, 3)));
    }

    @Test
    void doNotReportElementWhenElementIsNull() {
        instance = new Grid<>(new GridDimension(2, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(new Position(1, 1)));
    }

    @Test
    void setElementOnUntouchedIndex() {
        instance = new Grid<>(new GridDimension(2, 3));
        instance.set(new Position(1, 1), 5);
        Assertions.assertEquals(Integer.valueOf(5), instance.get(new Position(1, 1)));
    }

    @Test
    void setElementOnTouchedIndex() {
        instance = getTestInstance1();
        instance.set(new Position(1, 1), 7);
        Assertions.assertEquals(Integer.valueOf(7), instance.get(new Position(1, 1)));
    }

    @Test
    void doNotSetElementWhenPositionRowIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(new Position(2, 0), 2));
    }

    @Test
    void doNotSetElementWhenPositionColumnIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(new Position(0, 3), 2));
    }

    @Test
    void doNotSetElementWhenElementIsNull() {
        instance = new Grid<>(new GridDimension(2, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(new Position(1, 1), null));
    }

    @Test
    void reportRow() {
        instance = getTestInstance1();
        Assertions.assertEquals(ArrayCreator.create("4,5,6"), instance.getRow(1));
    }

    @Test
    void doNotReportRowWhenIndexIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.getRow(2));
    }

    @Test
    void reportColumn() {
        instance = getTestInstance1();
        Assertions.assertEquals(ArrayCreator.create("2,5"), instance.getColumn(1));
    }

    @Test
    void doNotReportColumnWhenIndexIsPastUpperBound() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.getColumn(4));
    }

    @Test
    void reportSubGrid() {
        instance = getTestInstance1();
        Assertions.assertEquals(GridCreator.create("2,3|5,6"),
                instance.getSubGrid(new Position(0, 1), new GridDimension(2, 2)));
    }

    @Test
    void doNotReportSubGridWhenPastBounds() {
        instance = getTestInstance1();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> instance.getSubGrid(new Position(0, 1), new GridDimension(2, 3)));
    }

    @Test
    void checkEquals() {
        new EqualsTester().addEqualityGroup(getTestInstance1(), getTestInstance1())
                .addEqualityGroup(getTestInstance2(), getTestInstance2()).testEquals();
    }

    @Test
    void checkToString() {
        instance = getTestInstance1();
        Assertions.assertEquals("[[1, 2, 3], [4, 5, 6]]", instance.toString());
    }

    private Grid<Integer> getTestInstance1() {
        return GridCreator.create("1,2,3|4,5,6");
    }

    private Grid<Integer> getTestInstance2() {
        return GridCreator.create("1,2,3|4,5,7");
    }
}
