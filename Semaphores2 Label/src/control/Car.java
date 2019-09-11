package control;

import java.io.File;
import view.ReSetter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Car extends Thread{

	private int direction;
	private JLabel icon;
	private JLabel intersection;
	private Semaphore semaphore;
	
	public Car(int direction, JLabel icon, JLabel intersection, Semaphore semaphore) {
		this.direction = direction;
		this.icon = icon;
		this.intersection = intersection;
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		move(1);
		try {
			semaphore.acquire();
			pass();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
		move(2);
	}
	
	private void move(int stage) {
		while (! collision(stage)) {
			SecureRandom random = new SecureRandom();
			java.awt.Rectangle position = icon.getBounds();
			int displacement = random.nextInt(20);
			switch(direction) {
			case 0:
				position.x += displacement;
				icon.setBounds(position); 
				break;
			case 1:
				position.y += displacement;
				icon.setBounds(position); 
				break;
			case 2:
				position.x -= displacement;
				icon.setBounds(position); 
				break;
			case 3:
				position.y -= displacement;
				icon.setBounds(position); 
				break;
			}
			try {
				sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void pass() {
		String filepath = System.getProperty("user.dir") + "\\snd\\honk.wav";
		InputStream is;
		try {
			is = new FileInputStream(new File(filepath));
			AudioStream as = new AudioStream(is);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SecureRandom random = new SecureRandom();
		java.awt.Rectangle r1 = icon.getBounds();
		java.awt.Rectangle r2 = intersection.getBounds();
		
		while (r1.intersects(r2)) {
			int displacement = random.nextInt(10);
			switch(direction) {
			case 0:
				r1.x += displacement;
				icon.setBounds(r1); 
				break;
			case 1:
				r1.y += displacement;
				icon.setBounds(r1); 
				break;
			case 2:
				r1.x -= displacement;
				icon.setBounds(r1); 
				break;
			case 3:
				r1.y -= displacement;
				icon.setBounds(r1); 
				break;
			}
			try {
				sleep(random.nextInt(30) + 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean collision(int stage) {
		java.awt.Rectangle r1 = icon.getBounds();
		java.awt.Rectangle r2 = intersection.getBounds();
		java.awt.Rectangle r3 = intersection.getBounds();
		
		switch(direction) {
		case 0:
			r3.x = 700;
			break;
		case 1:
			r3.y = 700;
			break;
		case 2:
			r3.x = -400;
			break;
		case 3:
			r3.y = -400;
			break;
		}
		
		if (stage == 1) {
			if (r1.intersects(r2)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (r1.intersects(r3)) {
				ReSetter rs = new ReSetter();
				rs.reset(icon, direction);
				return true;
			} else {
				return false;
			}
		}		
	}
}
