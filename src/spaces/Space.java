package spaces;

import javax.swing.JPanel;

import logi.Player;

public abstract class Space extends JPanel{

	public Space() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void land(Player p);

}
