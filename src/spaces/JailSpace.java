package spaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import logi.Player;
import ui.PlayerUI;
import util.PopUpCard;

public class JailSpace extends Space {
	private JTextField txtIn;
	private JTextField txtJail;
	private JTextField txtJustVisiting;
	private JTextField txtVisiting;

	/**
	 * Create the panel.
	 */
	public JailSpace() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 193, 278);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 193, 142);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtIn = new JTextField();
		txtIn.setRequestFocusEnabled(false);
		txtIn.setFocusable(false);
		txtIn.setEditable(false);
		txtIn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtIn.setBorder(null);
		txtIn.setAutoscrolls(false);
		txtIn.setBackground(new Color(255, 140, 0));
		txtIn.setFont(new Font("Javanese Text", Font.PLAIN, 44));
		txtIn.setText("IN");
		txtIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtIn.setBounds(48, 11, 96, 65);
		panel_1.add(txtIn);
		txtIn.setColumns(10);
		
		txtJail = new JTextField();
		txtJail.setRequestFocusEnabled(false);
		txtJail.setAutoscrolls(false);
		txtJail.setBorder(null);
		txtJail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtJail.setFocusable(false);
		txtJail.setEditable(false);
		txtJail.setText("JAIL");
		txtJail.setHorizontalAlignment(SwingConstants.CENTER);
		txtJail.setFont(new Font("Javanese Text", Font.PLAIN, 44));
		txtJail.setColumns(10);
		txtJail.setBackground(new Color(255, 140, 0));
		txtJail.setBounds(48, 77, 96, 64);
		panel_1.add(txtJail);
		
		txtJustVisiting = new JTextField();
		txtJustVisiting.setText("JUST");
		txtJustVisiting.setRequestFocusEnabled(false);
		txtJustVisiting.setHorizontalAlignment(SwingConstants.CENTER);
		txtJustVisiting.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		txtJustVisiting.setFocusable(false);
		txtJustVisiting.setEditable(false);
		txtJustVisiting.setColumns(10);
		txtJustVisiting.setBorder(null);
		txtJustVisiting.setBackground(SystemColor.menu);
		txtJustVisiting.setAutoscrolls(false);
		txtJustVisiting.setBounds(10, 153, 173, 59);
		panel.add(txtJustVisiting);
		
		txtVisiting = new JTextField();
		txtVisiting.setText("VISITING");
		txtVisiting.setRequestFocusEnabled(false);
		txtVisiting.setHorizontalAlignment(SwingConstants.CENTER);
		txtVisiting.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		txtVisiting.setFocusable(false);
		txtVisiting.setEditable(false);
		txtVisiting.setColumns(10);
		txtVisiting.setBorder(null);
		txtVisiting.setBackground(SystemColor.menu);
		txtVisiting.setAutoscrolls(false);
		txtVisiting.setBounds(10, 208, 173, 59);
		panel.add(txtVisiting);
	}
	
	public void land(Player p) {
		PlayerUI.popUp(new PopUpCard(
				"Phew. Glad you're not in there!"
				));
	}
}
