package cards;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import designs.Chest;
import logi.Player;
import util.ChanceCardScenarios;
import util.CommunityChestCardScenarios;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.SystemColor;

public class CommunityChestCard extends JPanel {
	private JTextField txtCommunityChest;
	private String message;
	private int scen;
	/**
	 * Create the panel.
	 */
	public CommunityChestCard(int scenario) {
		message = ChanceCardScenarios.htmlFormat(CommunityChestCardScenarios.messages[scenario-1]);
		this.scen = scenario;
		initComponents();
	}
	
	public void initComponents() {
		this.setSize(300,200);
		setLayout(null);
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		content.setBounds(10, 11, 280, 178);
		add(content);
		content.setLayout(null);
		
		txtCommunityChest = new JTextField();
		txtCommunityChest.setBorder(null);
		txtCommunityChest.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtCommunityChest.setFocusable(false);
		txtCommunityChest.setEditable(false);
		txtCommunityChest.setHorizontalAlignment(SwingConstants.CENTER);
		txtCommunityChest.setText("COMMUNITY CHEST");
		txtCommunityChest.setBounds(82, 11, 116, 20);
		content.add(txtCommunityChest);
		txtCommunityChest.setColumns(10);
		
		Chest chest = new Chest(80);
		chest.setLocation(170, 48);
		content.add(chest);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setAutoscrolls(false);
		textPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setContentType("text/html");
		textPane.setBounds(10, 38, 155, 129);
		textPane.setText(message);
		content.add(textPane);
	}
	
	public void draw(Player p) {
		switch(scen) {
		
		case 1:
			CommunityChestCardScenarios.s1(p);
		case 2:
			CommunityChestCardScenarios.s2(p);
		case 3:
			CommunityChestCardScenarios.s3(p);
		case 4:
			CommunityChestCardScenarios.s4(p);
		case 5:
			CommunityChestCardScenarios.s5(p);
		case 6:
			CommunityChestCardScenarios.s6(p);
		case 7:
			CommunityChestCardScenarios.s7(p);
		case 8:
			CommunityChestCardScenarios.s8(p);
		case 9:
			CommunityChestCardScenarios.s9(p);
		case 10:
			CommunityChestCardScenarios.s10(p);
		case 11:
			CommunityChestCardScenarios.s11(p);
		case 12:
			CommunityChestCardScenarios.s12(p);
		case 13:
			CommunityChestCardScenarios.s13(p);
		case 14:
			CommunityChestCardScenarios.s14(p);
		case 15:
			CommunityChestCardScenarios.s15(p);
		case 16:
			CommunityChestCardScenarios.s16(p);
		default:
			break;
		
		}
		
	
	}
}
