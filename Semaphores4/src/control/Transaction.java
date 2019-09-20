package control;

import java.util.concurrent.Semaphore;

public class Transaction extends Thread{

	private int code;
	private int balance;
	private int type;
	private int value;
	private static Semaphore[] semaphore = new Semaphore[2]; {
		for (Semaphore s : semaphore) {
			s = new Semaphore(1);
		}
	}
		
	public Transaction(int code, int balance, int type, int value) {
		this.code = code;
		this.balance = balance;
		this.type = type + 1;
		this.value = value;
	}
	
	@Override
	public void run() {
		try {
			semaphore[type -1].acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			transact();
			semaphore[type -1].release();
		}	
	}
	
	private void transact() {
		switch(type) {
		case 1: 
			System.out.println("Account num" + code + " | Deposit of $" + value + " realized"  
					+ ":\n Previous balance: $" + balance
					+ ".\n Current balance: $" + (balance + value) + ".");
			balance += value;
			break;
		case 2:
			if ( (balance - value) < 0 ) {
				System.out.println("Account num" + code 
						+ " | Not enough money available for withdraw"
						+ ":\n Current balance: $" + balance
						+ ".\n Requested withdrawal value: $" + value
						+ ".\n Operation cancelled.");
			} else {
				System.out.println("Account num" + code + " | Withdrawal of $" + value + " realized"  
						+ ":\n Previous balance: $" + balance
						+ ".\n Current balance: $" + (balance - value) + ".");
				balance -= value;				
			}
			break;
		}
	}
}
