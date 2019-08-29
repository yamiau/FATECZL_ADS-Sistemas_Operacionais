package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskLister {
	public void list(String os) {
		if (os.toLowerCase().contains("win")) {
			try {
				Process proc = Runtime.getRuntime().exec("tasklist /fo table");
				InputStream is = proc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
			} catch (IOException ew) {
				ew.printStackTrace();
			}
		} else {
			try {
				Process proc = Runtime.getRuntime().exec("top");
				InputStream is = proc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
			} catch (IOException el) {
				el.printStackTrace();
			}
		}
	}
}
