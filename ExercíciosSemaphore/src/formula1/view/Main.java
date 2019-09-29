package formula1.view;

import formula1.controller.TrackController;
import formula1.model.Pilot;

public class Main {
	private int[] numbers = new int[14];
	private String[] teams = new String[7];
	
	public static void main(String[] args) {
//		Pilot pilot = new Pilot("test", 2);
//		System.out.println(pilot.getName() + "\n" + pilot.getCar().toString());
		Thread t = new TrackController();
		t.start();
		
	}
}
