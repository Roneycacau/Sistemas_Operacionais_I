package controller;

public class OperacoesController {

	public OperacoesController() {
		super();
	}

	public void concatenarString() {
		String palavra = "";

		double tempoInicial = System.nanoTime();

		for (int i = 0; i < 32768; i++)
			palavra += "a";

		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;

		tempoTotal = tempoTotal / Math.pow(10, 9);

		System.out.println("Com String => " + tempoTotal + " segundos");
	}

	public void concatenarBuffer() {
		StringBuilder buffer = new StringBuilder();

		double tempoInicial = System.nanoTime();

		for (int i = 0; i < 32768; i++)
			buffer.append("a");

		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;

		tempoTotal = tempoTotal / Math.pow(10, 9);

		System.out.println("Com Buffer => " + tempoTotal + " segundos");
	}

	public void quebrarFrase(String frase) {
		String[] palavras = frase.split(" ");

		for (String palavra : palavras)
			System.out.println(palavra);
	}

}
