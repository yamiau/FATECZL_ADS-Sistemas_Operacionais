package controller;

import java.security.SecureRandom;
import java.text.DecimalFormat;

public class Frog extends Thread {
	
	private int number;
	private Race race;
	private double goal;
	private double position;
	
	public Frog(int number, Race race) {
		this.number = number;
		this.race = race;
		this.goal = race.getLength();
		this.position = 0;
	}
	
	@Override
	public void run() {
		jump();
	}
	
	private void jump() {
		SecureRandom random = new SecureRandom();
		DecimalFormat df = new DecimalFormat("#.##");
		while(position < goal) {
			double leap = (random.nextDouble() * 10);
			if (leap >= 1) {
				this.position += leap;
				System.out.println("Frog #" + number + " has reached " + df.format(this.position) + " meters.");
				try {
					Frog.sleep((random.nextInt(400) + 100));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Frog #" + number + " stopped to eat a fly...");
				try {
					Frog.sleep((random.nextInt(200) + 50));
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}	
		}
		finish();
	}
	
	private void finish() {
		if (race.getWinner() == false) {
			race.setWinner();
			System.out.println("Frog #" + this.number + " has won the race!");
		} else {
			System.out.println("Frog #" + this.number + " has finally reached the finishing line!");
		}
		
	}
}
