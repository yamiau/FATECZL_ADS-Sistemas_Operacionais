package view;

import javax.swing.JOptionPane;

import controller.NetworksController;

public class Main {
	public static void main(String[] args) {
		int op = 0;
		NetworksController nc = new NetworksController();
		
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("1 - Get Ethernet Adapter and IPv4 \n"
					+ "2 - Get Ping from a web page \n"
					+ "9 - Exit"));
			
			switch (op) {
				case 1: 
					nc.IP(findOS());
					break;
				case 2:
					nc.ping(findOS());
				case 9:
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "This is not a valid option!");
			}
		}
	}
	
	private static String findOS() {
		return(System.getProperty("os.name"));
	}
	
}
