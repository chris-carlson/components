package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridDimensionTest {
    private GridDimension instance;

    @Test
    void cannotInitializeNegativeRows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GridDimension(-1, 3));
    }

    @Test
    void cannotInitializeNegativeColumns() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GridDimension(2, -1));
    }

    @Test
    void getNumRows() {
        instance = new GridDimension(2, 3);
        Assertions.assertEquals(2, instance.getNumRows());
    }

    @Test
    void getNumColumns() {
        instance = new GridDimension(2, 3);
        Assertions.assertEquals(3, instance.getNumColumns());
    }
}
