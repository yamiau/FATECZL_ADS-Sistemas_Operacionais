package view;

import java.security.SecureRandom;
import controller.LineThread;

public class Main {
	public static void main(String[] args) {
		int[][] matrix = new int[3][5];
		SecureRandom sr = new SecureRandom();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j]= sr.nextInt(100);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			Thread t = new LineThread(i,  matrix[i]);
			t.start();
		}
	}
}
