package control;

import java.awt.Rectangle;
import java.security.SecureRandom;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

public class Walker extends Thread{
	
	private JLabel icon;
	private Rectangle position = new Rectangle();
	private Rectangle r1= new Rectangle();
	private SecureRandom random = new SecureRandom();
	private static Semaphore passage = new Semaphore(1);
	
	public Walker(JLabel icon, JLabel door) {
		this.icon = icon;
		position = icon.getBounds(); 
		r1 = door.getBounds();
	}
	
	@Override
	public void run() {
		walk();
		try {
			passage.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			enter();
			passage.release();
		}
	}
	
	private void walk() {
		while (! collision()) {
			position.x += (random.nextInt());
			position.y -= (random.nextInt(3) + 4);
			icon.setBounds(position);
			try {
				sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void enter() {
		try {
			sleep(random.nextInt(1001) + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean collision() {
		if (position.intersects(r1)) {
			return true;
		} else {
			return false;
		}
	}
}
