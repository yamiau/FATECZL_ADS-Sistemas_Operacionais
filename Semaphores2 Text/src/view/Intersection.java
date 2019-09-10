package view;

import java.util.concurrent.Semaphore;

import controller.Car;

public class Intersection {
	public static void main(String[] args) {
		String[] cars = {"Blue", "Red", "Green", "Yellow"};
		Semaphore intersection = new Semaphore(1);
		
		for (int i = 0; i < cars.length; i++) {
			Thread car = new Car(cars[i], i, intersection);
			car.start();
		}
	}
}
