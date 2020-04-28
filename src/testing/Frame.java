package testing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import cards.TitleCard;
import designs.Chest;
import logi.Player;
import ui.Hand;
import util.Deck;
import util.Groups;

public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		
		
		setContentPane(contentPane);
		
		Player p = new Player("bruh");
		p.addCard(Deck.ATLANTIC_AVENUE);
		p.addCard(Deck.BALTIC_AVENUE);
		for(JPanel card : Groups.ALL_PROPERTIES) {
			p.addCard((TitleCard) card); 
		}
		p.addCard(Deck.READING_RAILROAD);
		p.addCard(Deck.WATER_WORKS);
		
		Hand h = new Hand(p);
		h.setSize(450,300);
		h.setVisible(true);
		contentPane.setLayout(null);
		contentPane.add(h);
	}
}
