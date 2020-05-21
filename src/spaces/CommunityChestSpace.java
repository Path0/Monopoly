package spaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import cards.CommunityChestCard;
import designs.Chest;
import logi.Player;
import ui.PlayerUI;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;

public class CommunityChestSpace extends Space {
	private JTextField txtCommunityChest;

	/**
	 * Create the panel.
	 */
	public CommunityChestSpace() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		content.setBounds(10, 11, 193, 278);
		add(content);
		this.setVisible(true);
		content.setLayout(null);
		
		Chest c = new Chest(150);
		c.setLocation(21, 116);
		content.add(c);
		
		txtCommunityChest = new JTextField();
		txtCommunityChest.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtCommunityChest.setFocusable(false);
		txtCommunityChest.setBorder(null);
		txtCommunityChest.setAutoscrolls(false);
		txtCommunityChest.setBackground(SystemColor.menu);
		txtCommunityChest.setEditable(false);
		txtCommunityChest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCommunityChest.setText("COMMUNITY CHEST");
		txtCommunityChest.setHorizontalAlignment(SwingConstants.CENTER);
		txtCommunityChest.setBounds(21, 11, 151, 61);
		content.add(txtCommunityChest);
		txtCommunityChest.setColumns(10);
	}
	
	public void land(Player p) {
		int amountOfScenarios = 16;
		int scenario = (int) (Math.random() * amountOfScenarios) + 1;
		System.out.println(scenario);
		CommunityChestCard card = new CommunityChestCard(scenario);
		PlayerUI.popUp(card);
		
		//runs scenario in card
		card.draw(p);
	}
	
	public Space clone() {
		return new CommunityChestSpace();
	}

}
