package cards;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Class to make each "normal" card or property.
 * @author bruh
 *
 */
public class TitleCard extends Card {
	private String name;
	private int houses;
	private int[] rentList;
	private int currentRent;
	private int mortgageVal;
	private int houseCost;
	private Color color;
	private int hotelCost;
	
	/**
	 * Yeah there's a lot of parameters get over it already.
	 * @param name The property's name.
	 * @param rents An int[] array of length 6. The first value is the
	 * property's rent with no houses. The next 4 are the rents with
	 * 1-4 houses respectively. The last value is the rent when the property
	 * contains a hotel.
	 * @param mortgageVal The amount of money the player gets if they forclose
	 * the property if they need money.
	 * @param houseCost The cost to buy one house at this Property.
	 * @param hotelCost The cost to buy a hotel at this Property.
	 * @param color The color group of this Property.
	 */
	public TitleCard(String name, int[] rents, int mortgageVal, int houseCost, int hotelCost, Color color) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.name = name;
		this.rentList = rents;
		this.houses = 0;
		this.mortgageVal = mortgageVal;
		this.houseCost = houseCost;
		this.color = color;
		this.currentRent = rents[0];
		this.hotelCost = hotelCost;
		super.setName(name);
		
		this.setPreferredSize(new Dimension(200, 300));
		this.setSize(200,300);
		this.setLocation(0,0);
		this.setVisible(true);
		setLayout(null);
		
		
		initComponents();
	}
	
	public TitleCard() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(Color.WHITE);
		super.setName("");
		name = "";
		rentList = new int[] {0,0,0,0,0,0};
		houses = 0;
		mortgageVal = 0;
		houseCost = 0;
		color = Color.black;
		currentRent = 0;
		hotelCost = 0;
		this.setSize(200,300);
		this.setVisible(true);
		setLayout(null);
		initComponents();
	}

	/**
	 * Method to add one house to this card. More useful to game logic than GUI.
	 */
	public void addHouse() {
		if(houses < 4) {
			houses++;
			currentRent = rentList[houses];
		} else {
			houses = -1;
			currentRent = rentList[5];
			
		}
	}
	
	/**
	 * Initiates the GUI for this <code>TitleCard</code> based on the instance data given.
	 */
	public void initComponents() {
		
		
		JPanel content =  new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		content.setBounds(10, 11, 180, 278);
		add(content);
		content.setLayout(null);
		
		JPanel titleBar = new JPanel();
		titleBar.setBackground(color);
		titleBar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		titleBar.setBounds(10, 11, 160, 65);
		content.add(titleBar);
		titleBar.setLayout(null);
		
		JTextPane titleName = new JTextPane();
		titleName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		titleName.setFocusable(false);
		titleName.setEditable(false);
		titleName.setAutoscrolls(false);
		titleName.setBackground(color);
		titleName.setBounds(10, 11, 140, 43);
		titleName.setContentType("text/html");
		titleName.setText("<html><font size = 4 face = \"verdana\"><center><strong>" + name + "</strong></center></font></html>");
		
		titleBar.add(titleName);
		
		JTextField rent = new JTextField();
		rent.setEditable(false);
		rent.setFocusable(false);
		rent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rent.setBorder(null);
		rent.setBackground(SystemColor.menu);
		rent.setHorizontalAlignment(SwingConstants.CENTER);
		rent.setText("RENT $" + rentList[0]);
		rent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rent.setBounds(42, 87, 96, 20);
		content.add(rent);
		rent.setColumns(10);
		
		JTextPane houses_1 = new JTextPane();
		houses_1.setEditable(false);
		houses_1.setFocusable(false);
		houses_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		houses_1.setBackground(SystemColor.menu);
		
		houses_1.setText("With 1 House\t               $" + rentList[1]
						+ "\nWith 2 Houses\t               $" + rentList[2]
						+ "\nWith 3 Houses\t               $" + rentList[3]
						+ "\nWith 4 Houses\t               $" + rentList[4]
						+ "\nWith HOTEL\t               $" + rentList[5]);
		houses_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		houses_1.setBounds(10, 118, 160, 81);
		content.add(houses_1);
		
		JTextField MortgageValue = new JTextField();
		MortgageValue.setFocusable(false);
		MortgageValue.setEditable(false);
		MortgageValue.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		MortgageValue.setBorder(null);
		MortgageValue.setText("Mortgage Value $" + mortgageVal);
		MortgageValue.setFont(new Font("Times New Roman", Font.BOLD, 12));
		MortgageValue.setHorizontalAlignment(SwingConstants.CENTER);
		MortgageValue.setBackground(SystemColor.menu);
		MortgageValue.setBounds(30, 205, 118, 20);
		content.add(MortgageValue);
		MortgageValue.setColumns(10);
		
		JTextField HouseCost = new JTextField();
		HouseCost.setFocusable(false);
		HouseCost.setEditable(false);
		HouseCost.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		HouseCost.setBorder(null);
		HouseCost.setHorizontalAlignment(SwingConstants.CENTER);
		HouseCost.setText("Houses cost $" + houseCost);
		HouseCost.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		HouseCost.setBackground(SystemColor.menu);
		HouseCost.setBounds(42, 225, 96, 20);
		content.add(HouseCost);
		HouseCost.setColumns(10);
		
		JTextField HotelCost = new JTextField();
		HotelCost.setFocusable(false);
		HotelCost.setEditable(false);
		HotelCost.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		HotelCost.setBorder(null);
		HotelCost.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		HotelCost.setHorizontalAlignment(SwingConstants.CENTER);
		HotelCost.setText("Hotels cost $" + hotelCost);
		HotelCost.setBackground(SystemColor.menu);
		HotelCost.setBounds(42, 244, 96, 20);
		content.add(HotelCost);
		HotelCost.setColumns(10);
	}
	
	
	
	
	
	
	
	
	
	/*
	 * --------------------------------------------------
	 * GETTERS AND SETTERS -- there's a lot so buckle up
	 * --------------------------------------------------
	 */
	
	
	/**
	 * Gets the <code>TitleCard</code>'s name.
	 * @return the name of the <code>TitleCard</code>
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the <code>TitleCard</code>'s name.
	 * @param n name to set.
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * Gets the amount of houses this <code>TitleCard</code> currently has.
	 * @return the current amount of houses attributed to this <code>TitleCard</code>
	 */
	public int getHouses() {
		return houses;
	}
	
	/**
	 * Sets the amount of houses on this <code>TitleCard</code>
	 * @param h the amount of houses to set.
	 */
	public void setHouses(int h) {
		houses = h;
	}
	
	/**
	 * Gets the Rent List on this <code>TitleCard</code>.
	 * @return the Rent List for this <code>TitleCard</code>
	 */
	public int[] getRentList() {
		return rentList;
	}
	
	/**
	 * Sets the Rent List on this <code>TitleCard</code>.
	 * @param rl the Rent list to set for this <code>TitleCard</code>.
	 */
	public void setRentList(int[] rl) {
		rentList = rl;
	}
	
	/**
	 * Gets the current rent on this <code>TitleCard</code>.
	 * @return the current rent on this <code>TitleCard</code>.
	 */
	public int getCurrentRent() {
		return currentRent;
	}
	
	/**
	 * Sets the current rent on this <code>TitleCard</code>.
	 * @param cr the current rent to set on this <code>TitleCard</code>.
	 */
	public void setCurrentRent(int cr) {
		currentRent = cr;
	}
	
	/**
	 * Gets the mortgage value for this <code>TitleCard</code>
	 * @return the mortgage value for this <code>TitleCard</code>
	 */
	public int getMortgageVal() {
		return mortgageVal;
	}
	
	/**
	 * Sets the mortgage value for this <code>TitleCard</code>
	 * @param mv the mortgage value to set for this <code>TitleCard</code>.
	 */
	public void setMortgageVal(int mv) {
		mortgageVal = mv;
	}
	
	/**
	 * Gets the cost for one house for this <code>TitleCard</code>.
	 * @return the cost for one house.
	 */
	public int getHouseCost() {
		return houseCost;
	}
	
	/**
	 * Sets the cost for one house on this <code>TitleCard</code>.
	 * @param hc the new cost for one house.
	 */
	public void setHouseCost(int hc) {
		houseCost = hc;
	}
	
	/**
	 * Gets the cost for a hotel on this <code>TitleCard</code>
	 * @return the cost for a hotel.
	 */
	public int getHotelCost() {
		return hotelCost;
	}
	
	/**
	 * Sets the hotel cost for this <code>TitleCard</code>.
	 * @param hc the new cost for a hotel.
	 */
	public void setHotelCost(int hc) {
		hotelCost = hc;
	}
	
	/**
	 * Gets the current color group of the <code>TitleCard</code>.
	 * @return the current color group of this <code>TitleCard</code>
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the color group of the <code>TitleCard</code>.
	 * @param c the <code>Color</code> to set the color group of this <code>TitleCard</code> to.
	 */
	public void setColor(Color c) {
		color = c;
	}
	

}
