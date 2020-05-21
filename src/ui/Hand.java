package ui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cards.Card;
import cards.Railroad;
import cards.TitleCard;
import cards.UtilityCard;
import logi.Player;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Hand extends JPanel {
	private Card currentCard;
	public ArrayList<Card> allCards;
	private Player player;
	private int currentCardIndex;
	private JButton buyHouseButton;
	private JButton mortgageButton;
	private JTextField txtHouses;
	
	
	public Hand(Player p) {
		this.player = p;
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
		
		buyHouseButton = new JButton("Buy House");
		buyHouseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyHouse();
			}
		});
		buyHouseButton.setBounds(335, 266, 105, 23);
		add(buyHouseButton);
		
		mortgageButton = new JButton("Mortgage Property");
		mortgageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mortgageProperty();
			}
		});
		mortgageButton.setBounds(10, 266, 105, 23);
		add(mortgageButton);
		
		txtHouses = new JTextField();
		txtHouses.setFocusable(false);
		txtHouses.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtHouses.setAutoscrolls(false);
		txtHouses.setBackground(SystemColor.menu);
		txtHouses.setEditable(false);
		txtHouses.setHorizontalAlignment(SwingConstants.CENTER);
		if(currentCard instanceof TitleCard) {
			txtHouses.setText(((TitleCard) currentCard).getHouses() + " Houses");
			txtHouses.setBounds(335, 239, 105, 20);
			add(txtHouses);
			txtHouses.setColumns(10);
		}
		
		
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
		allCards = player.getCards();
	}
	
	public void nextCard() {
		currentCardIndex++;
		if(currentCardIndex == allCards.size()) {
			currentCardIndex = 0; //deals with overflow, just loops around the cardstack.
		}
		Card newCard = allCards.get(currentCardIndex);
		changeCard(newCard);
	}
	
	public void previousCard() {
		currentCardIndex--;
		if(currentCardIndex < 0) {
			currentCardIndex = allCards.size() - 1; //deals with overflow, just loops around the cardstack.
		}
		Card newCard = allCards.get(currentCardIndex);
		changeCard(newCard);
	}
	public void changeCard(Card newCard) {
		remove(currentCard);
		currentCard = newCard;
		currentCard.setLocation(125, 0);
		SwingUtilities.updateComponentTreeUI(this);
		this.repaint();
		this.validate();
		add(currentCard);
		if(currentCard instanceof TitleCard) {
			txtHouses.setText(((TitleCard) currentCard).getHouses() + " Houses");
			txtHouses.setBounds(335, 239, 105, 20);
			add(txtHouses);
			txtHouses.setColumns(10);
		}
	}
	
	
	public void mortgageProperty() {
		player.removeCard(currentCard);
		if(currentCard instanceof TitleCard) {
			player.addMoney( ( ( TitleCard ) currentCard ).getMortgageVal() );
		}
		if(currentCard instanceof Railroad) {
			player.addMoney( ( ( Railroad ) currentCard ).getMortgageVal() );
		}
		if(currentCard instanceof UtilityCard) {
			player.addMoney( ( ( UtilityCard ) currentCard ).getMortgageVal() );
		}
		PlayerUI.update(player);
	}
	
	public void buyHouse() {
		( (TitleCard) currentCard).addHouse();
		player.subtractMoney(((TitleCard) currentCard).getHouseCost());
		if(currentCard instanceof TitleCard) {
			txtHouses.setText(((TitleCard) currentCard).getHouses() + " Houses");
			txtHouses.setBounds(335, 239, 105, 20);
			add(txtHouses);
			txtHouses.setColumns(10);
		}
		PlayerUI.update(player);
		
	}
}
	
	

