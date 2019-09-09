package io.pykmi;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    private ArrayList<Integer> colors;
    private ArrayList<Integer> values;

    void setupTestData() {
        this.colors = new ArrayList<Integer>();
        this.values = new ArrayList<Integer>();

        colors.add(1);
        colors.add(2);
        colors.add(3);
        colors.add(4);

        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(8);
        values.add(9);
        values.add(10);
    }

    @Test
    @DisplayName("Card colors & values should match")
    public void testCard() {
        this.setupTestData();

        for(int colorIdx = 0; colorIdx < 4; colorIdx++) {
            for(int valueIdx = 0; valueIdx < 10; valueIdx++) {
                Card card = new Card(colors.get(colorIdx), values.get(valueIdx));
                assertEquals(colorIdx+1, card.getColor());
                assertEquals(valueIdx+1, card.getValue());
            }
        }
    }
}