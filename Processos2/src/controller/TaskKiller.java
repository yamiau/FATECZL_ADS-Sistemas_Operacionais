package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

public class TaskKiller {
	public void kill(String os, String task) {
		
		if (os.contains("win")) {
			winKill(task);
		} else if (os.contains("lin")){
			linKill(task);
		} else {
			JOptionPane.showMessageDialog(null, "Operating System not supported!");
		}
	}
	
	private static void winKill(String task) {
		try {
			int PID = Integer.parseInt(task);
			try {
				Runtime.getRuntime().exec("taskkill /pid " + PID);					
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		} catch(NumberFormatException e) {
			try {
				Runtime.getRuntime().exec("taskkill /im " + task);
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private static void linKill(String task) {
		try {
			int PID = Integer.parseInt(task);
			try {
				Runtime.getRuntime().exec("kill -9 " + PID);					
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		} catch(NumberFormatException e) {
			try {
				Runtime.getRuntime().exec("Taskkill /F /IM " + task);
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
