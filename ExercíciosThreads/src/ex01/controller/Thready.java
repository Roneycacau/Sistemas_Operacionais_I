package ex01.controller;

public class Thready extends Thread {
	
	private int n;
	
	public Thready(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		print();
	}
	
	private void print() {
		System.out.println("Thread => " + n);
	}

}
