package cac.components.random;

import java.util.List;

public class Random {
    private final java.util.Random rep;

    public Random() {
        rep = new java.util.Random();
    }

    public int getRandomNumber(int start, int end) {
        return rep.nextInt(end - start + 1) + start;
    }

    public <E> int getRandomIndex(List<E> list) {
        return getRandomNumber(0, list.size() - 1);
    }

    public <E> E getRandomElement(List<E> list) {
        return list.get(getRandomIndex(list));
    }

    public float getRandomPercent() {
        return rep.nextFloat() * 100;
    }

    public CoinSide flipCoin() {
        return flipCoin(50);
    }

    public CoinSide flipCoin(float weight) {
        float percent = getRandomPercent();
        return percent < weight ? CoinSide.HEADS : CoinSide.TAILS;
    }
}
