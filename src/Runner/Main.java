package Runner;

import logi.Game;

public class Main {
	public static Game game;
	
	public static void main(String[] args) {
		
	}
	
	
	public static void newGame(int players) {
		game = new Game(players);
	}

}
