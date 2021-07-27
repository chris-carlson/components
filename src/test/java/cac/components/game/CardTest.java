package cac.components.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {
    private Card instance;

    @Test
    void getSuit() {
        instance = new Card(Suit.CLUBS, Rank.ACE);
        Assertions.assertEquals(Suit.CLUBS, instance.getSuit());
    }

    @Test
    void getRank() {
        instance = new Card(Suit.CLUBS, Rank.ACE);
        Assertions.assertEquals(Rank.ACE, instance.getRank());
    }
}
