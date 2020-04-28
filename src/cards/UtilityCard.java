package cards;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import designs.LightBulb;
import designs.WaterTap;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;

public class UtilityCard extends JPanel {
	private String name;
	private boolean otherOwned;
	private boolean isWaterWorks;
	
	/**
	 * Create the panel.
	 */
	public UtilityCard(boolean isWaterWorks) {
		super.setName(name);
		this.isWaterWorks = isWaterWorks;
		initComponents();
	}
	
	
	public void initComponents() {
		
		this.setPreferredSize(new Dimension(200, 300));
		this.setSize(200,300);
		this.setLocation(0,0);
		this.setVisible(true);
		setLayout(null);
		
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		content.setBounds(10, 11, 180, 278);
		add(content);
		content.setLayout(null);
		
		
		LightBulb bulb = new LightBulb(100);
		bulb.setLocation(65, 11);
		
		WaterTap tap = new WaterTap(80);
		tap.setLocation(25, 28);
		
		
		JTextField Title = new JTextField();
		Title.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Title.setFocusable(false);
		Title.setEditable(false);
		Title.setBorder(null);
		Title.setFont(new Font("Tahoma", Font.BOLD, 11));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBackground(SystemColor.menu);
		Title.setBounds(26, 120, 128, 20);
		content.add(Title);
		Title.setColumns(10);
		Title.setText(name);
		
		JTextPane description = new JTextPane();
		description.setFocusable(false);
		description.setEditable(false);
		description.setAutoscrolls(false);
		description.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		description.setBackground(SystemColor.menu);
		description.setFont(new Font("Tahoma", Font.PLAIN, 11));
		description.setContentType("text/html");
		description.setBounds(18, 151, 144, 91);
		description.setText(
				"<center><font size = 2>If one \"utility\" is owned, rent is 40 times amount shown on dice."
				+ "<p>If both \"utilities\" are owned, rent is 100 times amount shown on dice.</p></font></center>"	
					);
		content.add(description);
		
		
		JTextPane mortgage = new JTextPane();
		mortgage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mortgage.setEditable(false);
		mortgage.setFocusable(false);
		mortgage.setContentType("text/html");
		mortgage.setBackground(SystemColor.menu);
		mortgage.setBounds(5, 253, 170, 22);
		mortgage.setText("<html><font face = \"verdana\" size = 3><center>MORTGAGE VALUE $750</center></font></html>");
		content.add(mortgage);
		
		
		if(isWaterWorks) {
			content.add(tap);
		} else {
			content.add(bulb);
		}
	}
	
	
	public void setOtherOwned(boolean owned) {
		otherOwned = owned;
	}
	
	public int getRent(int diceRoll) {
		if(otherOwned) {
			return diceRoll * 100;
		} else {
			return diceRoll * 40;
		}
	}
}
