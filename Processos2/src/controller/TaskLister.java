package controller;

import java.io.IOException;

public class TaskLister {
	public void list(String os) {
		if (os.toLowerCase().contains("win")) {
			try {
				Runtime.getRuntime().exec("TASKLIST /FO TABLE");				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("");				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
