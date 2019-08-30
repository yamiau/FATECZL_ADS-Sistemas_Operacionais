package view;

import javax.swing.JOptionPane;

import controller.OSFinder;
import controller.TaskLister;
import controller.TaskKiller;

public class Main {
	public static void main(String[] args) {
		int op = 0;
		OSFinder osf = new OSFinder();
		
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Task/Process Killer\n"
					+ "1 - List Tasks and Processes\n"
					+ "2 - Kill a Task/Process\n"
					+ "9 - Exit"));
			
			switch (op) {
				case 1:
					TaskLister tl = new TaskLister();
					tl.list(osf.getOS());
					break;
				case 2:
					TaskKiller tk = new TaskKiller();
					String task = JOptionPane.showInputDialog("Enter the IM (Image Name) or PID (Process ID) you want to terminate."
							+ "\nType it in exactly, please!");
					tk.kill(osf.getOS(), task);
					break;
				case 9:
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Invalid option!");;
					break;
			}
		}
	}
}
