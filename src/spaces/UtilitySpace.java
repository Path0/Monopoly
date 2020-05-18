package spaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import cards.UtilityCard;
import designs.LightBulb;
import designs.WaterTap;
import logi.Player;
import ui.PlayerUI;
import util.PopUpCard;

public class UtilitySpace extends Space {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private boolean owned;
	private UtilityCard utility;
	private Player owner;

	/**
	 * Create the panel.
	 */
	public UtilitySpace(String name1, String name2, UtilityCard u) {
		utility = u;
		owner = null;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 193, 278);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setText(name1);
		textField.setRequestFocusEnabled(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Javanese Text", Font.PLAIN, 27));
		textField.setFocusable(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(SystemColor.menu);
		textField.setAutoscrolls(false);
		textField.setBounds(10, 11, 173, 44);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText(name2);
		textField_1.setRequestFocusEnabled(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Javanese Text", Font.PLAIN, 27));
		textField_1.setFocusable(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setAutoscrolls(false);
		textField_1.setBounds(10, 50, 173, 44);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setRequestFocusEnabled(false);
		textField_2.setFocusable(false);
		textField_2.setEditable(false);
		textField_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_2.setBorder(null);
		textField_2.setAutoscrolls(false);
		textField_2.setBackground(SystemColor.menu);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("$1500");
		textField_2.setBounds(48, 207, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Buy Utility");
		
		btnNewButton.setBounds(52, 238, 89, 23);
		btnNewButton.setVisible(false);
		panel.add(btnNewButton);
		
		if(name1.equals("WATER")) {
			WaterTap t = new WaterTap(100);
			t.setLocation(16, 92);
			panel.add(t);
		} else {
			LightBulb b = new LightBulb(100);
			b.setLocation(71, 95);
			panel.add(b);
		}
		
		
		
	}
	
	
	public void land(Player p) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.subtractMoney(1500);
				p.addCard(utility);
				owned = true;
				owner = p;
				p.utilitiesOwned++;
			}
		});
		
		
		
		if(owned) {
			
			int rent = owner.getUtilityRent();
			p.payPlayer(owner, rent);
			if(p.getMoney() <= 0) {
				PlayerUI.popUp(new PopUpCard(
						"Well, looks like " + owner.getName() + " owns this property. You owe them $" + rent + ". " + 
						"Hey, you should think about getting some money. Try mortgaging a property if you are really stuck."
						));
			} else {
				PlayerUI.popUp(new PopUpCard(
						"Well, looks like " + owner.getName() + " owns this property. You owe them $" + rent + ". "
						));
			}
		} else {
			if(p.getMoney() >= 1500) {
				btnNewButton.setVisible(true);
			}
		}
	}
}
