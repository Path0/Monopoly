package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import cards.TitleCard;
import util.Deck;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Hand extends JPanel {
	public ArrayList<TitleCard> hand;
	public int cardAt;
	private JPanel CardArea;
	private TitleCard shownCard;
	private ActionListener previousCard;
	private ActionListener nextCard;
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public Hand() {
		setLayout(null);
		logic();
		JButton BackButton = new JButton("");
		BackButton.setIcon(new ImageIcon(Hand.class.getResource("/org/eclipse/jface/text/source/projection/images/expanded@2x.png")));
		BackButton.setBounds(10, 134, 32, 23);
		BackButton.addActionListener(previousCard);
		add(BackButton);
		
		JButton ForwardButton = new JButton("");
		ForwardButton.setIcon(new ImageIcon(Hand.class.getResource("/org/eclipse/jface/text/source/projection/images/collapsed@2x.png")));
		ForwardButton.setBounds(408, 134, 32, 23);
		ForwardButton.addActionListener(nextCard);
		add(ForwardButton);
		
		CardArea = new JPanel();
		CardArea.setBounds(52, 11, 346, 278);
		CardArea.add(hand.get(0));
		add(CardArea);
		
		
	}
	
	
	
	public void logic() {
		hand = new ArrayList<TitleCard>();
		addCard(Deck.ATLANTIC_AVENUE);
		cardAt = 0;
	}
	
	public void addCard(TitleCard t) {
		TitleCard a = t;
		hand.add(t);
		System.out.println(a.getCurrentRent());
		
		
		
		
		previousCard = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardAt--;
				if(cardAt <= 0) {
					
				}
				cardAt = hand.size() - 1;
				shownCard = hand.get(cardAt);
				shownCard.setVisible(true);
				CardArea.add(shownCard);
				
				
			}
		};
		
		nextCard = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
}
	
	

