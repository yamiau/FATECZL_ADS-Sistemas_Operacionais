package view;


import control.Ticket;

public class Main {
	public static void main(String[] args) {
		int customers = 300;
		for (int i = 0; i < customers; i++) {
			Thread ticket = new Ticket(i);
			ticket.start();
		}
	}
	
	
	public static void msg(int id, int stage, int quantity) {
		
		switch (stage) {
		case 1:
			System.out.println("Customer #" + id + "| Logging in... please wait...");
			break;
		case 2:
			System.out.println("Customer #" + id + "| Welcome!");
			break;
		case 3:
			System.out.println("Customer #" + id + "| You've been disconnected from the server due to a timeout error. Please try again later!");
			break;
		case 4:
			System.out.println("Customer #" + id + "| Validating your order... please wait...");
			break;
		case 5:
			if (quantity > 1) {
				System.out.println("Customer #" + id + "| You have purchased " + quantity + " tickets. Enjoy the show!");				
			} else {
				System.out.println("Customer #" + id + "| You have purchased your ticket. Enjoy the show!");
			}
			break;
		case 6:
			System.out.println("Customer #" + id + "|There are not enough tickets available. Only " + quantity + " tickets are left. Try again later.");
			break;
		}
	}
}
