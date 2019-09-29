package ex1.controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ControlThread extends Thread {

	private Semaphore farol = new Semaphore(1);
	private Random r = new Random();

	private int tempo;
	private int nome;
	private static int chegada;
	private static int saida;
	
	void rodar() {
		nome = Integer.parseInt(currentThread().getName());		
		tempo = (r.nextInt(116) + 4)*1000;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chegada++;
		System.out.format("== Processo %2d# chegou no SLEEP na posição: " + chegada + " ==\n", (int)nome);
//		System.out.format("== Processo %2d# chegou no SLEEP com o tempo: " + tempo/1000 + " ==\n", (int)nome);
	}

	void sair() {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saida++;
		System.out.format("O processo %2d# foi o " + saida + "º a sair\n", nome);
	}

	@Override
	public void run() {
		rodar();
		try {
			farol.acquire(1);
			sair();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			farol.release();
		}

	}
}
