package logi;

import java.util.ArrayList;

import javax.swing.JPanel;

import cards.Card;
import spaces.PropertySpace;
import spaces.RailroadSpace;
import spaces.UtilitySpace;
public class Player {
	private String name;
	private int position;
	private int money;
	private ArrayList<Card> cards;
	private boolean getOutOfJailFree;
	private boolean inJail;
	public int railroadsOwned;
	public int utilitiesOwned;
	
	public Player(String name) {
		this.name = name;
		position = 1;
		money = 15000;
		cards = new ArrayList<Card>();
		getOutOfJailFree = false;
		inJail = false;
		railroadsOwned = 0;
	}
	
	public Player(Player p) {
		this.name = p.name;
		this.position = p.position;
		this.money = p.money;
		this.cards = p.cards;
		this.getOutOfJailFree = p.getOutOfJailFree;
		this.inJail = p.inJail;
		this.railroadsOwned = p.railroadsOwned;
		this.utilitiesOwned = p.utilitiesOwned;
	}
	
	public void addCard(Card t) {
		cards.add(t);
	}
	
	public JPanel getCardByName(String name) {
		JPanel title = null;
		for(JPanel t :  cards) {
			if(t.getName().equals(name)) {
				title = t;
			}
		}
		return title;
	}
	
	public void addMoney(int amount) {
		money += amount;
	}
	
	public void subtractMoney(int amount) {
		money -= amount;
	}
	
	public void payPlayer(Player p, int amount) {
		subtractMoney(amount);
		p.addMoney(amount);
	}
	
	public void checkRents() {
		//TODO
	}
	
	public void move(int spaces) {
		int newPos = this.position + spaces;
		if(newPos < 1) {
			newPos = Board.getAmountOfSpaces() + spaces;
		} else if(newPos > Board.getAmountOfSpaces()) {
			newPos = newPos - Board.getAmountOfSpaces();
		} 
		this.position = newPos;
	}
	
	public void passGo() {
		this.addMoney(2000);
	}
	
	public int getRailroadRent() {
		switch(railroadsOwned) {
		case 1:
			return 250;
		case 2:
			return 500;
		case 3:
			return 1000;
		case 4:
			return 2000;
		default:
			return 0;
		}
	}
	
	public int getUtilityRent() {
		if(utilitiesOwned == 1) {
			return Game.rollDice() * 40;
		} else if(utilitiesOwned == 2) {
			return Game.rollDice() * 100;
		} else {
			return 0;
		}
	}
	
	public void removeCard(Card j) {
		cards.remove(j);
		int position = Card.findPosition(j.getName());
		if(Board.board[position] instanceof PropertySpace) {
			PropertySpace p = (PropertySpace) Board.board[position];
			p.owned = false;
		}
		if(Board.board[position] instanceof RailroadSpace) {
			RailroadSpace p = (RailroadSpace) Board.board[position];
			p.owned = false;
		}
		if(Board.board[position] instanceof UtilitySpace) {
			UtilitySpace p = (UtilitySpace) Board.board[position];
			p.owned = false;
		}
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * @return the cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	/**
	 * @return the getOutOfJailFree
	 */
	public boolean isGetOutOfJailFree() {
		return getOutOfJailFree;
	}
	/**
	 * @param getOutOfJailFree the getOutOfJailFree to set
	 */
	public void setGetOutOfJailFree(boolean getOutOfJailFree) {
		this.getOutOfJailFree = getOutOfJailFree;
	}
	/**
	 * @return the inJail
	 */
	public boolean isInJail() {
		return inJail;
	}
	/**
	 * @param inJail the inJail to set
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	
	
}
