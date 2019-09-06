package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import view.SlotMachine;

public class SlotController implements ActionListener{
	
	private SlotMachine frame;
	private JTextField[] slots;

	
	public SlotController(SlotMachine frame, JTextField[] slots) {
		this.frame = frame;
		this.slots = slots;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		callRandom();
	}
	
	private void callRandom() {
		for (JTextField i: slots) {
			Thread randomizer = new Randomizer(frame, i);
			randomizer.start();		
		}

	}
}
