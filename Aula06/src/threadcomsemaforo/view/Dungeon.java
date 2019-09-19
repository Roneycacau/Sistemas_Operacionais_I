package threadcomsemaforo.view;

import javax.swing.JOptionPane;

import threadcomsemaforo.controller.ThreadDungeon;

public class Dungeon {

//	private static boolean torch = true;
//	private static boolean stone = true;
	
	public static void main(String[] args) {
		
		String t1Name;
		String t2Name;

		t1Name = JOptionPane.showInputDialog("Informe o nome do Cavaleiro 1");
		t2Name = JOptionPane.showInputDialog("Informe o nome do Cavaleiro 2");
		
		Thread t1 = new ThreadDungeon(t1Name);
		Thread t2 = new ThreadDungeon(t2Name);
		t1.setName(t1Name);
		t2.setName(t2Name);
		t1.start();
		t2.start();
		
	}

}
