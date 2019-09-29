package ex1.view;

import ex1.controller.ControlThread;

public class Principal {
	public static void main(String[] args) {

		ControlThread[] t = new ControlThread[20];
		for (int i = 0; i < 20; i++) {
			t[i] = new ControlThread();
			t[i].setName(i + "");
		}
		for(ControlThread go : t) {
			go.start();
		}

	}
}
