package io.pykmi;

public class Card {
    private int color;
    private int value;

    public Card(int color, int value) {
        this.color = color;
        this.value = value;
    }

    public int getColor() {
        return this.color;
    }

    public int getValue() {
        return this.value;
    }
}
