package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import view.Track;


public class RacerController implements ActionListener{
	
	private Track track;
	private JLabel racer1;
	private JLabel racer2;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dragStart();
	}

	private void dragStart() {
		Thread drag1 = new Racer(track, 1, racer1, goal);
		drag1.start();
		Thread drag2 = new Racer(track, 2, racer2, goal);
		drag2.start();
	}
}
