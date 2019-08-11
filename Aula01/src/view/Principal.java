package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {
		OperacoesController operacoes = new OperacoesController();

		operacoes.concatenarString();
		operacoes.concatenarBuffer();

		String frase = "Hoje está muito quente e eu não gosto disso";

		operacoes.quebrarFrase(frase);
	}

}
