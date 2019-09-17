package view;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import control.Knight;


public class Main {
	private static SecureRandom sr = new SecureRandom();
	static int safe = 0;
	private static int unsafe = 0;
	
	public static void main(String[] args) {
		String[] names = {"Stark", "Baratheon", "Lannister", "Tyrell"};
		Semaphore getItem = new Semaphore(1);
		Semaphore doors = new Semaphore(1);
			
		for (int i = 0; i < 4; i++) {
			Knight knight = new Knight(names[i], getItem, doors);
			knight.start();
		}
	}
	
	public static boolean safeDoor() {
		if (safe > 0) {
			return false;
		} else if (unsafe == 3) {
			return true;
		} else {
			int luck = sr.nextInt(2);
			if (luck > 0) {
				safe++;
				return true;
			} else {
				unsafe++;
				return false;
			}
		}
	}
	
	public static String getDeath() {
		String[] deaths = {"charred by a dragon", 
				"trampled by a pony", 
				"digested by a slime", 
				"devoured by a tarrasque", 
				"decapitated by a giant cockroach"};
		return(deaths[sr.nextInt(5)]);
	}	
}
