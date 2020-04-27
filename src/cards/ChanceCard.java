package cards;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import designs.QuestionMark;
import logi.Player;
import util.ChanceCardScenarios;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.JTextPane;

public class ChanceCard extends JPanel {
	
	public int scenario;
	public String message;
	/**
	 * Create the panel.
	 */
	public ChanceCard(String message, int scenario) {
		this.setSize(300,200);
		message = ChanceCardScenarios.htmlFormat(message);
		initComponents();
		
	}
	
	public void initComponents() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 280, 178);
		add(panel);
		panel.setLayout(null);
		
		JTextField txtChance = new JTextField();
		txtChance.setFocusable(false);
		txtChance.setEditable(false);
		txtChance.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtChance.setBorder(null);
		txtChance.setAutoscrolls(false);
		txtChance.setBackground(SystemColor.menu);
		txtChance.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtChance.setHorizontalAlignment(SwingConstants.CENTER);
		txtChance.setText("C H A N C E ");
		txtChance.setBounds(92, 11, 96, 20);
		panel.add(txtChance);
		txtChance.setColumns(10);
		
		QuestionMark q = new QuestionMark(100);
		q.setLocation(175, 38);
		panel.add(q);
		
		JTextPane textPane = new JTextPane();
		textPane.setAutoscrolls(false);
		textPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setContentType("text/html");
		textPane.setBounds(10, 38, 155, 129);
		textPane.setText(message);
		panel.add(textPane);
		
	}
	
	public void draw(Player p) {
		switch(scenario) {
		
		case 1:
			ChanceCardScenarios.s1(p);
		case 2: 
			ChanceCardScenarios.s2(p);
		case 3:
			ChanceCardScenarios.s3(p);
		case 4:
			ChanceCardScenarios.s4(p);
		case 5:
			ChanceCardScenarios.s5(p);
		case 6:
			ChanceCardScenarios.s6(p);
		case 7:
			ChanceCardScenarios.s7(p);
		case 8:
			ChanceCardScenarios.s8(p);
		case 9:
			ChanceCardScenarios.s9(p);
		case 10:
			ChanceCardScenarios.s10(p);
		case 11:
			ChanceCardScenarios.s11(p);
		case 12:
			ChanceCardScenarios.s12(p);
		case 13:
			ChanceCardScenarios.s13(p);
		case 14:
			ChanceCardScenarios.s14(p);
		case 15:
			ChanceCardScenarios.s15(p);
		default:
			break;
			
		}
	}
}
