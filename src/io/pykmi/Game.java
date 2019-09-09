package io.pykmi;

import java.util.Scanner;

public class Game {

    private Scanner reader;

    private Deck deck;
    private int round = 1;
    private boolean isRunning = false;
    private int dealerThreshold = 14;

    private String playerName;
    private String dealerName;

    private Player player;
    private Player dealer;

    public Game(String playerName) {
        this.isRunning = true;
        this.playerName = playerName;
        this.dealerName = "Dealer";

        // create a reader for user input
        reader = new Scanner(System.in);

        // init the deck hand hands
        deck = new Deck();
        player = new Player(PlayerTypes.PLAYER, playerName);
        dealer = new Player(PlayerTypes.DEALER, dealerName);
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void playRound() {
        // start round
        System.out.println("Round " + round + "\n");

        // deal both players their opening hands
        dealTwo(PlayerTypes.DEALER);
        dealTwo(PlayerTypes.PLAYER);

        // display players' hands
        displayHands();

        // dealer draws cards until it crosses the preset threshold
        while(dealer.handTotal() < dealerThreshold) {
            dealOne(PlayerTypes.DEALER);
        }

        // allow user to draw cards or stand, break if user crosses 21
        while(true) {
            System.out.print("\n(H)it or (S)tand? ");

            if(this.reader.nextLine().equalsIgnoreCase(("H"))) {
                dealOne(PlayerTypes.PLAYER);
                displayHands();

                if(player.handTotal() > 21) {
                    break;
                }

                continue;
            }

            break;
        }

        // decide who won
        victoryCondition();

        // check if player wants to play another round or stop the game
        if(!nextRound()) {
            stopGame();
        }
    }

    private void dealOne(PlayerTypes member) {
        if(member.equals(PlayerTypes.PLAYER)) {
            player.deal(deck.draw());
            return;
        }

        dealer.deal(deck.draw());
    }

    private void dealTwo(PlayerTypes member) {
        dealOne(member);
        dealOne(member);
    }

    private void displayHands() {
        dealer.displayHand();
        player.displayHand();
    }

    private boolean nextRound() {
        System.out.print("\nPlay another round? ");
        if(reader.nextLine().equalsIgnoreCase("y")) {
            round += 1;
            player.reset();
            dealer.reset();
            return true;
        }

        return false;
    }

    private void stopGame() {
        isRunning = false;
    }

    private void victoryCondition() {
        if(player.isOver21() && dealer.isOver21() ||
                player.isBlackJack() && dealer.isBlackJack()) {
            System.out.println("Draw!");
            return;
        }

        if(dealer.handTotal() < player.handTotal()) {
            System.out.println("You won!");
            return;
        }

        if(dealer.handTotal() > player.handTotal()) {
            System.out.println("You lost!");
            return;
        }
    }
}
