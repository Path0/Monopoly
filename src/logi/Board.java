package logi;
import javax.swing.JPanel;

import spaces.ChanceSpace;
import spaces.CommunityChestSpace;
import spaces.FreeParking;
import spaces.GOSpace;
import spaces.GoToJailSpace;
import spaces.JailSpace;
import spaces.PropertySpace;
import spaces.RailroadSpace;
import spaces.TaxSpace;
import spaces.UtilitySpace;
import util.Deck;


public class Board {
	private static int amountOfSpaces = 40;
	public static int jailSpace = 11;
	
	
	
	public static JPanel board[] = new JPanel[] {
			new GOSpace(), 
			new PropertySpace(Deck.MEDITERRANEAN_AVENUE,600),
			new CommunityChestSpace(),
			new PropertySpace(Deck.BALTIC_AVENUE, 600),
			new TaxSpace("INCOME TAX", 2000),
			new RailroadSpace(Deck.READING_RAILROAD),
			new PropertySpace(Deck.ORIENTAL_AVENUE, 1000),
			new ChanceSpace(),
			new PropertySpace(Deck.VERMONT_AVENUE, 1000),
			new PropertySpace(Deck.CONNECTICUT_AVENUE, 1200),
			new JailSpace(),
			new PropertySpace(Deck.ST_CHARLES_PLACE, 1400),
			new UtilitySpace("Electric", "Company", Deck.ELECTRIC_COMPANY),
			new PropertySpace(Deck.STATES_AVENUE, 1400),
			new PropertySpace(Deck.VIRGINIA_AVENUE, 1600),
			new RailroadSpace(Deck.PENNSYLVANIA_RAILROAD),
			new PropertySpace(Deck.ST_JAMES_PLACE, 1800),
			new CommunityChestSpace(),
			new PropertySpace(Deck.TENNESSEE_AVENUE, 1800),
			new PropertySpace(Deck.NEW_YORK_AVENUE, 2000),
			new FreeParking(),
			new PropertySpace(Deck.KENTUCKY_AVENUE, 2200),
			new ChanceSpace(),
			new PropertySpace(Deck.INDIANA_AVENUE, 2200),
			new PropertySpace(Deck.ILLINOIS_AVENUE, 2400),
			new RailroadSpace(Deck.B_AND_O_RAILROAD),
			new PropertySpace(Deck.ATLANTIC_AVENUE, 2600),
			new PropertySpace(Deck.VENTNOR_AVENUE, 2600),
			new UtilitySpace("Water", "Works", Deck.WATER_WORKS),
			new PropertySpace(Deck.MARVIN_GARDENS, 2800),
			new GoToJailSpace(),
			new PropertySpace(Deck.PACIFIC_AVENUE, 3000),
			new PropertySpace(Deck.NORTH_CAROLINA_AVENUE, 3000),
			new CommunityChestSpace(),
			new PropertySpace(Deck.PENNSYLVANIA_AVENUE, 3200),
			new RailroadSpace(Deck.SHORT_LINE),
			new ChanceSpace(),
			new PropertySpace(Deck.PARK_PLACE, 3500),
			new TaxSpace("LUXURY TAX", 1000),
			new PropertySpace(Deck.BOARDWALK, 4000)	
	};
	
	
	public Board() {
		
	}
	public static int getAmountOfSpaces() {
		return amountOfSpaces;
	}
	
	public void addToFreeParking(int money) {
		((FreeParking)board[20]).addMoney(money);
	}
	
	
	
}
