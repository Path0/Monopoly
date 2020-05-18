package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Runner.Main;
import cards.ChanceCard;
import cards.CommunityChestCard;
import logi.Board;
import logi.Player;
import util.PopUpCard;

public class PlayerUI extends JPanel {
	private static JTextField playerName;
	private static JTextField playerMoney;
	public static Hand hand;
	private static JPanel popUpPanel;
	private static JPanel p1Position;
	private static JPanel p2Position;
	private static JPanel p3Position;
	private static JPanel p4Position;
	private static JPanel content;

	/**
	 * Create the panel.
	 */
	public PlayerUI() {
		this.setSize(1600,900);
		setLayout(null);
		
		content = new JPanel();
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		content.setBounds(10, 11, 1580, 878);
		add(content);
		content.setLayout(null);
		
		playerName = new JTextField();
		playerName.setFocusable(false);
		playerName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		playerName.setBorder(null);
		playerName.setBackground(SystemColor.menu);
		playerName.setEditable(false);
		playerName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setText("PLAYERNAME");
		playerName.setBounds(10, 11, 166, 47);
		content.add(playerName);
		playerName.setColumns(10);
		
		playerMoney = new JTextField();
		playerMoney.setText("PLAYERMONEY");
		playerMoney.setHorizontalAlignment(SwingConstants.CENTER);
		playerMoney.setFont(new Font("Times New Roman", Font.BOLD, 17));
		playerMoney.setFocusable(false);
		playerMoney.setEditable(false);
		playerMoney.setColumns(10);
		playerMoney.setBorder(null);
		playerMoney.setBackground(SystemColor.menu);
		playerMoney.setBounds(199, 11, 166, 47);
		content.add(playerMoney);

		
		
		JTextField yourCards = new JTextField();
		yourCards.setText("Your Cards");
		yourCards.setHorizontalAlignment(SwingConstants.CENTER);
		yourCards.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		yourCards.setFocusable(false);
		yourCards.setEditable(false);
		yourCards.setColumns(10);
		yourCards.setBorder(null);
		yourCards.setBackground(SystemColor.menu);
		yourCards.setBounds(152, 78, 166, 47);
		content.add(yourCards);
		
		popUpPanel = new JPanel();
		popUpPanel.setBounds(470, 136, 422, 300);
		content.add(popUpPanel);
		popUpPanel.setLayout(null);
		
		p1Position = new JPanel();
		p1Position.setBounds(10, 447, 214, 301);
		content.add(p1Position);
		p1Position.setLayout(null);
		
		p2Position = new JPanel();
		p2Position.setLayout(null);
		p2Position.setBounds(233, 447, 214, 301);
		content.add(p2Position);
		
		p3Position = new JPanel();
		p3Position.setLayout(null);
		p3Position.setBounds(456, 447, 214, 301);
		content.add(p3Position);
		
		p4Position = new JPanel();
		p4Position.setLayout(null);
		p4Position.setBounds(679, 447, 214, 301);
		content.add(p4Position);
		
		
	}
	
	
	public static void popUp(PopUpCard j) {
		popUpPanel.add(j);
		j.setVisible(true);
		j.okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popUpPanel.remove(j);
				popUpPanel.repaint();
			}
		});
	
	}
	
	public static void popUp(ChanceCard j) {
		popUpPanel.add(j);
		j.setVisible(true);
		j.okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popUpPanel.remove(j);
				popUpPanel.repaint();
			}
		});
	}
	
	public static void popUp(CommunityChestCard j) {
		popUpPanel.add(j);
		j.setVisible(true);
		j.okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popUpPanel.remove(j);
				popUpPanel.repaint();
			}
		});
	}
	
	public static void update(Player p) {
		playerName.setText(p.getName());
		playerMoney.setText(String.valueOf(p.getMoney()));
		if(hand != null) {
			content.remove(hand);
		}
		hand = new Hand(p);
		hand.setLocation(10, 136);
		content.add(hand);
		System.out.println(p.getCards());
		hand.refresh();
		/*
		 * resets each player's position.
		 */
		Player[] players = Main.game.getPlayers();
		if(players.length == 2) {
			int position = players[0].getPosition();
			p1Position.add(Board.board[position - 1]);
			p1Position.repaint();
			
			int position2 = players[1].getPosition();
			p2Position.add(Board.board[position2 - 1]);
			p2Position.repaint();
		}
		if(players.length == 3) {
			int position = players[0].getPosition();
			p1Position.add(Board.board[position - 1]);
			p1Position.repaint();
			
			int position2 = players[1].getPosition();
			p2Position.add(Board.board[position2 - 1]);
			p2Position.repaint();
			
			int position3 = players[2].getPosition();
			p3Position.add(Board.board[position3 - 1]);
			p3Position.repaint();
		}
		if(players.length == 4) {
			int position = players[0].getPosition();
			p1Position.add(Board.board[position - 1]);
			p1Position.repaint();
			
			int position2 = players[1].getPosition();
			p2Position.add(Board.board[position2 - 1]);
			p2Position.repaint();
			
			int position3 = players[2].getPosition();
			p3Position.add(Board.board[position3 - 1]);
			p3Position.repaint();
			
			int position4 = players[3].getPosition();
			p4Position.add(Board.board[position4 - 1]);
			p4Position.repaint();
		}
	}
}