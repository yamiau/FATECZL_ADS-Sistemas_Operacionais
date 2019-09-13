package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.Track;


public class RacerController implements ActionListener{
	
	private Track track;
	private JLabel[] racers;
	private JLabel goal;
	
	public RacerController(Track track, JButton button, JLabel[] racers, JLabel goal) {
		this.track = track;
		this.racers = racers;
		this.goal = goal;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		reset();
		dragStart();
	}

	private void dragStart() {
		for (int i = 0; i < 3; i++) {
			Thread drag1 = new Racer(track, i, racers[i], goal);
			drag1.start();			
		}
	}
	
	private void reset() {
	}
}
