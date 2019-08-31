package controller;

import java.security.SecureRandom;

public class Frog extends Thread {
	
	private int number;
	private double goal;
	private double position;
	
	public Frog(int number, double trackLength) {
		this.number = number;
		this.goal = trackLength;
		this.position = 0;
	}
	
	@Override
	public void run() {
		jump();
	}
	
	private void jump() {
		SecureRandom random = new SecureRandom();
		while(position < goal) {
			position += random.nextDouble(); //gotta check the unit values here
		}
	}
}
