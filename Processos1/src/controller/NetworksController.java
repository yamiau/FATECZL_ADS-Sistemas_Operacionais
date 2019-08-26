package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class NetworksController {
	public void ip(String os) {
		
		if (os.contains("win")) {
			winIP();
		} else {
			linIP();
		}
	}
	
	private static void winIP() {
		try {
			Process proc = Runtime.getRuntime().exec("ipconfig");
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			
			while (line != null) {
				if (line.toLowerCase().contains("ethernet")) {
					line = br.readLine();
					line = br.readLine();
					String[] filter = line.split(":");
					System.out.println("Ethernet Adapter: " + filter[1]);
				} else if (line.toLowerCase().contains("ipv4")) {
					String[] filter = line.split(":");
					System.out.println("IPv4 Address: " + filter[1]);
				}
				line = br.readLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void linIP() {
		try {
			Process proc = Runtime.getRuntime().exec("ifconfig");
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			
			while (line != null) {
				if (line.toLowerCase().contains("ethernet")) {
					line = br.readLine();
					line = br.readLine();
					String[] filter = line.split(":");
					System.out.println("Ethernet Adapter: " + filter[1]);
				} else if (line.toLowerCase().contains("ipv4")) {
					String[] filter = line.split(":");
					System.out.println("IPv4 Address: " + filter[1]);
				}
				line = br.readLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ping(String os) {
		
		String address = JOptionPane.showInputDialog("Which web address would you like to ping?"
				+ "\nPlease write it down exactly!");
		int pings = Integer.parseInt(JOptionPane.showInputDialog("How many pings do you want to send?"));
		
		if (os.contains("win")) {
			winPing(pings, address);
		} else {
			linPing(pings, address);
		}
	}
	
	private static void winPing(int pings, String address) {
		String command = "ping -n "  + pings + " " + address;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			List<Integer> receivedPings = new ArrayList<Integer>();
			
			while (line != null) {
				if (line.toLowerCase().contains("ttl")) {
					String[] filter1 = line.split("ms");
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < filter1.length -1; i++) {
						sb.append(filter1[i]);
					}
					
					String[] filter2 = sb.toString().split("=");
					System.out.println(filter2[2] + "ms");
					receivedPings.add(Integer.parseInt(filter2[2]));
				}
				line = br.readLine();
			}
			pingStats(receivedPings);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void linPing(int pings, String address) {
		String command = "ping c("  + pings + ") " + address;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			List<Integer> receivedPings = new ArrayList<Integer>();
			
			while (line != null) {
				if (line.toLowerCase().contains("ttl")) {
					String[] filter1 = line.split("ms");
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < filter1.length -1; i++) {
						sb.append(filter1[i]);
					}
					
					String[] filter2 = sb.toString().split("=");
					System.out.println(filter2[2] + "ms");
					receivedPings.add(Integer.parseInt(filter2[2]));
				}
				line = br.readLine();
			}
			pingStats(receivedPings);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void pingStats(List<Integer> receivedPings) {
		int total = 0;
		int min = receivedPings.get(0);
		int max = receivedPings.get(0);
		
		for (int i : receivedPings) {
			if (i < min){
				min = i;
			} else if (i > max){
				max = i;
			}
			total += i;
		}		
		System.out.println("Min time: " + min);
		System.out.println("Max time: " + max)	;
		System.out.println("Mean time: " + (total/receivedPings.size()));
	}
}
