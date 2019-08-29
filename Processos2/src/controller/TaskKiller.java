package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

public class TaskKiller {
	public void kill(String os) {
		
		String task = JOptionPane.showInputDialog("Enter the IM (Image Name) or PID (Process ID) you want to terminate."
				+ "\nType it in exactly, please!");
		
		if (os.contains("win")) {
			winKill(task);
		} else {
			linKill(task);
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
