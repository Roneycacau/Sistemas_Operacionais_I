package view;

import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class CruzamentoMain {

	public static void main(String[] args) {
		Semaphore farol = new Semaphore(1);
		
		for (int idCarro = 0; idCarro < 4; idCarro++) {
			Thread t = new Cruzamento(idCarro, farol);
			t.start();
		}
	}

}
