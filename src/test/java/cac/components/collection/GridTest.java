package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridTest {
    private Grid<Integer> instance;

    @Test
    void getDimension() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertEquals(dimension, instance.dimension());
    }

    @Test
    void checkValidPosition() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertTrue(instance.isValid(new Position(1, 2)));
    }

    @Test
    void checkInvalidPosition() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertFalse(instance.isValid(new Position(2, 2)));
    }

    @Test
    void checkSetIndex() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertTrue(instance.isSet(new Position(1, 2)));
    }

    @Test
    void checkUnsetIndex() {
        GridDimension dimension = new GridDimension(2, 3);
        instance = new Grid<>(dimension);
        Assertions.assertFalse(instance.isSet(new Position(1, 2)));
    }

    @Test
    void getElement() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertEquals(Integer.valueOf(5), instance.get(new Position(1, 1)));
    }

    @Test
    void cannotGetElementWhenPositionRowIsPastUpperBound() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(new Position(2, 0)));
    }

    @Test
    void cannotGetElementWhenPositionColumnIsPastUpperBound() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.get(new Position(0, 3)));
    }

    @Test
    void cannotGetElementWhenElementIsNull() {
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
        instance = GridCreator.create("1,2,3|4,5,6");
        instance.set(new Position(1, 1), 7);
        Assertions.assertEquals(Integer.valueOf(7), instance.get(new Position(1, 1)));
    }

    @Test
    void cannotSetElementWhenPositionRowIsPastUpperBound() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(new Position(2, 0), 2));
    }

    @Test
    void cannotSetElementWhenPositionColumnIsPastUpperBound() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(new Position(0, 3), 2));
    }

    @Test
    void cannotSetElementWhenElementIsNull() {
        instance = new Grid<>(new GridDimension(2, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.set(new Position(1, 1), null));
    }

    @Test
    void getRow() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertEquals(ArrayCreator.create("4,5,6"), instance.getRow(1));
    }

    @Test
    void cannotGetRowWhenIndexIsPastUpperBound() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.getRow(2));
    }

    @Test
    void getColumn() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertEquals(ArrayCreator.create("2,5"), instance.getColumn(1));
    }

    @Test
    void cannotGetColumnWhenIndexIsPastUpperBound() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.getColumn(4));
    }

    @Test
    void getSubGrid() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertEquals(GridCreator.create("2,3|5,6"),
                instance.getSubGrid(new Position(0, 1), new GridDimension(2, 2)));
    }

    @Test
    void cannotGetSubGridWhenPastBounds() {
        instance = GridCreator.create("1,2,3|4,5,6");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> instance.getSubGrid(new Position(0, 1), new GridDimension(2, 3)));
    }
}
