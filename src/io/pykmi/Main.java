package io.pykmi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Player name: ");
        String playerName = reader.nextLine();

	    Game game = new Game(playerName);

	    while(game.isRunning()) {
	        game.playRound();
        }
    }
}
