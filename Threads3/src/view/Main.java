package view;

import javax.swing.JOptionPane;
import controller.Frog;
import controller.Track;

public class Main {
	public static void main(String[] args) {
		Track track = new Track();
		track.setLength(setTrackLength());
		
		for (int i = 1; i < 4; i++) {
			Thread frog = new Frog(i, track.getLength());
		}
	}
	
	private static double setTrackLength() {
		return(Double.parseDouble(JOptionPane.showInputDialog("How long is this track in meters?")));
	}
}
