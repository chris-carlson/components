package cac.components.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Selection<E> {
    @SafeVarargs
    public static <E> Selection<E> of(E... elements) {
        return new Selection<>(Deck.of(elements));
    }

    @Getter
    private final Deck<E> deck;
    @Getter
    private final List<E> tableau;

    public Selection(Deck<E> deck) {
        this.deck = deck;
        tableau = new ArrayList<>();
    }

    public void addToTableau() {
        E element = deck.draw();
        tableau.add(element);
    }

    public void removeFromTableau(E element) {
        if (!tableau.contains(element)) {
            throw new IllegalArgumentException("Element " + element + " is not in the selection");
        }
        tableau.remove(element);
        deck.discard(element);
    }
}
