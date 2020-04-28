package ui;

import logi.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cards.TitleCard;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Hand extends JPanel {
	private JPanel currentCard;
	private ArrayList<JPanel> allCards;
	private Player p;
	private int currentCardIndex;
	
	public Hand(Player p) {
		this.p = p;
		allCards = p.getCards();
		currentCardIndex = 0;
		setSize(450,300);
		setLayout(null);
		
		
		currentCard = new TitleCard(); //inheritance hell yeah
		currentCard.setLocation(125, 0);
		add(currentCard);
		
		JButton prev = new JButton("Previous Card");
		prev.setBackground(SystemColor.controlShadow);
		prev.setFocusable(false);
		prev.setFont(new Font("Tahoma", Font.PLAIN, 10));
		prev.setBounds(10, 138, 105, 23);
		add(prev);
		
		JButton next = new JButton("Next Card");
		next.setFocusable(false);
		next.setBackground(SystemColor.controlShadow);
		next.setFont(new Font("Tahoma", Font.PLAIN, 10));
		next.setBounds(335, 138, 105, 23);
		add(next);
		
		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				previousCard();
			}
		});
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextCard();
			}
		});
		
	}
	
	public void refresh() {
		allCards = p.getCards();
	}
	
	public void nextCard() {
		currentCardIndex++;
		
		if(currentCardIndex == allCards.size()) {
			currentCardIndex = 0; //deals with overflow, just loops around the cardstack.
		}
		System.out.println(currentCardIndex);
		JPanel newCard = allCards.get(currentCardIndex);
		changeCard(newCard);
	}
	
	public void previousCard() {
		currentCardIndex--;
		if(currentCardIndex < 0) {
			currentCardIndex = allCards.size() - 1; //deals with overflow, just loops around the cardstack.
		}
		System.out.println(currentCardIndex);
		JPanel newCard = allCards.get(currentCardIndex);
		changeCard(newCard);
	}
	public void changeCard(JPanel newCard) {
		remove(currentCard);
		currentCard = newCard;
		currentCard.setLocation(125, 0);
		SwingUtilities.updateComponentTreeUI(this);
		this.repaint();
		this.validate();
		add(currentCard);
	}
}
	
	

