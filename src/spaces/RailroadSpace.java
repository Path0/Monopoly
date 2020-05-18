package spaces;

import javax.swing.JPanel;

import cards.Railroad;

import javax.swing.border.LineBorder;
import java.awt.Color;
import designs.Train;
import logi.Player;
import ui.PlayerUI;
import util.PopUpCard;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RailroadSpace extends Space {
	private String name;
	private JButton btnNewButton;
	private Railroad rr;
	private boolean owned;
	private Player owner;
	/**
	 * Create the panel.
	 */
	public RailroadSpace(Railroad r) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.name = r.getCardName();
		rr = r;
		owned = false;
		initComponents();
		owner = null;
	}
	
	public void initComponents() {
		this.setLayout(null);
		this.setSize(213,300);
		
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		content.setBounds(10, 11, 193, 278);
		add(content);
		content.setLayout(null);
		
		Train train = new Train(100);
		train.setBounds(10, 78, 172, 122);
		content.add(train);
		
		JTextField textField = new JTextField();
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setEditable(false);
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField.setAutoscrolls(false);
		textField.setBackground(new Color(240, 240, 240));
		textField.setText("$2000");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(48, 247, 96, 20);
		content.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setFocusable(false);
		textField_1.setEditable(false);
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_1.setBackground(SystemColor.menu);
		textField_1.setAutoscrolls(false);
		textField_1.setBorder(null);
		textField_1.setBounds(34, 11, 124, 42);
		textField_1.setText(name);
		content.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Buy Railroad");
		btnNewButton.setBounds(41, 211, 110, 23);
		btnNewButton.setVisible(false);
		content.add(btnNewButton);
	}
	
	
	public void land(Player p) {

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.subtractMoney(2000);
				p.addCard(rr);
				owned = true;
				owner = p;
				p.railroadsOwned++;
			}
		});
		
		
		
		if(owned) {
			p.payPlayer(owner, owner.getRailroadRent());
			if(p.getMoney() <= 0) {
				PlayerUI.popUp(new PopUpCard(
						"Well, looks like " + owner.getName() + " owns this property. You owe them $" + owner.getRailroadRent() + ". " + 
						"Hey, you should think about getting some money. Try mortgaging a property if you are really stuck."
						));
			} else {
				PlayerUI.popUp(new PopUpCard(
						"Well, looks like " + owner.getName() + " owns this property. You owe them $" + owner.getRailroadRent() + ". "
						));
			}
		} else if(p.getMoney() >= 2000) {
			btnNewButton.setVisible(true);
		}
	}
	
}
