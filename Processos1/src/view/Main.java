package view;

import javax.swing.JOptionPane;
import controller.NetworksController;

public class Main {
	public static void main(String[] args) {
		int op = 0;
		NetworksController nc = new NetworksController();
		
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Networks Controller :D"
					+ "\n1 - Get Ethernet Adapter name and IPv4 address"
					+ "\n2 - Get Ping from a web page of your choice"
					+ "\n9 - Exit"));
			
			switch (op) {
				case 1:
					nc.ip(System.getProperty("os.name").toLowerCase());
					break;
				case 2:
					String address = JOptionPane.showInputDialog("Which web address would you like to ping?"
							+ "\nPlease write it down exactly!");
					int pings = Integer.parseInt(JOptionPane.showInputDialog("How many pings do you want to send?"));
					nc.ping(System.getProperty("os.name").toLowerCase(), address, pings);
				case 9:
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "This is not a valid option!");
			}
		}
	}	
}
	
