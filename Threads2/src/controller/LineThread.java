package controller;

public class LineThread extends Thread{
	
	private int i;
	private int rowSum;
	
	public LineThread(int i, int[] row) {
		this.i = i;
		for(int x : row) {
			this.rowSum += x;
		}
	}
	
	@Override
	public void run() {
		showThread();
	}
	
	private void showThread() {
		System.out.println("Row " + i + ". Sum = " + rowSum);
	}
}
