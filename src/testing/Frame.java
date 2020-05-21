package testing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Runner.Main;
import logi.Board;
import logi.Game;
import logi.Player;
import spaces.Space;
import ui.PlayerUI;
import util.Deck;


public class Frame extends JFrame {

	private JPanel contentPane;
	private boolean pressed = false;
	/**
	 * Launch the application.
	 */
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public Frame() {
		setSize(1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		Player p1 = new Player("player1");
		p1.addCard(Deck.ATLANTIC_AVENUE);
		p1.addCard(Deck.BOARDWALK);
		p1.setPosition(2);
		p1.addMoney(1000);
		
		Player p2 = new Player("player2");
		p2.addCard(Deck.B_AND_O_RAILROAD);
		p2.setPosition(2);
		p2.setMoney(21);
		Main.game = new Game(2);
		Main.game.players = new Player[] {p1,p2};
		
		PlayerUI p = new PlayerUI();
		getContentPane().add(p);

		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!pressed) {
					PlayerUI.update(p1);
					p.repaint();
					pressed = true;
					((Space) Board.board[p1.getPosition()-1] ).land(p1);
				} else {
					PlayerUI.update(p2);
					((Space) Board.board[p2.getPosition()-1] ).land(p2);
					p.repaint();
					
				}
			}
		});
		btnNewButton.setBounds(1683, 556, 89, 23);
		p.add(btnNewButton);
		
	}
}
