package formula1.model;

import java.util.concurrent.Semaphore;

public class Team {
	
	private String name;
	private String color;
	private Pilot firstPilot;
	private Pilot secondPilot;
	
	Semaphore pilotInTrack;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Pilot getFirstPilot() {
		return firstPilot;
	}

	public void setFirstPilot(Pilot firstPilot) {
		this.firstPilot = firstPilot;
	}

	public Pilot getSecondPilot() {
		return secondPilot;
	}

	public void setSecondPilot(Pilot secondPilot) {
		this.secondPilot = secondPilot;
	}

	public Semaphore getPilotInTrack() {
		return pilotInTrack;
	}

	public void setPilotInTrack(Semaphore pilotInTrack) {
		this.pilotInTrack = pilotInTrack;
	}
	
	
	
}
