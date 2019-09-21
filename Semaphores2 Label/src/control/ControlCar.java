package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.ReSetter;

public class ControlCar implements MouseListener{

	private JLabel[] cars;
	private JLabel intersection;
	private Semaphore semaphore;
	private JLabel run;
	
	public ControlCar(JLabel[] cars, JLabel intersection, Semaphore semaphore, JLabel run) {
		this.cars = cars;
		this.intersection = intersection;
		this.semaphore = semaphore;
		this.run = run;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ReSetter rs = new ReSetter();
		rs.setRun(run);
		run.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\run2.png"));
		for (int i = 0; i < 4; i++) {
			Thread car = new Car(i, cars[i], intersection, semaphore);
			car.start();			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
