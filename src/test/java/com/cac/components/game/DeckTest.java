package com.cac.components.game;

import com.google.common.collect.Lists;
import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

class DeckTest {
    private Deck<Integer> instance;

    @Test
    void doNotCreateInstanceWhenDrawPileContainsNullElements() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Deck<>(Lists.newArrayList(1, null, 2)));
    }

    @Test
    void reportDrawPileSize() {
        instance = getTestInstance1();
        Assertions.assertEquals(3, instance.getDrawPileSize());
    }

    @Test
    void draw() {
        instance = getTestInstance1();
        Assertions.assertEquals(Integer.valueOf(1), instance.draw());
    }

    @Test
    void doNotDrawWhenDrawPileIsEmpty() {
        instance = new Deck<>();
        Assertions.assertThrows(IllegalStateException.class, () -> instance.draw());
    }

    @Test
    void discard() {
        instance = getTestInstance1();
        instance.discard(6);
        List<Integer> discardPile = instance.getDiscardPile();
        Assertions.assertEquals(Integer.valueOf(6), discardPile.get(2));
    }

    @Test
    void doNotDiscardWhenElementIsNull() {
        instance = new Deck<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.discard(null));
    }

    @Test
    void shuffle() {
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt(Mockito.anyInt())).thenReturn(2, 1, 1, 1, 0);
        instance = new Deck<>(Lists.newArrayList(1, 2, 3, 4, 5));
        instance.shuffle(random);
        Assertions.assertEquals(Lists.newArrayList(3, 2, 4, 5, 1), instance.getDrawPile());
    }

    @Test
    void addDiscardPileToDrawPile() {
        instance = getTestInstance1();
        instance.addDiscardPileToDrawPile();
        Assertions.assertEquals(Lists.newArrayList(1, 2, 3, 4, 5), instance.getDrawPile());
        Assertions.assertTrue(instance.getDiscardPile().isEmpty());
    }

    @Test
    void checkEquals() {
        new EqualsTester().addEqualityGroup(getTestInstance1(), getTestInstance1())
            .addEqualityGroup(getTestInstance2(), getTestInstance2()).testEquals();
    }

    @Test
    void checkToString() {
        instance = getTestInstance1();
        Assertions.assertEquals("([1, 2, 3], [4, 5])", instance.toString());
    }

    private Deck<Integer> getTestInstance1() {
        return new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5));
    }

    private Deck<Integer> getTestInstance2() {
        return new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 6));
    }
}
