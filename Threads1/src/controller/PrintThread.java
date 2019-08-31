package controller;

public class PrintThread extends Thread{
	
	private int n;
	
	public PrintThread(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		System.out.println(n);
	}
}
