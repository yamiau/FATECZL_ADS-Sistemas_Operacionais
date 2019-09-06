package controller;

public class Race {
	private double length;
	private double unit;
	private Boolean winner = false;
	
	public double getLength() {
		return length;
	}
	
	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public void setWinner() {
		if (this.winner == false) {
			this.winner = true;
		}
	}
	
	public Boolean getWinner() {
		return this.winner;
	}
}
