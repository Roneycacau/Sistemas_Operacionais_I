package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController controller = new RedesController();
		String os = controller.OperationalSystem();
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Escolhe ai!"
					+ "\n[1] Ver adaptadores de rede e IPv4"
					+ "\n[2] Calcular a latência da rede"
					+ "\n[9] Finalizar"));
			switch(op) {
			case 1:
				controller.ip(os);
				break;
			case 2: 
				controller.ping(os);
				break;
			case 9: 
				System.out.println("Tchau o/");
				break;
			default:
				System.out.println("ERROU!");
			}
			
		}while(op!=9);
	}

}
