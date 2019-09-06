package controller;

import javax.swing.JLabel;

public class Drag extends Thread{
	
	private JLabel racer;
	
	public Drag(JLabel racer) {
		this.racer = racer;
	}
	
	@Override
	public void run() {
		race();
	}
	
	private void race() {
		racer.getAlignmentX();
	}
}
