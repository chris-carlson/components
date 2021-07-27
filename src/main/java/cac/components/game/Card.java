package cac.components.game;

public record Card(Suit suit, Rank rank) {
    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}
