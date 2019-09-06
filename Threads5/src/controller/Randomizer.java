package controller;

import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JTextField;

import view.SlotMachine;

public class Randomizer extends Thread{

	private SlotMachine frame;
	private JTextField slot;
	private int value;
	
	public Randomizer(SlotMachine frame, JTextField slot) {
		this.frame = frame;
		this.slot = slot;
		this.value = 0;
	}
	
	@Override 
	public void run() {
		randomize(frame, slot);
	}
	
	private void randomize(SlotMachine frame, JTextField slot) {
		SecureRandom random = new SecureRandom();
		int roller = 0;
		int control = (random.nextInt(100) + 80);
		while (roller <= control) {
			int generated = (random.nextInt(7) + 1);
			slot.setText(Integer.toString(generated));
			try {
				sleep((random.nextInt(80) + 20));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			this.value = generated;
			roller++;
		}
		SlotMachine.result(value);
	}
}
