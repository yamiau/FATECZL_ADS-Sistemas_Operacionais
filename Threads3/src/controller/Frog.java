package controller;

import java.security.SecureRandom;

public class Frog extends Thread {
	
	private int number;
	private double goal;
	private double position;
	private Race race;
	
	public Frog(int number, Race race) {
		this.number = number;
		this.goal = race.getLength();
		this.position = 0;
		this.race = race;
	}
	
	@Override
	public void run() {
		jump();
	}
	
	private void jump() {
		SecureRandom random = new SecureRandom();
		while(position < goal) {
			double leap = (random.nextDouble() * 10);
			if (leap != 0) {
				position += leap;
				System.out.println("Frog #" + number + " has reached " + position + " meters.");
			} else {
				System.out.println("Frog #" + number + " stopped to eat a fly...");
			}	
		}
		finish();
	}
	
	private void finish() {
		if (race.getWinner() == false) {
			race.setWinner();
			System.out.println("Frog #" + number + "has won the race!");
		} else {
			System.out.println("Frog #" + number + "has reached the finishing line!");
		}
		
	}
}
