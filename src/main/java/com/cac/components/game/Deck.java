package com.cac.components.game;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Deck<E> {
    private List<E> drawPile;
    private List<E> discardPile;

    public Deck() {
        drawPile = new ArrayList<>();
        discardPile = new ArrayList<>();
    }

    public Deck(List<E> elements) {
        if (elements.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("The draw pile cannot have any null elements");
        }
        drawPile = new ArrayList<>(elements);
        discardPile = new ArrayList<>();
    }

    Deck(List<E> drawPile, List<E> discardPile) {
        this.drawPile = new ArrayList<>(drawPile);
        this.discardPile = new ArrayList<>(discardPile);
    }

    public int getDrawPileSize() {
        return drawPile.size();
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

    List<E> getDrawPile() {
        return drawPile;
    }

    List<E> getDiscardPile() {
        return discardPile;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(drawPile).append(discardPile).toHashCode();
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
        Deck other = (Deck) obj;
        return new EqualsBuilder().append(drawPile, other.drawPile).append(discardPile, other.discardPile).isEquals();
    }

    @Override
    public String toString() {
        return "(" + drawPile.toString() + ", " + discardPile.toString() + ")";
    }
}
