package logi;

import java.util.ArrayList;
import javax.swing.JPanel;
public class Player {
	private String name;
	private int position;
	private int money;
	private ArrayList<JPanel> cards;
	private boolean getOutOfJailFree;
	private boolean inJail;
	public int railroadsOwned;
	public int utilitiesOwned;
	
	public Player(String name) {
		this.name = name;
		position = 0;
		money = 15000;
		cards = new ArrayList<JPanel>();
		getOutOfJailFree = false;
		inJail = false;
		railroadsOwned = 0;
	}
	
	
	public void addCard(JPanel t) {
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
	public ArrayList<JPanel> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<JPanel> cards) {
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
