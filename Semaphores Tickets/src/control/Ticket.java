package control;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import view.Main;

public class Ticket extends Thread{
	
	private SecureRandom random = new SecureRandom();
	private static Semaphore semaphore = new Semaphore(1);
	private static int available_tickets = 1000;
	private boolean advance;
	private int desired_tickets;
	private int id;
	
	public Ticket(int id) {
		this.id = id;
		this.desired_tickets = (random.nextInt(5) + 1);
	}
	
	@Override
	public void run() {
		logIn();
		if (advance) {
			purchase();			
		} else {
			run();
		}
		if (advance) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				validate();
			}
		} else {
			run();
		}
	}
	
	private void logIn() {
		int time = (random.nextInt(2001) + 50);
		Main.msg(id, 1, 0);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (time < 1000) {
			Main.msg(id, 2, 0);
			advance = true;
		} else {
			Main.msg(id, 3, 0);
			advance = false;
		}
	}

	private void purchase() {
		int time = (random.nextInt(3001) + 1000);
		Main.msg(id, 4, 0);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (time < 2500) {
			advance = true;
		} else {
			Main.msg(id, 3, 0);
			advance = false;
		}
	}
	
	private void validate() {
		if (available_tickets >= desired_tickets) {
			Main.msg(id, 5, desired_tickets);
			available_tickets -= desired_tickets;
		} else {
			Main.msg(id, 6, available_tickets);
		}
	}
}
