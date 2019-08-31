package view;

import javax.swing.JOptionPane;

import controller.Controls;

public class Main {

	public static void main(String[] args) {
		String process = "";
		Controls c = new Controls();
		String os = c.OperationalSystem();
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção desejada"
					+ "\n[1] Listar processos ativos"
					+ "\n[2] Matar um processo"
					+ "\n[9] Finalizar"));
			switch (op) {
			case 1:
				process = "tasklist";
				c.taskList(os);
				break;
			case 2:
				String victim;
				victim = JOptionPane.showInputDialog("Informe o nome do processo ou o PID");
				c.kill(os, victim);
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

