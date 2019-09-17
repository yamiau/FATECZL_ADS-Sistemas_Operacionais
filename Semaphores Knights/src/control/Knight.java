package control;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import view.Main;

public class Knight extends Thread{

	private int position;
	private SecureRandom sr = new SecureRandom();
	private static boolean torch = true;
	private static boolean gem = true;
	private String name;
	private Semaphore getItem;
	private Semaphore doors;
	private int baseSpeed;
	
	public Knight(String name,  Semaphore getItem, Semaphore doors) {
		this.name = name;
		this.getItem = getItem;
		this.doors = doors;
		this.baseSpeed = 2;
	}
	
	@Override
	public void run() {
		move(500);
		
		if (torch) {
			try {
				getItem.acquire();
				torch = false;
				System.out.println("** " + name +" acquired the Torch of Enlightenment! **");
				baseSpeed += 2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				getItem.release();	
				move(1500);
			}
		} else {
			move(1500);
		}

		if (gem) {
			try {
				getItem.acquire();
				gem = false;
				System.out.println("** " + name +" acquired the Bright Valliant Gem! **");
				baseSpeed += 2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				getItem.release();
				move(2000);
			}
		} else {
			move(2000);
		}
		
		try {
			doors.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			doors.release();
			open();
		}
	}
	
	private void move(int milestone) {
		while (position < milestone) {
			position += (sr.nextInt(baseSpeed) + 2);
			System.out.println(name +" has reached " + position + " meters");
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void open() {
		if (Main.safeDoor()) {
			System.out.println(name +" has exited the dungeon safely!");
		} else {
			System.out.println("***" + name +" has been " + Main.getDeath() + "! What a horrible fate...");
		}
	}
}
