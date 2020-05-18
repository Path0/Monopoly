package logi;

import java.util.Scanner;

public class Game {
	public Player[] players;
	public Board board;
	public Game(int amountOfPlayers) {
		if(amountOfPlayers > 4) {
			System.out.println("Sorry, you can only have 4 players!");
		} else {
			players = new Player[amountOfPlayers];
		}
		
		newGame();
	}
	
	
	
	public void newGame() {
		Scanner in = new Scanner(System.in);
		for(int x = 0; x < players.length; x++) {
			System.out.println("Player " + (x+1) + ", enter your screen name.");
			String name = in.nextLine();
			players[x] = new Player(name);
		}
		in.close();
	}
	
	
	public void rotation() {
		
	}
	
	public static int rollDice() {
		return (int) ((Math.random() * 6) + 1);
	}
	
	public Player[] getPlayers() {
		return players;
	}

}
