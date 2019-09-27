package formula1.model;

import java.util.Random;

public class Car {
	
	private int number;
	private int speed;
	private Random r = new Random();
	
	public Car(int number, int speed) {
		this.number = number;
		this.speed = speed;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	
}
