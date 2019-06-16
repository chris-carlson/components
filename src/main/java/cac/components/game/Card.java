package cac.components.game;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(suit).append(rank).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return new EqualsBuilder().append(suit, other.suit).append(rank, other.rank).isEquals();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
