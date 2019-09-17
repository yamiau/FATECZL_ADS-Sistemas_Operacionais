package view;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import control.Pilot;

public class Main {
	
	private static int[][] racers = new int [2][7];
	
	public static void main(String[] args) {
		Semaphore trackCap = new Semaphore(5);
		SecureRandom random = new SecureRandom();
		int goal = 400;
		
		for (int i = 0; i < 14; i++) {
			int team = (random.nextInt(6) + 1);
			int num = (random.nextInt(1) + 1);
			Pilot pilot = new Pilot(team, num, goal, trackCap);
			racers[num][team] = 1;
			try {
				trackCap.acquire();
			} catch (InterruptedException e) {
				
			} finally {
				trackCap.release();
			}
		}
	}
}
