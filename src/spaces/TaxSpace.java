package spaces;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Runner.Main;
import logi.Player;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TaxSpace extends JPanel {
	private JTextField txtIncome;
	private JTextField txtTax;
	private JTextField txtPay;
	private int amount;
	/**
	 * Create the panel.
	 */
	public TaxSpace(String name, int amtToPay) {
		String title = name;
		amount = amtToPay;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setSize(213,300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 193, 278);
		add(panel);
		panel.setLayout(null);
		
		txtIncome = new JTextField();
		txtIncome.setText(title);
		txtIncome.setRequestFocusEnabled(false);
		txtIncome.setHorizontalAlignment(SwingConstants.CENTER);
		txtIncome.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		txtIncome.setFocusable(false);
		txtIncome.setEditable(false);
		txtIncome.setColumns(10);
		txtIncome.setBorder(null);
		txtIncome.setBackground(SystemColor.menu);
		txtIncome.setAutoscrolls(false);
		txtIncome.setBounds(10, 11, 173, 59);
		panel.add(txtIncome);
		
		txtTax = new JTextField();
		txtTax.setText("TAX");
		txtTax.setRequestFocusEnabled(false);
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		txtTax.setFocusable(false);
		txtTax.setEditable(false);
		txtTax.setColumns(10);
		txtTax.setBorder(null);
		txtTax.setBackground(SystemColor.menu);
		txtTax.setAutoscrolls(false);
		txtTax.setBounds(10, 67, 173, 59);
		panel.add(txtTax);
		
		txtPay = new JTextField();
		txtPay.setText("PAY $" + amtToPay);
		txtPay.setRequestFocusEnabled(false);
		txtPay.setHorizontalAlignment(SwingConstants.CENTER);
		txtPay.setFont(new Font("Javanese Text", Font.PLAIN, 30));
		txtPay.setFocusable(false);
		txtPay.setEditable(false);
		txtPay.setColumns(10);
		txtPay.setBorder(null);
		txtPay.setBackground(SystemColor.menu);
		txtPay.setAutoscrolls(false);
		txtPay.setBounds(10, 208, 173, 59);
		panel.add(txtPay);
	}
	
	public void land(Player p) {
		p.subtractMoney(amount);
		Main.game.board.addToFreeParking(amount);
	}

}
