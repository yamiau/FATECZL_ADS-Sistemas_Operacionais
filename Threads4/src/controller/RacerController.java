package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class RacerController implements ActionListener{

	private JLabel racer1;
	private JLabel racer2;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dragStart();
	}

	private void dragStart() {
		Thread drag1 = new Drag(racer1);
		drag1.start();
		Thread drag2 = new Drag(racer2);
		drag2.start();
	}
}
