package controller;

public class OSFinder {
	public String getOS() {
		return(System.getProperty("os.name"));
	}
}
