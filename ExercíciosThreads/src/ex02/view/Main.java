package ex02.view;

import ex02.controller.Matrix;

public class Main {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			Thread t = new Matrix(i);
			t.start();
		}
		
	}

}
