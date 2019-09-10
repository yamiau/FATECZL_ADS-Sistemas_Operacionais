package controller;

import java.util.concurrent.Semaphore;

public class Car extends Thread{

	private String carID;
	private String direction;
	private Semaphore intersection;
	private int move = 88;
	
	
	public Car(String carID, int direction, Semaphore intersection) {
		this.carID = carID;
		switch(direction) {
		case 0:
			this.direction = "South";
			break;
		case 1:
			this.direction = "West";
			break;
		case 2:
			this.direction = "North";
			break;
		case 3:
			this.direction = "East";
			break;
		}
		this.intersection = intersection;
	}
	
	@Override
	public void run(){
		move();
		try {
			intersection.acquire();
			
			pass();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			intersection.release();
		}
		arrive();
	}
	
	private void move() {
		int distInter =  (int) ((Math.random() * 301) + 200);
		while (distInter > 0) {
			if ((distInter - move) < move) {
				distInter = 0;
				System.out.println("== The " + carID + " car has reached the intersection ==");
			} else {
				distInter -= move;				
				System.out.println(carID + " is " + distInter + "m from the intersection heading " + direction + ".");
			}
		}
	}
	
	private void pass() {
		for (int i = 0; i < 3; i++) {
			System.out.println("!! The " + carID + " car is going through !!");
		}
		System.out.println("The " + carID + " car has left the intersection.");
	}
	
	private void arrive() {
		int distStop = (int) ((Math.random() * 501) + 500);
		while (distStop > 0) {
			if ((distStop - move) < move) {
				distStop = 0;
				System.out.println("The " + carID + " car has reached the " + direction + " stop.");
			} else {
				distStop -= move;				
				System.out.println("The " + carID + " car is " + distStop + "m from the " + direction + " stop.");
			}
		}
	}

}
