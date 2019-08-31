package view;

import controller.ThreadSeq;
import java.util.Random;

public class Main {
	static Random r = new Random();
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			Thread t = new ThreadSeq(r.nextInt(1000000001) + 1000000000, i);
			t.start();
		}
	}

}
