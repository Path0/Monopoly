package util;

import java.util.ArrayList;

import javax.swing.JPanel;

import Runner.Main;
import cards.TitleCard;
import logi.Player;

public class ChanceCardScenarios {

	public static String s1 = "get out of jail free";
	public static String s2 = "Summoned for jury duty. Go back three spaces.";
	public static String s3 = "A group of guests wins a class action suit against your hotel. Pay each player $500.";
	public static String s4 = "Get a tax break for driving a hybrid. Collect $500"; 
	public static String s5 = "Make a donation for disaster relief. Pay $150.";
	public static String s6 = "Ride first-class to Reading Railroad. If you pass \"GO\", collect $2000.";
	public static String s7 = "Jump on a plane to Illinois Avenuue. If you pass \"GO\", collect $2000.";
	public static String s8 = "Take a helicopter ride to Boardwalk. If you pass \"GO\", collect $2000.";
	public static String s9 = "Splash out on a trip to St. Charles Place. If you pass \"GO\", collect $2000.";
	public static String s10 = "Advance to the nearest railroad space. If unowned, you may buy it from the bank. If owned, throw dice and pay the owner "
			+ "twice the rental to which they are otherwise entitled. If you pass \"GO\", collect $2000.";
	public static String s11 = "Advance to the nearest utility space. If unowned, you may buy it from the bank. If owned, throw dice and pay the owner "
			+ "10,000 times the amount shown on the dice. If you pass \"GO\", collect $2000.";
	public static String s12 = "Convicted of identity theft. Go to jail. Do not pass \"GO\", do not collect $2000.";
	public static String s13 = "Advance to \"GO\". Collect $2000.";
	public static String s14 = "Accept the position of CEO at a high-powered investment banking firm. Collect a signing bonus of $1500.";
	public static String s15 = "Your city does a tax revaluation. For each house pay $250, for each hotel pay $1000.";
	
	public static String[] messages = new String[] {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15};
	
	public static String htmlFormat(String scenario) {
		return "<center><font size = 2>" + scenario + "</font></center>";
	}
	
	public static void s1(Player p) {
		p.setGetOutOfJailFree(true);
	}
	
	public static void s2(Player p) {
		p.move(-3);
	}
	
	public static void s3(Player p) {
		for(Player x : Main.game.getPlayers()) {
			p.payPlayer(x, 500);
		}
	}
	
	public static void s4(Player p) {
		p.addMoney(500);
	}
	
	public static void s5(Player p) {
		p.subtractMoney(150);
		Main.game.board.addToFreeParking(150);
	}
	
	public static void s6(Player p) {
		int pos = 6;
		if(p.getPosition() > pos) {
			p.passGo();
		}
		p.setPosition(pos);
	}
	
	public static void s7(Player p) {
		int pos = 25;
		if(p.getPosition() > pos) {
			p.passGo();
		}
		p.setPosition(pos);
	}
	
	public static void s8(Player p) {
		int pos = 40;
		if(p.getPosition() > pos) {
			p.passGo();
		}
		p.setPosition(pos);
	}
	
	public static void s9(Player p) {
		int pos = 12;
		if(p.getPosition() > pos) {
			p.passGo();
		}
		p.setPosition(pos);
	}
	
	public static void s10(Player p) {
		int pos1 = 6;
		int pos2 = 16;
		int pos3 = 26;
		int pos4 = 36;
		
		int playerPos = p.getPosition();
		
		if(playerPos > pos4) {
			p.passGo();
			p.setPosition(pos1);
		} else if(playerPos > pos3) {
			p.setPosition(pos4);
		} else if(playerPos > pos2) {
			p.setPosition(pos3);
		} else if(playerPos > pos1) {
			p.setPosition(pos2);
		} else if(playerPos < pos1) {
			p.setPosition(pos1);
		}
	}
	
	public static void s11(Player p) {
		int pos1 = 13;
		int pos2 = 29;
		
		
		int playerPos = p.getPosition();
		
		if(playerPos > pos2) {
			p.passGo();
			p.setPosition(pos1);
		} else if(playerPos > pos1) {
			p.setPosition(pos2);
		} else if(playerPos < pos1) {
			p.setPosition(pos1);
		}
	}
	
	public static void s12(Player p) {
		p.setInJail(true);
		p.setPosition(11);
	}
	
	public static void s13(Player p) {
		p.passGo();
		p.setPosition(1);
	}
	
	public static void s14(Player p) {
		p.addMoney(1500);
	}
	
	public static void s15(Player p) {
		ArrayList<JPanel> cards = p.getCards();
		int totalToPay = 0;
		for(JPanel card : cards) {
			TitleCard c;
			if(card instanceof TitleCard) {
				c = (TitleCard) card;
				if(c.getHouses() == 5) {
					totalToPay += 1000; //for hotel
					totalToPay += 250 * 4; // for houses
				} else {
					totalToPay += 250 * c.getHouses();
				}
			}
			
		}
		p.subtractMoney(totalToPay);
		Main.game.board.addToFreeParking(totalToPay);
	}

}
