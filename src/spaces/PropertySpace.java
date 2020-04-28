package spaces;

import java.awt.Color;
import logi.Player;
import util.Groups;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cards.TitleCard;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	public PropertySpace(Color color, String name, int cost, TitleCard property) {
		this.cost = cost;
		this.color = color;
		this.name = name;
		this.property = Groups.getCardByName(name);
		this.owned = false;
		this.owner = null;
		
		setLayout(null);
		
		JPanel content = new JPanel();
		content.setBounds(10, 5, 203, 288);
		add(content);
		content.setLayout(null);
		
		JPanel color_1 = new JPanel();
		color_1.setBounds(10, 11, 183, 67);
		color_1.setBackground(color);
		content.add(color_1);
		
		JTextField name_1 = new JTextField();
		name_1.setBorder(null);
		name_1.setBackground(SystemColor.menu);
		name_1.setHorizontalAlignment(SwingConstants.CENTER);
		name_1.setBounds(50, 89, 96, 20);
		content.add(name_1);
		name_1.setText(name);
		name_1.setColumns(10);
		
		JTextField cost_1 = new JTextField();
		cost_1.setBorder(null);
		cost_1.setBackground(SystemColor.menu);
		cost_1.setHorizontalAlignment(SwingConstants.CENTER);
		cost_1.setBounds(50, 257, 96, 20);
		content.add(cost_1);
		cost_1.setText("$" + String.valueOf(cost));
		cost_1.setColumns(10);
		
		Buy = new JButton("Buy Property");
		Buy.setBounds(44, 204, 102, 23);
		Buy.setVisible(false);
		content.add(Buy);

	}
	
	
	
	
	public void land(Player p) {
		
		Buy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p.getCards().add(property);
				p.subtractMoney(cost);
				owned = true;
				
				
			}
			
		});
		
		//actual logic begins here
		if(owned) {
			
			int rent = ((TitleCard) owner.getCardByName(name)).getCurrentRent();
			p.payPlayer(owner, rent);
			if(p.getMoney() <= 0) {
				//TODO let them know they out of money
			}
		} else {
			if(p.getMoney() >= cost) {
				Buy.setVisible(true);
			}
		}
	}
	
	
	
	
	
	
}
