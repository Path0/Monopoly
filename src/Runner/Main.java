package Runner;

import java.util.Scanner;

import javax.swing.JFrame;

import logi.Game;
import ui.PlayerUI;

public class Main extends JFrame {
	public static Game game;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many players are there?");
		int playerNumber = in.nextInt();
		
		PlayerUI ui = new PlayerUI(); //yeah most everything in that class is static but since it extends JPanel it needs to be instantiated in order to show up
		game = new Game(playerNumber);
		
		// GUI setup
		JFrame main = new JFrame("Monopoly");
		main.setSize(1601,901);
		main.getContentPane().add(ui);
		main.setVisible(true);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
