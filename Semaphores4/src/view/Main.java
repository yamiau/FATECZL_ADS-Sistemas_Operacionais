package view;

import java.security.SecureRandom;

import control.Transaction;

public class Main {
	public static void main(String[] args) {
		
		SecureRandom random = new SecureRandom();
		int transactions = 20;
		int[][] accounts = new int[20][2];
		
		for (int i = 0; i < accounts.length; i++) {
			accounts[i][0] = (random.nextInt(305) + 10);
			accounts [i][1] = (random.nextInt(10001) + 1000);
		}
				
		for (int i = 0; i < transactions; i++) {
			int type = random.nextInt(2);
			int value = (random.nextInt(10001) + 100);
			Thread transaction = new Transaction(i, accounts[i][1], type, value);
			transaction.start();
		}
	}
}
