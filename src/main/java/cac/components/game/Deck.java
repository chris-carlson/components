package cac.components.game;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@EqualsAndHashCode
@ToString
public class Deck<E> {
    @SafeVarargs
    public static <E> Deck<E> of(E... elements) {
        return new Deck<>(List.of(elements));
    }

    private List<E> drawPile;
    private final List<E> discardPile;

    public Deck() {
        drawPile = new ArrayList<>();
        discardPile = new ArrayList<>();
    }

    public Deck(List<E> drawPile) {
        if (drawPile.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("The draw pile cannot have any null elements");
        }
        this.drawPile = new ArrayList<>(drawPile);
        discardPile = new ArrayList<>();
    }

    public Deck(List<E> drawPile, List<E> discardPile) {
        this.drawPile = new ArrayList<>(drawPile);
        this.discardPile = new ArrayList<>(discardPile);
    }

    public List<E> getDrawPile() {
        return drawPile;
    }

    public List<E> getDiscardPile() {
        return discardPile;
    }

    public E draw() {
        if (drawPile.isEmpty()) {
            throw new IllegalStateException("The draw pile does not have any cards");
        }
        return drawPile.remove(0);
    }

    public void discard(E element) {
        if (element == null) {
            throw new IllegalArgumentException("The discard pile cannot have any null elements");
        }
        discardPile.add(element);
    }

    public void shuffle(Random random) {
        List<E> temp = new ArrayList<>(drawPile);
        drawPile = new ArrayList<>();
        while (!temp.isEmpty()) {
            drawPile.add(temp.remove(random.nextInt(temp.size())));
        }
    }

    public void addDiscardPileToDrawPile() {
        while (!discardPile.isEmpty()) {
            drawPile.add(discardPile.remove(0));
        }
    }
}
