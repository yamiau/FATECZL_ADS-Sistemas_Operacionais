package control;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

public class Pilot extends Thread{
	
	private int team;
	private int num;
	private int position;
	private int goal;
	private int lapCount;
	private double lapTime;
	private static double[][] records = new double[7][2]; 
	private static Semaphore[] teamCap = new Semaphore[7];
	private static Semaphore trackCap = new Semaphore (5); 
	
	public Pilot(int team, int num, int goal) {
		this.team = team ;
		this.num = num ;
		this.goal = goal;
		for (int i = 0; i < teamCap.length; i++) {
			teamCap[i] = new Semaphore(1);
		}
	}
	
	@Override
	public void run() {
		try {
			teamCap[team].acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				trackCap.acquire();
				race();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				finish();
				teamCap[team].release();
				trackCap.release();
			}
		}
	}
	
	private void race() {
		SecureRandom random = new SecureRandom();
		double initialTime = System.nanoTime();
		while (position < goal) {
			position += (random.nextInt(120) + 50);
			System.out.println("T" + team + "P" + num + " has reached " + position + "m.");
		}
		double finalTime = System.nanoTime();
		lapTime = finalTime - initialTime;
	}
	
	private void finish() {
		lapCount++;
		if (lapCount == 1) {
			System.out.println("T" + team + "P" + num + " has finished their 1st lap with a time of " + lapTime + ".");
			records[team][num] = lapTime;
		} else if (lapCount == 2){
			System.out.println("T" + team + "P" + num + " has finished their 2nd lap with a time of " + lapTime + ".");	
			if (records[team][num] > lapTime) {
				records[team][num] = lapTime;
			}
		} else {
			System.out.println("T" + team + "P" + num + " has finished their 3rd lap with a time of " + lapTime + ".");
			if (records[team][num] > lapTime) {
				records[team][num] = lapTime;
			}
		}
	}
}