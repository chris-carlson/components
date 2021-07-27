package cac.components.game;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

class DeckTest {
    private Deck<Integer> instance;

    @Test
    void cannotCreateInstanceWhenDrawPileContainsNullElements() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Deck<>(Lists.newArrayList(1, null, 2)));
    }

    @Test
    void getDrawPileSize() {
        instance = new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5));
        Assertions.assertEquals(Lists.newArrayList(1, 2, 3), instance.getDrawPile());
    }

    @Test
    void getDiscardPileSize() {
        instance = new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5));
        Assertions.assertEquals(Lists.newArrayList(4, 5), instance.getDiscardPile());
    }

    @Test
    void draw() {
        instance = new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5));
        Assertions.assertEquals(Integer.valueOf(1), instance.draw());
    }

    @Test
    void cannotDrawWhenDrawPileIsEmpty() {
        instance = new Deck<>();
        Assertions.assertThrows(IllegalStateException.class, () -> instance.draw());
    }

    @Test
    void discard() {
        instance = new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5));
        instance.discard(6);
        List<Integer> discardPile = instance.getDiscardPile();
        Assertions.assertEquals(Integer.valueOf(6), discardPile.get(2));
    }

    @Test
    void cannotDiscardWhenElementIsNull() {
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
        instance = new Deck<>(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5));
        instance.addDiscardPileToDrawPile();
        Assertions.assertEquals(Lists.newArrayList(1, 2, 3, 4, 5), instance.getDrawPile());
        Assertions.assertTrue(instance.getDiscardPile().isEmpty());
    }
}
