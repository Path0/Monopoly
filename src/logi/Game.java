package logi;

import java.util.Scanner;

import ui.PlayerUI;
import util.PopUpCard;

public class Game {
	public Player[] players;
	public Board board;
	private Player currentPlayer;
	private int currentPlayerIndex;
	public Game(int amountOfPlayers) {
		if(amountOfPlayers > 4) {
			System.out.println("Sorry, you can only have 4 players!");
		} else {
			players = new Player[amountOfPlayers];
		}
		
		
		Scanner input = new Scanner(System.in);
		for(int x = 0; x < players.length; x++) {
			System.out.println("Player " + (x+1) + ", enter your screen name.");
			String name = input.nextLine();
			players[x] = new Player(name);
		}
		input.close();
		currentPlayerIndex = 0;
		currentPlayer = players[currentPlayerIndex];
		PlayerUI.setPlayers(players);
		PlayerUI.newTurn(currentPlayer);
	}

	
	public void nextPlayer() {
		currentPlayerIndex++;
		if(currentPlayerIndex == players.length) { 
			currentPlayerIndex = 0;
		}
		currentPlayer = players[currentPlayerIndex];
		PlayerUI.newTurn(currentPlayer);
		if(isPlayerOut(currentPlayer)) {
			hasSomeoneWon();
			nextPlayer();
		}
	}
	
	public static int rollDice() {
		return (int) ((Math.random() * 6) + 1);
	}
	

	public Player[] getPlayers() {
		return players;
	}
	
	public boolean isPlayerOut(Player p) {
		if(p.getCards().size() == 0 && p.getMoney() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void hasSomeoneWon() {
		int amountOut = 0;
		for(Player p : players) {
			if(isPlayerOut(p)) {
				amountOut++;
			}
		}
		if(amountOut >= players.length - 2) {
			PlayerUI.popUp(new PopUpCard("You Won! Everyone else is bankrupt, so you now own a Monopoly!"));
		}
	}
	

}
