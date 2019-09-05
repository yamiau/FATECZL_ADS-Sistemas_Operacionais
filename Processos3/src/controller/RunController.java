package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RunController implements ActionListener {
	
	private JFrame frame;
	private JTextField input;
	
	public RunController(JFrame frame, JTextField input) {
		this.frame = frame;
		this.input = input;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuffer sb = new StringBuffer();
		sb.append("cmd.exe /c " + input.getText());
		callProcess(sb.toString());
		input.setText(null);
	}
	
	private void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process); 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
