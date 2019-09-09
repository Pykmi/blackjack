package io.pykmi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class DebuggableDeck extends Deck {

    protected int getTotalValue() {
        int total = 0;

        for(int idx = 0; idx < this.deck.size(); idx++) {
            total += this.deck.get(idx).getValue();
        }

        return total;
    }

    protected int getCardsLeft() {
        return this.deck.size();
    }

}

class DeckTest {

    int expectedTotalValue = 340;
    int expectedDeckSize = 52;

    @Test
    @DisplayName("Deck's total card value should match")
    public void testTotalValue() {
        DebuggableDeck deck = new DebuggableDeck();
        assertEquals(expectedTotalValue, deck.getTotalValue());
    }

    @Test
    @DisplayName("Cards left in the deck should match")
    public void testCardsLeft() {
        DebuggableDeck deck = new DebuggableDeck();
        assertEquals(expectedDeckSize, deck.getCardsLeft());
    }

    @Test
    @DisplayName("Fresh deck should be legal")
    public void testLegalDeck() {
        DebuggableDeck deck = new DebuggableDeck();

        Map<Integer, Integer> expectedCards = new HashMap<>();
        Map<Integer, Integer> actualCards = new HashMap<>();

        // generate correct values for what cards should be expected
        expectedCards.put(2, 4);
        expectedCards.put(3, 4);
        expectedCards.put(4, 4);
        expectedCards.put(5, 4);
        expectedCards.put(6, 4);
        expectedCards.put(7, 4);
        expectedCards.put(8, 4);
        expectedCards.put(9, 4);
        expectedCards.put(10, 16);
        expectedCards.put(1, 4);

        // generate starting point for actual cards are found
        actualCards.put(2, 0);
        actualCards.put(3, 0);
        actualCards.put(4, 0);
        actualCards.put(5, 0);
        actualCards.put(6, 0);
        actualCards.put(7, 0);
        actualCards.put(8, 0);
        actualCards.put(9, 0);
        actualCards.put(10, 0);
        actualCards.put(1, 0);

        // calculate what actual cards the deck generated
        for(int idx = 0; idx < expectedDeckSize; idx++) {
            Card card = deck.draw();
            actualCards.replace(card.getValue(), actualCards.get(card.getValue()) + 1);
        }

        assertTrue(expectedCards.equals(actualCards), "The full fresh deck is legal");
    }

}