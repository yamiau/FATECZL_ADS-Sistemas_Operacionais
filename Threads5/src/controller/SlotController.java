package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import view.SlotMachine;

public class SlotController implements ActionListener{
	
	private SlotMachine frame;
	private JTextField[] slots;

	
	public SlotController(SlotMachine frame, JTextField slot0, JTextField slot1, JTextField slot2) {
		this.frame = frame;
		this.slots[0] = new JTextField();
		this.slots[0] = slot0;
		this.slots[1] = new JTextField();
		this.slots[1] = slot1;
		this.slots[2] = new JTextField();
		this.slots[2] = slot2;
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
