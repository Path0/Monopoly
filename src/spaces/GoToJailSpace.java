package spaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import logi.Board;
import logi.Player;
import ui.PlayerUI;
import util.PopUpCard;

public class GoToJailSpace extends Space {
	private JTextField txtGoTo;
	private JTextField txtJail;
	/**
	 * Create the panel.
	 */
	public GoToJailSpace() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 193, 278);
		add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(GoToJailSpace.class.getResource("/rec/badge.png")));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setIconTextGap(0);
		lblNewLabel.setBounds(36, 55, 121, 157);
		panel.add(lblNewLabel);
		
		txtGoTo = new JTextField();
		txtGoTo.setBorder(null);
		txtGoTo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtGoTo.setFocusable(false);
		txtGoTo.setEditable(false);
		txtGoTo.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		txtGoTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtGoTo.setText("GO TO");
		txtGoTo.setBounds(38, 2, 117, 51);
		panel.add(txtGoTo);
		txtGoTo.setColumns(10);
		
		txtJail = new JTextField();
		txtJail.setBounds(38, 223, 117, 54);
		panel.add(txtJail);
		txtJail.setText("JAIL");
		txtJail.setHorizontalAlignment(SwingConstants.CENTER);
		txtJail.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		txtJail.setFocusable(false);
		txtJail.setEditable(false);
		txtJail.setColumns(10);
		txtJail.setBorder(null);
		
	
	}
	
	public void land(Player p) {
		p.setInJail(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PlayerUI.update(p);
		p.setPosition(Board.jailSpace);
		PlayerUI.popUp(new PopUpCard(
				"You're in jail! Wait 3 turns or roll doubles to get out, unless you have a \"GET OUT OF JAIL FREE\" card, which will be used on your next turn."
				));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PlayerUI.update(p);
	}
	
	public Space clone() {
		return new GoToJailSpace();
	}
}
