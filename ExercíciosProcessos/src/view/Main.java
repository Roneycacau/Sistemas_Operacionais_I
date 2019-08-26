package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController controle = new RedesController();
		String so = controle.OperationalSystem();
		
		System.out.println(so);
		
		controle.ip(so);
	}

}
