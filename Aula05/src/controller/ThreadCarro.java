package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	
	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroEstacionado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		carroSaindo();
	}
	
	private void carroAndando() {
		int distanciaFinal = (int)(Math.random()*1001) + 1000;
		int distanciaPercorrida = 0;
		int variacaoDistancia = 100;
		int tempo = 100;
		
		while(distanciaPercorrida < distanciaFinal) {
			distanciaPercorrida += variacaoDistancia;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Carro #" + idCarro + " percorreu " + distanciaPercorrida + " m.");
		}
		posChegada++;
		System.out.println("Carro #" + idCarro + " foi o " + posChegada + "º a chegar");
	}
	
	private void carroEstacionado() {
		System.out.println("Carro #" + idCarro + " entrou");
		
		int tempoParado = (int)(Math.random()*501)+500;
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void carroSaindo() {
		posSaida++;
		System.out.println("Carro #" + idCarro + "foi o " + posSaida + "º a sair");
	}
	
}
