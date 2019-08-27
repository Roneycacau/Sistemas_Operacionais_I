package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController controller = new RedesController();
		String os = controller.OperationalSystem();
		
		System.out.println(os);
		
		controller.ip(os);
	}

}
