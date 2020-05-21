package cards;

import javax.swing.JPanel;

import logi.Board;
import spaces.PropertySpace;
import spaces.RailroadSpace;
import spaces.UtilitySpace;
public class Card extends JPanel {
	public int position;
	private String name;
	public static int findPosition(String name) {
		int position = 0;
		for(int x = 0; x < Board.board.length; x++) { 
			if(Board.board[x] instanceof PropertySpace) {
				PropertySpace p = (PropertySpace) Board.board[x];
				if(name.equals(p.name)) {
					position = x;
				}
			}
			if(Board.board[x] instanceof RailroadSpace) {
				RailroadSpace p = (RailroadSpace) Board.board[x];
				if(name.equals(p.name)) {
					position = x;
				}
			}
			if(Board.board[x] instanceof UtilitySpace) {
				UtilitySpace p = (UtilitySpace) Board.board[x];
				if(name.equals(p.getName())) {
					position = x;
				}
			}
		}
		return position;
	}
	
	public String getName() {
		return name;
	}

}
