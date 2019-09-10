package view;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ReSetter extends Thread{

	private static JLabel run;
	private static int counter = 0;
	
	public void setRun(JLabel run) {
		this.run = run;
	}
	
	public Rectangle setInitialPosition(int icon) {
		Rectangle r = new Rectangle();
		
		switch(icon) {
		case 0:
			r.setBounds(-120, 280, 130, 110);
			return r;
		case 1:
			r.setBounds(194, -120, 130, 110);
			return r;
		case 2:
			r.setBounds(600, 170, 130, 110);
			return r;
		case 3:
			r.setBounds(310, 600, 130, 110);
			return r;
		}
		return null;
	}
	
	public void counter(JLabel icon, int direction){
		counter++;
		icon.setBounds(setInitialPosition(direction));
		if (counter > 3) {
		try {
			sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		run.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\run1.png"));	
		}
	}
}
