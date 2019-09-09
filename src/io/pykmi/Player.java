package io.pykmi;

import java.util.ArrayList;

enum PlayerTypes {
    PLAYER,
    DEALER
}

public class Player {

    private ArrayList<Card> hand;

    private String playerName;
    private PlayerTypes type;

    public Player(PlayerTypes type, String playerName) {
        this.hand = new ArrayList<>();
        this.playerName = playerName;
        this.type = type;
    }

    public void deal(Card card) {
        hand.add(card);
    }

    public void displayHand() {
        System.out.print(playerName + " hand:");

        for(Card card : hand) {
            System.out.print("  " + card.getValue());
        }

        System.out.println("");
    }

    public int handTotal() {
        int total = 0;

        for (Card card : hand) {
            total += card.getValue();
        }

        return total;
    }

    public boolean isBlackJack() {
        if(handTotal() == 21) {
            return true;
        }

        return false;
    }

    public boolean isOver21() {
        if(handTotal() > 21) {
            return true;
        }

        return false;
    }

    public void reset() {
        hand.clear();
    }
}
