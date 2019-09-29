package ex02.controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ControllerThread extends Thread {

	private Semaphore farol = new Semaphore(1);
	private Random r = new Random();

	private int tempo;
	private int nome;

	void rodar() {
		nome = Integer.parseInt(currentThread().getName());
		tempo = (r.nextInt(116) + 4)*1000;
		System.out.format("== Processo %2d# chegou no SLEEP com o tempo: " + tempo/1000 + " ==\n", (int)nome);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void sair() {
		System.out.format("O processo %2d# saiu\n", nome);
	}

	@Override
	public void run() {
		rodar();
		try {
			farol.acquire();
			sair();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			farol.release();
		}

	}
}
