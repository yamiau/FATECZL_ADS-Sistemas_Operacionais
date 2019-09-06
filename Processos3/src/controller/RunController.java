package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RunController implements ActionListener {
	

	private JTextField input;
	
	public RunController(JTextField input) {
		this.input = input;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuffer sb = new StringBuffer(checkOS());
		sb.append(input.getText());
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
	
	private String checkOS() { 
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			return "cmd.exe /c start ";
		} else if (System.getProperty("os.name").toLowerCase().contains("lin")) {
			return "";
		} else {
			JOptionPane.showMessageDialog(null, "Operating System not supported!");
		}
		return(null);
	}
}
