package util;

import java.util.ArrayList;

import Runner.Main;
import cards.Card;
import cards.TitleCard;
import logi.Board;
import logi.Player;
import ui.PlayerUI;

public class CommunityChestCardScenarios {
	public static String s1 = "Sell your lifetime, 50-yard line, season tickets on e-bay. Collect $200";
	public static String s2 = "You win the lottery. Collect $1000";
	public static String s3 = "You owe back on taxes. Pay $500 in fines.";
	public static String s4 = "Take dance lessons with a celebrity coach. Pay $500.";
	public static String s5 = "Your computer network gets hit with a virus. Pay $1000.";
	public static String s6 = "Redo the landscaping at all of your properties. Pay $400 per house, and $1150 per hotel.";
	public static String s7 = "Advance to \"GO\", collect $2000";
	public static String s8 = "You coordinate opening day activities at Progressive Field. Collect $250 for your services.";
	public static String s9 = "Win big at the casino. Collect $1000.";
	public static String s10 = "You are runner up on a reality TV show. Collect $100.";
	public static String s11 = "You promote your new book on TV morning news. Recieve $100 in bonus sales.";
	public static String s12 = "Make it big in Hollywood. Collect $2000 in a movie deal.";
	public static String s13 = "You run for mayor. Collect $100 from each player to fund your campaign.";
	public static String s14 = "Your trust fund becomes available. Collect $500.";
	public static String s15 = "Arrested for insider trading. Go to jail. Do not pass \"GO\". Do not collect $2000.";
	public static String s16 = "Revieve a presidential pardon. GET OUT OF JAIL FREE";
	
	public static String[] messages = new String[] {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16};
	
	public static void s1(Player p) {
		p.addMoney(200);
		PlayerUI.update(p);
	}
	
	public static void s2(Player p) {
		p.addMoney(1000);
		PlayerUI.update(p);
	}
	
	public static void s3(Player p) {
		p.subtractMoney(500);
		Board.addToFreeParking(500);
		PlayerUI.update(p);
	}
	
	public static void s4(Player p) {
		p.subtractMoney(500);
		Board.addToFreeParking(500);
		PlayerUI.update(p);
	}
	
	public static void s5(Player p) {
		p.subtractMoney(1000);
		Board.addToFreeParking(1000);
		PlayerUI.update(p);
	}
	
	public static void s6(Player p) {
		ArrayList<Card> cards = p.getCards();
		int totalToPay = 0;
		for(Card card : cards) {
			TitleCard c;
			if(card instanceof TitleCard) {
				c = (TitleCard) card;
				
				if(c.getHouses() == 5) {
					totalToPay += 1150; //for hotel
					totalToPay += 400 * 4; // for houses
				} else {
					totalToPay += 400 * c.getHouses();
				}
			}
			
		}
		p.subtractMoney(totalToPay);
		Board.addToFreeParking(totalToPay);
		PlayerUI.update(p);
	}
	
	public static void s7(Player p) {
		p.setPosition(1);
		p.passGo();
		PlayerUI.update(p);
	}
	
	public static void s8(Player p) {
		p.addMoney(250);
		PlayerUI.update(p);
	}
	
	public static void s9(Player p) {
		p.addMoney(1000);
		PlayerUI.update(p);
	}
	
	public static void s10(Player p) {
		p.addMoney(100);
		PlayerUI.update(p);
	}
	
	public static void s11(Player p) {
		p.addMoney(100);
		PlayerUI.update(p);
	}
	
	public static void s12(Player p) {
		p.addMoney(2000);
		PlayerUI.update(p);
	}
	
	public static void s13(Player p) {
		int amount = 0;
		for(Player a : Main.game.getPlayers()) {
			amount += 100;
			a.subtractMoney(100);
		}
		p.addMoney(amount);
		PlayerUI.update(p);
	}
	
	public static void s14(Player p) {
		p.addMoney(500);
		PlayerUI.update(p);
	}
	
	public static void s15(Player p) {
		p.setPosition(11);
		p.setInJail(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PlayerUI.update(p);
	}
	
	public static void s16(Player p) {
		p.setGetOutOfJailFree(true);
	}
}
