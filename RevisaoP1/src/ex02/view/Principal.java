package ex02.view;

import ex02.controller.ControllerThread;

public class Principal {
	public static void main(String[] args) {

		ControllerThread[] t = new ControllerThread[20];
		for (int i = 0; i < 20; i++) {
			t[i] = new ControllerThread();
			t[i].setName(i + "");
		}
		for(ControllerThread go : t) {
			go.start();
		}

	}
}
