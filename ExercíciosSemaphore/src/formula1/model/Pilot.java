package formula1.model;

import java.util.Random;

public class Pilot {
	private Random r = new Random();
	private String name;
	private int skill;
	private Car car = new Car(r.nextInt(100)+1, r.nextInt(20));
	private Team team = new Team();
	
	
	
	
	public Pilot(String name, int skill) {
		this.name = name;
		this.skill = skill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	public void finalSpeed() {
		int speed = car.getSpeed()*this.getSkill();
	}
	
	
}
