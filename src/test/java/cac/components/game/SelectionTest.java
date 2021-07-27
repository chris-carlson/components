package cac.components.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SelectionTest {
    private Selection<Integer> instance;

    @Test
    void drawCity() {
        instance = new Selection<>(new Deck<>(List.of(1, 2)));
        instance.addToTableau();
        Assertions.assertEquals(List.of(1), instance.getTableau());
    }

    @Test
    void cannotDrawCity() {
        instance = new Selection<>(new Deck<>(new ArrayList<>()));
        Assertions.assertThrows(IllegalStateException.class, instance::addToTableau);
    }

    @Test
    void discardCity() {
        instance = new Selection<>(new Deck<>(List.of(1, 2)));
        instance.addToTableau();
        instance.removeFromTableau(1);
        Assertions.assertEquals(List.of(), instance.getTableau());
    }

    @Test
    void cannotDiscardCity() {
        instance = new Selection<>(new Deck<>(List.of(1)));
        instance.addToTableau();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.removeFromTableau(2));
    }
}
