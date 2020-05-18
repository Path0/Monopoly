package spaces;

import javax.swing.JPanel;

import logi.Player;
import javax.swing.border.LineBorder;

import designs.Arrow;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.JTextPane;

public class GOSpace extends Space {
	private JTextField txtGo;

	/**
	 * Create the panel.
	 */
	public GOSpace() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 193, 278);
		add(panel);
		panel.setLayout(null);
		Arrow a = new Arrow(50);
		a.setLocation(4, 204);
		panel.add(a);
		
		txtGo = new JTextField();
		txtGo.setRequestFocusEnabled(false);
		txtGo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtGo.setBorder(null);
		txtGo.setFocusable(false);
		txtGo.setEditable(false);
		txtGo.setBackground(SystemColor.menu);
		txtGo.setFont(new Font("Dutch801 XBd BT", Font.BOLD, 99));
		txtGo.setText("GO");
		txtGo.setHorizontalAlignment(SwingConstants.CENTER);
		txtGo.setBounds(7, 79, 179, 122);
		panel.add(txtGo);
		txtGo.setColumns(10);
		
		JTextPane txtpnCollect = new JTextPane();
		txtpnCollect.setFocusable(false);
		txtpnCollect.setBorder(null);
		txtpnCollect.setBackground(SystemColor.menu);
		txtpnCollect.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnCollect.setAutoscrolls(false);
		txtpnCollect.setEditable(false);
		txtpnCollect.setContentType("text/html");
		txtpnCollect.setText("<center>COLLECT $2,000 SALARY AS YOU PASS</center>");
		txtpnCollect.setBounds(14, 24, 164, 44);
		panel.add(txtpnCollect);
		
	}
	
	public void land(Player p) {
		p.passGo();
	}
}
