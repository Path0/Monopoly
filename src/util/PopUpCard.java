package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class PopUpCard extends JPanel {
	public JButton okButton;

	/**
	 * Create the panel.
	 */
	public PopUpCard(String prompt) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		setSize(421,299);
		
		JPanel content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		content.setBounds(10, 11, 401, 278);
		add(content);
		content.setLayout(null);
		
		okButton = new JButton("OK");
		okButton.setBounds(156, 228, 89, 23);
		content.add(okButton);
		
		JTextPane promptBox = new JTextPane();
		promptBox.setEditable(false);
		promptBox.setFocusable(false);
		promptBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		promptBox.setBackground(SystemColor.menu);
		promptBox.setContentType("text/html");
		promptBox.setText("<center>" + prompt + "</center>");
		promptBox.setBounds(90, 35, 220, 113);
		content.add(promptBox);

	}
}
