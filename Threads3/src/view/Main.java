package view;

import javax.swing.JOptionPane;
import controller.Frog;
import controller.Race;

public class Main {
	public static void main(String[] args) {
		Race race = new Race();
		race.setLength(setTrackLength());
		
		for (int i = 1; i < 4; i++) {
			Thread frog = new Frog(i, race);
		}
	}
	
	private static double setTrackLength() {
		return(Double.parseDouble(JOptionPane.showInputDialog("How long is this track in meters?")));
	}
}
