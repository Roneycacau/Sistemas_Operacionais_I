package ex01.view;

import ex01.controller.Thready;

public class Main {

	public static void main(String[] args) {
		
		for(int i = 0; i<5; i++) {
			Thread t = new Thready(i);
			t.start();
		}
	}

}
