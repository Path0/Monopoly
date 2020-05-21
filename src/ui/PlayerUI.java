package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Runner.Main;
import cards.ChanceCard;
import cards.CommunityChestCard;
import logi.Board;
import logi.Game;
import logi.Player;
import spaces.Space;
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
	private static JButton rollDice;
	private static JButton nextPlayerButton;
	private static Player[] players;

	/**
	 * Create the panel.
	 */
	public PlayerUI() {
		this.setSize(1600,900);
		setLayout(null);
		
		PlayerUI.content = new JPanel();
		PlayerUI.content.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayerUI.content.setBounds(10, 11, 1580, 878);
		add(content);
		PlayerUI.content.setLayout(null);
		
		PlayerUI.playerName = new JTextField();
		PlayerUI.playerName.setFocusable(false);
		PlayerUI.playerName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		PlayerUI.playerName.setBorder(null);
		PlayerUI.playerName.setBackground(SystemColor.menu);
		PlayerUI.playerName.setEditable(false);
		PlayerUI.playerName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		PlayerUI.playerName.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerUI.playerName.setText("PLAYERNAME");
		PlayerUI.playerName.setBounds(10, 11, 166, 47);
		PlayerUI.content.add(playerName);
		PlayerUI.playerName.setColumns(10);
		
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
		
		/*
		rollDice = new JButton("Roll the Dice!");
		rollDice.setBounds(469, 25, 166, 60);
		content.add(rollDice);
		*/
		
		nextPlayerButton = new JButton("Next Player");
		nextPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.game.nextPlayer();
			}
		});
		nextPlayerButton.setBounds(698, 25, 166, 60);
		content.add(nextPlayerButton);
		
		
	}
	
	public static void newTurn(Player p) {
		update(p);
		content.repaint();
		if(p.isInJail()) {
			int roll = Game.rollDice();
			if(roll == 12 || roll == 6) {
				PlayerUI.popUp(new PopUpCard("You rolled a 12 or 6! You are now free from jail."));
				p.setInJail(false);
				p.setPosition(11);
			} else {
				PlayerUI.popUp(new PopUpCard("You did not roll a 12 or a 6. Try again next turn to see if you will get out of jail!"));
			}
		}

		rollDice = new JButton("Roll the Dice!");
		rollDice.setBounds(469, 25, 166, 60);
		content.add(rollDice);
		System.out.println(rollDice);
		rollDice.setVisible(true);
		rollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int diceRoll = Game.rollDice();
				popUp(new PopUpCard("You rolled a " + diceRoll + "."));
				p.move(diceRoll);
				System.out.println("bruh");
				content.remove(rollDice);
				content.repaint();
				System.out.println(p.getPosition());
				((Space) Board.board[p.getPosition() - 1]).land(p);
				System.out.println(p.getPosition());
				update(p);
			}
		});
		
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
		System.out.println(playerName);
		PlayerUI.playerName.setText(p.getName());
		playerMoney.setText(String.valueOf(p.getMoney()));
		if(hand != null) {
			content.remove(hand);
		}
		hand = new Hand(p);
		hand.setLocation(10, 136);
		content.add(hand);
		hand.refresh();
		/*
		 * resets each player's position.
		 */
		
		if(getPlayers().length == 2) {
			
			
			p1Position.removeAll();
			int position = getPlayers()[0].getPosition();
			Space space = ((Space) Board.board[position - 1]);
			p1Position.add(space);
			p1Position.repaint();
			
			p2Position.removeAll();
			int position2 = getPlayers()[1].getPosition();
			space = ((Space) Board.board[position2 - 1]);
			p2Position.add(space);
			p2Position.repaint();
		}
		if(getPlayers().length == 3) {
			p1Position.removeAll();
			int position = getPlayers()[0].getPosition();
			Space space = ((Space) Board.board[position - 1]);
			p1Position.add(space);
			p1Position.repaint();
			
			p2Position.removeAll();
			int position2 = getPlayers()[1].getPosition();
			space = ((Space) Board.board[position2 - 1]);
			p2Position.add(space);
			p2Position.repaint();
			
			p3Position.removeAll();
			int position3 = getPlayers()[2].getPosition();
			space = ((Space) Board.board[position3 - 1]);
			p3Position.add(space);
			p3Position.repaint();
		}
		if(getPlayers().length == 4) {
			p1Position.removeAll();
			int position = getPlayers()[0].getPosition();
			Space space = ((Space) Board.board[position - 1]);
			p1Position.add(space);
			p1Position.repaint();
			
			p2Position.removeAll();
			int position2 = getPlayers()[1].getPosition();
			space = ((Space) Board.board[position2 - 1]);
			p2Position.add(space);
			p2Position.repaint();
			
			p3Position.removeAll();
			int position3 = getPlayers()[2].getPosition();
			space = ((Space) Board.board[position3 - 1]);
			p3Position.add(space);
			p3Position.repaint();
			
			p4Position.removeAll();
			int position4 = getPlayers()[3].getPosition();
			space = ((Space) Board.board[position4 - 1]);
			p4Position.add(space);
			p4Position.repaint();
			System.out.println("1:" + position + " 2:" + position2 + " 3:" + position3 + " 4:" + position4);
		}
	}

	public static Player[] getPlayers() {
		return players;
	}

	public static void setPlayers(Player[] players) {
		PlayerUI.players = players;
	}
}