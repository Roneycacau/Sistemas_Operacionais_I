package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {
	private String veioDe;
	private int idCarro;
	private Semaphore farol;
	private String vaiPra;
	private static int ordemPassagem;

	public Cruzamento(int idCarro, Semaphore farol) {
		this.idCarro = idCarro;
		this.farol = farol;
	}
	
	@Override
	public void run() {
		chegando();
		
		try {
			farol.acquire();
			cruzando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			farol.release();
		}
		
		indo();
	}
	
	private void indo() {
		System.out.println();
		System.out.println("O carro " + idCarro + " foi o " + ordemPassagem + "ª a passar e segue seu caminho");
		System.out.println(">>>>>>>>");
		System.out.println();
	}
	
	
	private void chegando() {
		switch (idCarro) {
		case 0:
			veioDe = "L";
			break;
		case 1:
			veioDe = "S";
			break;
		case 2:
			veioDe = "O";
			break;
		case 3:
			veioDe = "N";
			break;
		default:
			break;
		}
		
		
		System.out.println("^^ O carro " + idCarro + " está vindo de " + veioDe +" ^^");
	}
	
	private void cruzando() {
		ordemPassagem++;
		System.out.println("");
		System.out.println("O " + ordemPassagem + "º carro a atravessar vem de " + veioDe);
		System.out.println();
		int cruzando = (int)(Math.random()*501)+500;
		
		if(veioDe.equals("L")) {
			vaiPra = "O";
		}
		if(veioDe.equals("O")) {
			vaiPra = "L";
		}
		if(veioDe.equals("N")) {
			vaiPra = "S";
		}
		if(veioDe.equals("S")) {
			vaiPra = "N";
		}
		
		try {
			Thread.sleep(cruzando);
			for (int i = 0; i < 3; i++) {
			System.out.println("<< CARRO " + idCarro +  " passando >>");
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("!! Cruzamento completo, carro se encaminha para " + vaiPra + " !!");
		System.out.println();
	}
}
