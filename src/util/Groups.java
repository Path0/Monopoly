package util;

import javax.swing.JFrame;

import cards.Railroad;
import cards.TitleCard;
import cards.UtilityCard;

public class Groups {
	public static TitleCard[] BROWN_CARDS = new TitleCard[] {
			Deck.MEDITERRANEAN_AVENUE, 
			Deck.BALTIC_AVENUE
			};
	
	public static TitleCard[] LIGHT_BLUE_CARDS = new TitleCard[] {
			Deck.ORIENTAL_AVENUE,
			Deck.VERMONT_AVENUE,
			Deck.CONNECTICUT_AVENUE
	};
	
	public static TitleCard[] PINK_CARDS = new TitleCard[] {
			Deck.ST_CHARLES_PLACE,
			Deck.STATES_AVENUE,
			Deck.VIRGINIA_AVENUE
	};
	
	public static TitleCard[] ORANGE_CARDS = new TitleCard[] {
			Deck.ST_JAMES_PLACE,
			Deck.TENNESSEE_AVENUE,
			Deck.NEW_YORK_AVENUE
	};
	
	public static TitleCard[] RED_CARDS = new TitleCard[] {
			Deck.KENTUCKY_AVENUE,
			Deck.INDIANA_AVENUE,
			Deck.ILLINOIS_AVENUE
	};
	
	public static TitleCard[] YELLOW_CARDS = new TitleCard[] {
			Deck.ATLANTIC_AVENUE,
			Deck.VENTNOR_AVENUE,
			Deck.MARVIN_GARDENS
	};
	
	public static TitleCard[] GREEN_CARDS = new TitleCard[] {
			Deck.PACIFIC_AVENUE,
			Deck.NORTH_CAROLINA_AVENUE,
			Deck.PENNSYLVANIA_AVENUE
	};
	
	public static TitleCard[] BLUE_CARDS = new TitleCard[] {
			Deck.PARK_PLACE,
			Deck.BOARDWALK
	};
	
	public static TitleCard[] ALL_PROPERTIES = new TitleCard[] {
			Deck.MEDITERRANEAN_AVENUE, 
			Deck.BALTIC_AVENUE,
			Deck.ORIENTAL_AVENUE,
			Deck.VERMONT_AVENUE,
			Deck.CONNECTICUT_AVENUE,
			Deck.ST_CHARLES_PLACE,
			Deck.STATES_AVENUE,
			Deck.VIRGINIA_AVENUE,
			Deck.ST_JAMES_PLACE,
			Deck.TENNESSEE_AVENUE,
			Deck.NEW_YORK_AVENUE,
			Deck.KENTUCKY_AVENUE,
			Deck.INDIANA_AVENUE,
			Deck.ILLINOIS_AVENUE,
			Deck.ATLANTIC_AVENUE,
			Deck.VENTNOR_AVENUE,
			Deck.MARVIN_GARDENS,
			Deck.PACIFIC_AVENUE,
			Deck.NORTH_CAROLINA_AVENUE,
			Deck.PENNSYLVANIA_AVENUE,
			Deck.PARK_PLACE,
			Deck.BOARDWALK
			
	};
	
	
	public static Railroad[] RAILROADS = new Railroad[] {
			Deck.READING_RAILROAD,
			Deck.PENNSYLVANIA_RAILROAD,
			Deck.B_AND_O_RAILROAD,
			Deck.SHORT_LINE
	};
	
	public static UtilityCard[] UTILITIES = new UtilityCard[] {
			Deck.ELECTRIC_COMPANY,
			Deck.WATER_WORKS
	};
	
	
	public static JFrame[] ALL_CARDS = new JFrame[] {
			
			
	};
	
	
	public static TitleCard getCardByName(String name) {
		TitleCard out = null;
		for(TitleCard t : ALL_PROPERTIES) {
			if(t.getName().equals(name)) {
				out = t;
			}
		}
		return out;
	}
}
