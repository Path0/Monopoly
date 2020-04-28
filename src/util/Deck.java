package util;

import java.awt.Color;

import cards.Railroad;
import cards.TitleCard;
import cards.UtilityCard;

public class Deck {
	final static Color BROWN = new Color(0,54,11);
	final static Color LIGHT_BLUE = new Color(0,215,252);
	final static Color PINK = new Color(255,84,130);
	final static Color ORANGE = new Color(255,123,0);
	final static Color RED = new Color(179,25,25);
	final static Color YELLOW = new Color(238,255,0);
	final static Color GREEN = new Color(19,176,38);
	final static Color BLUE = new Color(46,49,148);
	/*
	 * ----BROWN CARDS----
	 */
	public static TitleCard MEDITERRANEAN_AVENUE = new TitleCard(
			"MEDITERRANEAN AVENUE", //name
			new int[] {20,100,300,900,1600,2500}, //rents
			300, //mortgage
			500, //house
			500, //hotel
			BROWN //color
			);
	
	public static TitleCard BALTIC_AVENUE = new TitleCard(
			"BALTIC AVENUE",
			new int[] {40,200,600,1800,3200,4500},
			300,
			500,
			500,
			BROWN
			);
	
	/*
	 * ----LIGHT BLUE CARDS----
	 */
	public static TitleCard ORIENTAL_AVENUE = new TitleCard(
			"ORIENTAL AVENUE",
			new int[] {60,300,900,2700,4000,5500},
			500,
			500,
			500,
			LIGHT_BLUE
			);
	
	public static TitleCard VERMONT_AVENUE = new TitleCard(
			"VERMONT AVENUE",
			new int[] {60,300,900,2700,4000,5000},
			500,
			500,
			500,
			LIGHT_BLUE
			);
	
	public static TitleCard CONNECTICUT_AVENUE = new TitleCard(
			"CONNECTICUT AVENUE",
			new int[] {80,400,1000,3000,4500,6000},
			600,
			500,
			500,
			LIGHT_BLUE
			);
	
	/*
	 * ----PINK CARDS----
	 */

	public static TitleCard ST_CHARLES_PLACE = new TitleCard(
			"ST. CHARLES PLACE",
			new int[] {100,500,1500,4500,6250,7500},
			700,
			1000,
			1000,
			PINK
			);
	
	public static TitleCard STATES_AVENUE = new TitleCard(
			"STATES AVENUE",
			new int[] {100,500,1500,4500,6250,7500},
			700,
			1000,
			1000,
			PINK
			);
	
	public static TitleCard VIRGINIA_AVENUE = new TitleCard(
			"VIRGINIA AVENUE",
			new int[] {120,600,1800,5000,7000,9000},
			800,
			1000,
			1000,
			PINK
			);
	
	/*
	 * ----ORANGE CARDS----
	 */
	
	public static TitleCard ST_JAMES_PLACE = new TitleCard(
			"ST. JAMES PLACE",
			new int[] {140,700,2000,5500,7500,9500},
			900,
			1000,
			1000,
			ORANGE
			);
	
	public static TitleCard TENNESSEE_AVENUE = new TitleCard(
			"TENNESSEE AVENUE",
			new int[] {140,700,2000,5500,7500,9500},
			900,
			1000,
			1000,
			ORANGE
			);
	
	public static TitleCard NEW_YORK_AVENUE = new TitleCard(
			"NEW YORK AVENUE",
			new int[] {160,800,2200,6000,8000,10000},
			1000,
			1000,
			1000,
			ORANGE
			);
	
	/*
	 * ----RED CARDS----
	 */
		
	public static TitleCard KENTUCKY_AVENUE = new TitleCard(
			"KENTUCKY AVENUE",
			new int[] {180,900,2500,7000,8750,10500},
			1100,
			1500,
			1500,
			RED
			);
	
	public static TitleCard INDIANA_AVENUE = new TitleCard(
			"INDIANA AVENUE",
			new int[] {180,900,2500,7000,8750,10500},
			1100,
			1500,
			1500,
			RED
			);
			
	public static TitleCard ILLINOIS_AVENUE = new TitleCard(
			"ILLINOIS AVENUE",
			new int[] {200,1000,3000,7500,9250,11000},
			1200,
			1500,
			1500,
			RED
			);
	
	/*
	 * ----YELLOW CARDS----
	 */
			
	public static TitleCard ATLANTIC_AVENUE = new TitleCard(
			"ATLANTIC AVENUE",
			new int[] {220,1100,3300,8000,9750,11500},
			1300,
			1500,
			1500,
			YELLOW
			);
	
	public static TitleCard VENTNOR_AVENUE = new TitleCard(
			"VENTNOR AVENUE",
			new int[] {220,1100,3300,8000,9750,11500},
			1300,
			1500,
			1500,
			YELLOW
			);
	
	public static TitleCard MARVIN_GARDENS = new TitleCard(
			"MARVIN GARDENS",
			new int[] {240,1200,3600,8500,10250,12000},
			1400,
			1500,
			1500,
			YELLOW
			);
	
	/*
	 * ----GREEN CARDS----
	 */
	
	public static TitleCard PACIFIC_AVENUE = new TitleCard(
			"PACIFIC AVENUE",
			new int[] {260,1300,3900,9000,11000,12750},
			1500,
			2000,
			2000,
			GREEN
			);
	
	public static TitleCard NORTH_CAROLINA_AVENUE = new TitleCard(
			"NORTH CAROLINA AVENUE",
			new int[] {260,1300,3900,9000,11000,12750},
			1500,
			2000,
			2000,
			GREEN
			);
	
	public static TitleCard PENNSYLVANIA_AVENUE = new TitleCard(
			"PENNSYLVANIA AVENUE",
			new int[] {280,1500,4500,10000,12000,14000},
			1600,
			2000,
			2000,
			GREEN
			);
	
	/*
	 * ----BLUE CARDS----
	 */
	
	public static TitleCard PARK_PLACE = new TitleCard(
			"PARK PLACE",
			new int[] {350,1750,5000,11000,13000,15000},
			1750,
			2000,
			2000,
			BLUE
			);
	
	public static TitleCard BOARDWALK = new TitleCard(
			"BOARDWALK",
			new int[] {500,2000,6000,14000,17000,20000},
			2000,
			2000,
			2000,
			BLUE
			);
			
	
	/*
	 * ----RAILROADS----
	 */
	public static Railroad PENNSYLVANIA_RAILROAD = new Railroad("PENNSYLVANIA RAILROAD");
	public static Railroad READING_RAILROAD = new Railroad("READING RAILROAD");
	public static Railroad B_AND_O_RAILROAD = new Railroad("B. & O. RAILROAD");
	public static Railroad SHORT_LINE = new Railroad("SHORT LINE");
	
	/*
	 * ----UTILITIES----
	 */
	
	public static UtilityCard WATER_WORKS = new UtilityCard(true);
	public static UtilityCard ELECTRIC_COMPANY = new UtilityCard(false);
	
	
	
	
	
	
}
