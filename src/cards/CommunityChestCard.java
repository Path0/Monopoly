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
import javax.swing.JButton;

public class CommunityChestCard extends JPanel {
	private JTextField txtCommunityChest;
	private String message;
	private int scen;
	public JButton okButton;
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
		
		okButton = new JButton("OK");
		okButton.setBounds(170, 144, 89, 23);
		content.add(okButton);
	}
	
	public void draw(Player p) {
		switch(scen) {
		
		case 1:
			CommunityChestCardScenarios.s1(p);
			break;
		case 2:
			CommunityChestCardScenarios.s2(p);
			break;
		case 3:
			CommunityChestCardScenarios.s3(p);
			break;
		case 4:
			CommunityChestCardScenarios.s4(p);
			break;
		case 5:
			CommunityChestCardScenarios.s5(p);
			break;
		case 6:
			CommunityChestCardScenarios.s6(p);
			break;
		case 7:
			CommunityChestCardScenarios.s7(p);
			break;
		case 8:
			CommunityChestCardScenarios.s8(p);
			break;
		case 9:
			CommunityChestCardScenarios.s9(p);
			break;
		case 10:
			CommunityChestCardScenarios.s10(p);
			break;
		case 11:
			CommunityChestCardScenarios.s11(p);
			break;
		case 12:
			CommunityChestCardScenarios.s12(p);
			break;
		case 13:
			CommunityChestCardScenarios.s13(p);
			break;
		case 14:
			CommunityChestCardScenarios.s14(p);
			break;
		case 15:
			CommunityChestCardScenarios.s15(p);
			break;
		case 16:
			CommunityChestCardScenarios.s16(p);
			break;
		default:
			break;
		
		}
		
	
	}
}
