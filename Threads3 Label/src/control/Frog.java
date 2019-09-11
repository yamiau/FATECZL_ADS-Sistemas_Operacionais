package control;

import java.io.InputStream;
import java.security.SecureRandom;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import view.Swamp;

public class Frog extends Thread {
	
	private Swamp swamp;
	private JLabel id;
	private JLabel goal;
	private java.awt.Rectangle position;	
	
	public Frog(Swamp swamp, JLabel id, JLabel goal) {
		this.swamp = swamp;
		this.id = id;
		this.goal = goal;
		this.position = id.getBounds();
	}
	
	@Override
	public void run() {
		jump();
	}
	
	private void jump() {
		SecureRandom random = new SecureRandom();
		while(! collision()) {
			
			double leap = (random.nextDouble() * 20);
			if (leap > 1) {
				this.position.x += leap;
				id.setBounds(this.position);
				try {
					Frog.sleep((random.nextInt(300) + 100));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					JLabel fly = new JLabel("");
					fly.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\eat_fly.gif"));
					fly.setBounds(this.position.x + 100, this.position.y + 30, 50, 50);
					swamp.add(fly);
					Frog.sleep(1200);
					swamp.remove(fly);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		finish();
	}
	
	private boolean collision() {
		java.awt.Rectangle r1 = id.getBounds();
		java.awt.Rectangle r2 = goal.getBounds();
		
		if (r1.intersects(r2)) {
			return true;
		} else {
			return false;
		}
	}
	
	private void finish() {
		if (! swamp.getWinner()) {
			swamp.setWinner();
			id.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\winner.gif"));
			SoundController sc = new SoundController();
			sc.music3();
		} else {
			id.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\loser.gif"));
		}		
	}
}
