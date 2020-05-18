package spaces;

import javax.swing.JPanel;

import logi.Player;
import ui.PlayerUI;
import util.PopUpCard;

import javax.swing.border.LineBorder;

import designs.Car;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;

public class FreeParking extends Space {
	public int currentValue;
	private JTextField txtFree;
	private JTextField txtParking;
	/**
	 * Create the panel.
	 */
	public FreeParking() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		currentValue = 0;
		this.setSize(213,300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 193, 278);
		add(panel);
		panel.setLayout(null);
		
		
		Car c = new Car(150);
		c.setLocation(30, 63);
		panel.add(c);
		
		txtFree = new JTextField();
		txtFree.setBorder(null);
		txtFree.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtFree.setFocusable(false);
		txtFree.setEditable(false);
		txtFree.setBackground(SystemColor.menu);
		txtFree.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		txtFree.setText("FREE");
		txtFree.setHorizontalAlignment(SwingConstants.CENTER);
		txtFree.setBounds(30, 11, 132, 41);
		panel.add(txtFree);
		txtFree.setColumns(10);
		
		txtParking = new JTextField();
		txtParking.setText("PARKING");
		txtParking.setHorizontalAlignment(SwingConstants.CENTER);
		txtParking.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		txtParking.setFocusable(false);
		txtParking.setEditable(false);
		txtParking.setColumns(10);
		txtParking.setBorder(null);
		txtParking.setBackground(SystemColor.menu);
		txtParking.setBounds(30, 225, 132, 41);
		panel.add(txtParking);
		
	}
	
	
	
	public void addMoney(int money) {
		currentValue+= money;
	}
	
	public void land(Player p) {
		PlayerUI.popUp(new PopUpCard("You got $" + currentValue + " from Free Parking!"));
		p.addMoney(currentValue);
		currentValue = 0;
	}
}
