package spaces;

import javax.swing.JPanel;

import cards.ChanceCard;
import designs.QuestionMark;
import logi.Player;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Cursor;

public class ChanceSpace extends JPanel {

	/**
	 * Create the panel.
	 */
	public ChanceSpace() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		content.setBounds(10, 11, 193, 278);
		add(content);
		this.setVisible(true);
		content.setLayout(null);
		
		QuestionMark q = new QuestionMark(200);
		q.setLocation(34, 66);
		content.add(q);
		
		JTextField txtChance = new JTextField();
		txtChance.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtChance.setBorder(null);
		txtChance.setFocusable(false);
		txtChance.setEditable(false);
		txtChance.setBackground(SystemColor.menu);
		txtChance.setText("CHANCE");
		txtChance.setHorizontalAlignment(SwingConstants.CENTER);
		txtChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChance.setBounds(29, 11, 135, 44);
		content.add(txtChance);
		txtChance.setColumns(10);
	}
	
	
	public void land(Player p) {
		int amountOfScenarios = 15;
		int scenario = (int) (Math.random() * amountOfScenarios) + 1;
		ChanceCard card = new ChanceCard(scenario);
		p.ui.popUp(card);
		
		//runs scenario in card
		card.draw(p);
	}
}
