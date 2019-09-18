package view;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import control.Pilot;

public class Main {
	
	private static int[][] racers = new int [7][2];
	
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		int trackLength = 400;
		
		for (int i = 1; i < racers.length + 1; i++) {
			for (int j = 1; j < racers[i].length + 1; j++) {
				Pilot pilot = new Pilot(i, j, trackLength);
				pilot.start();				
			}
		}
	}
}
