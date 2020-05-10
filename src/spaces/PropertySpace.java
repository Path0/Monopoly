package spaces;

import java.awt.Color;
import logi.Player;
import util.Groups;
import util.PopUpCard;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cards.TitleCard;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class PropertySpace extends JPanel {
	public int cost;
	public Color color;
	public String name;
	public TitleCard property;
	public boolean owned;
	public Player owner;
	private JButton Buy;
	/**
	 * Create the panel.
	 */
	public PropertySpace(TitleCard property, int cost) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cost = cost;
		this.color = property.getColor();
		this.name = property.getName();
		this.property = property;
		this.owned = false;
		this.owner = null;
		
		setLayout(null);
		this.setSize(213,300);
		this.setVisible(true);
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		content.setBounds(5, 5, 203, 288);
		add(content);
		content.setLayout(null);
		
		JPanel color_1 = new JPanel();
		color_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		color_1.setBounds(10, 11, 183, 67);
		color_1.setBackground(color);
		content.add(color_1);
		
		JTextField name_1 = new JTextField();
		name_1.setAutoscrolls(false);
		name_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		name_1.setEditable(false);
		name_1.setFocusable(false);
		name_1.setBorder(null);
		name_1.setBackground(SystemColor.menu);
		name_1.setHorizontalAlignment(SwingConstants.CENTER);
		name_1.setBounds(45, 86, 113, 23);
		content.add(name_1);
		name_1.setText(name);
		name_1.setColumns(10);
		
		JTextField cost_1 = new JTextField();
		cost_1.setFocusable(false);
		cost_1.setEditable(false);
		cost_1.setAutoscrolls(false);
		cost_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		cost_1.setBorder(null);
		cost_1.setBackground(SystemColor.menu);
		cost_1.setHorizontalAlignment(SwingConstants.CENTER);
		cost_1.setBounds(53, 257, 96, 20);
		content.add(cost_1);
		cost_1.setText("$" + String.valueOf(cost));
		cost_1.setColumns(10);
		
		Buy = new JButton("Buy Property");
		Buy.setBounds(50, 204, 102, 23);
		Buy.setVisible(false);
		content.add(Buy);

	}
	
	
	
	
	public void land(Player p) {
		
		Buy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p.addCard(property);
				p.subtractMoney(cost);
				owned = true;
				owner = p;
				
				
			}
			
		});
		
		//actual logic begins here
		if(owned) {
			
			int rent = ((TitleCard) owner.getCardByName(name)).getCurrentRent();
			p.payPlayer(owner, rent);
			if(p.getMoney() <= 0) {
				p.ui.popUp(new PopUpCard("Hey, you should think about getting some money. Try mortgaging a property if you are really stuck."));
			}
		} else {
			if(p.getMoney() >= cost) {
				Buy.setVisible(true);
			}
		}
	}
	
	
	
	
	
	
}
