package cards;

import javax.swing.JPanel;
import designs.Train;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;

public class Railroad extends JPanel {
	private String name;
	private int rent;
	
	
	/**
	 * Creates a Railroad card, with the name name.
	 * @param name the Card's name. This is printed on the front of the card.
	 */
	public Railroad(String name) {
		this.name = name;
		this.rent = 250;
		this.setPreferredSize(new Dimension(200,300));
		this.setSize(200,300);
		this.setLocation(0,0);
		this.setVisible(true);
		initComponents(name);
	}
	
	/**
	 * Gets the railroad's current rent.
	 * @return Current rent.
	 */
	public int getRent() {
		return rent;
	}
	
	/**
	 * Sets the railroad's current rent.
	 * @param newRent Rent to set rent to.
	 */
	public void setRent(int newRent) {
		rent = newRent;
	}
	
	
	/**
	 * Initiates the components of the Card for the GUI.
	 * @param n <code>String</code> the Railroad's name.
	 */
	public void initComponents(String n) {
		
		setLayout(null);
		Train train = new Train(60);
		train.setBounds(47, 45, 106, 73);
		this.add(train);
		
		
		/*
		 * Railroad's Name. Large bold font, 2 lines if necessary.
		 */
		String text = "<html><font size = 4><center><strong>" + n + "</strong></center></html>";
		JTextPane cardName = new JTextPane();
		cardName.setEditable(false);
		cardName.setFocusable(false);
		cardName.setContentType("text/html");
		cardName.setBackground(SystemColor.menu);
		cardName.setText(text);
		cardName.setBounds(29, 109, 145, 44);
		add(cardName);
		
		/*
		 * First line of Rents. Used for if only this railroad is owned.
		 */
		JTextField line1 = new JTextField();
		line1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		line1.setAutoscrolls(false);
		line1.setFocusable(false);
		line1.setText(" RENT\t\t$250");
		line1.setBackground(SystemColor.menu);
		line1.setBounds(10, 153, 180, 20);
		add(line1);
		line1.setColumns(10);
		
		/*
		 * Second line of rents. Used for if this railroad and one other railroad is owned.
		 */
		JTextField line2 = new JTextField();
		line2.setFocusable(false);
		line2.setAutoscrolls(false);
		line2.setText("If 2 railroads are owned\t$500");
		line2.setEditable(false);
		line2.setBackground(SystemColor.menu);
		line2.setBounds(10, 184, 180, 20);
		add(line2);
		line2.setColumns(10);
		
		/*
		 * Third line of rents. Used for if this railroad and two other railroads are owned.
		 */
		JTextField line3 = new JTextField();
		line3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		line3.setFocusable(false);
		line3.setAutoscrolls(false);
		line3.setText("If 3 railroads are owned\t$1000");
		line3.setEditable(false);
		line3.setColumns(10);
		line3.setBackground(SystemColor.menu);
		line3.setBounds(10, 213, 180, 20);
		add(line3);
		
		/*
		 * Fourth line of rents. Used for if this railroad and three other railroads are owned.
		 */
		JTextField line4 = new JTextField();
		line4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		line4.setFocusable(false);
		line4.setAutoscrolls(false);
		line4.setText("If 4 railroads are owned\t$2000");
		line4.setEditable(false);
		line4.setColumns(10);
		line4.setBackground(SystemColor.menu);
		line4.setBounds(10, 244, 180, 20);
		add(line4);
		
		/*
		 * This line displays the mortgage value of the railroad. 
		 * If the player becomes bankrupt, he or she can sell this
		 * railroad for the mortgage amount specified.
		 */
		JTextPane mortgage = new JTextPane();
		mortgage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mortgage.setEditable(false);
		mortgage.setFocusable(false);
		mortgage.setContentType("text/html");
		mortgage.setBackground(SystemColor.menu);
		mortgage.setBounds(10, 267, 180, 22);
		mortgage.setText("<html><font face = \"verdana\" size = 3><center>MORTGAGE VALUE $1000</center></font></html>");
		add(mortgage);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setFocusable(false);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Title Deed", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 180, 278);
		add(panel);
	}
	
	
	public String getCardName() {
		return name;
	}
	
	public void setCardName(String name) {
		this.name = name;
	}
	
	
}
