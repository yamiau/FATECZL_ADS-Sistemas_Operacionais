package control;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

public class Pilot extends Thread{
	
	private int team;
	private int num;
	private int position;
	private int goal;
	private Semaphore trackCap;
	
	public Pilot(int team, int num, int goal, Semaphore trackCap) {
		this.team = team;
		this.num = num;
		this.goal = goal;
		this.trackCap = trackCap;
	}
	
	@Override
	public void run() {
		try {
			trackCap.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			race();
			finish();
			trackCap.release();
		}
	}
	
	private void race() {
		SecureRandom random = new SecureRandom();
		while (position < goal) {
			position += (random.nextInt(120) + 50);
			System.out.println("T" + team + "P" + num + "has reached " + position + "m");
		}
	}
	
	private void finish() {
		System.out.println("T" + team + "P" + num + "has finished " + position + "m");
	}
}