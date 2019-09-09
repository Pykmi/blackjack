package io.pykmi;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    protected ArrayList<Card> deck;

    private int valueAce = 1;
    private int valueFaceCard = 10;

    public Deck() {
        this.init();
    }

    public Card draw() {
        int cardIdx = this.selectCard();
        Card card = this.deck.get(cardIdx);
        this.deck.remove(cardIdx);
        return card;
    }

    public void reset() {
        this.init();
    }

    private void init() {
        this.deck = new ArrayList<>();

        for(int color = 0; color < 4; color++) {
            this.addNumberedCards(color);
            this.addFaceCards(color);
            this.addAce(color);
        }
    }

    private void addNumberedCards(int color) {
        for(int value = 1; value < 10; value++) {
            this.deck.add(new Card(color, value+1));
        }
    }

    private void addAce(int color) {
        this.deck.add(new Card(color, this.valueAce));
    }

    private void addFaceCards(int color) {
        for(int i = 0; i < 3; i++) {
            this.deck.add(new Card(color, this.valueFaceCard));
        }
    }

    protected int selectCard() {
        Random generate = new Random();
        int idx = generate.nextInt(this.deck.size());

        return idx;
    }

}
