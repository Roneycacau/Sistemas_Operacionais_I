package formula1.controller;

import java.util.Random;

public class TrackController extends Thread {
	Random r = new Random();
	private int trackLenght = 2000;
	private int totalLaps = 3;
	private long start;
	private long end;
	private int sector1;
	private int sector2;
	private int sector3;
	
	
	public void race() {
		start = System.nanoTime();
		int laps = 0;
		int running = 0;
		int carSpeed = r.nextInt(170)+50;
		int pilotSkill = r.nextInt(10)+1;
		int raceSpeed = carSpeed - pilotSkill; 
		while(running < (trackLenght*totalLaps)) {
			try {
				Thread.sleep((200/raceSpeed));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			running ++;
			System.out.println("O Carro percorreu " + running);
			if(running% trackLenght == 0) {
				laps++;
				System.err.println(laps + "ª volta completada");
			}
		}
		
	}
	
	@Override
	public void run() {
		race();
	}
}
