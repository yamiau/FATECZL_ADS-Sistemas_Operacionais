package view;

import javax.swing.JOptionPane;

import controller.OSFinder;
import controller.TaskLister;
import controller.TaskKiller;

public class Main {
	public static void main(String[] args) {
		int op = 0;
		
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Task/Process Killer\n"
					+ "1 - List Tasks and Processes\n"
					+ "2 - Kill a Task/Process\n"
					+ "9 - Exit"));
			
			switch (op) {
				case 1:
					OSFinder osf = new OSFinder();
					TaskLister tl = new TaskLister();
					tl.list(osf.getOS());
					break;
				case 2:
					TaskKiller tk = new TaskKiller();
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
