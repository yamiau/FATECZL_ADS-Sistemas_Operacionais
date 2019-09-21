package controller;

import java.awt.Rectangle;
import java.security.SecureRandom;
import javax.swing.JLabel;
import view.Track;

public class Racer extends Thread{
	
	private Track track;
	private int id;
	private JLabel racer;
	private JLabel goal;
	
	public Racer(Track track, int id, JLabel racer, JLabel goal) {
		this.track = track;
		this.id = id;
		this.racer = racer;
		this.goal = goal;
	}
	
	@Override
	public void run() {
		race();
	}
	
	private void race() {
		SecureRandom random = new SecureRandom();
		Rectangle pos = racer.getBounds();
		while (! collision()) {
			pos.x -= (random.nextInt(55)+20);
			racer.setBounds(pos);
			try {
				sleep(random.nextInt(10)+20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		finish();
	}
	
	private boolean collision() {
		Rectangle r1 = racer.getBounds();
		Rectangle r2 = goal.getBounds();
		
		if (r1.intersects(r2)) {
			return true;
		} else {
			return false;
		}
	}
	
	private void finish() {
		if (! track.getWinner()) {
			track.setWinner(racer);
		}
	}
}
