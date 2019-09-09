package ex05.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SpinController implements ActionListener {

	private JButton btnSpin;
	private JButton btnAutoSpin;
	private JButton btnBet;
	private JButton btnMaxBet;
	private JButton btnSpin2win;
	private JTextField txtjackpot;
	private JTextField txtcredit;
	private JTextField txtwin;
	private JTextField txtbetPrice;
	private JTextField slot1;
	private JTextField slot2;
	private JTextField slot3;
	
	private double betPrice;
	private double credit;
	private double win;
	private double jackpot;
	
	private String filename = "jackpot.txt";
	

	public SpinController(JButton btnSpin, JButton btnAutoSpin, JButton btnBet, JButton btnMaxBet, JButton btnSpin2win,
			JTextField txtjackpot, JTextField txtcredit, JTextField txtwin, JTextField txtbetPrice, JTextField slot1,
			JTextField slot2, JTextField slot3) {
		this.btnSpin = btnSpin;
		this.btnAutoSpin = btnAutoSpin;
		this.btnBet = btnBet;
		this.btnMaxBet = btnMaxBet;
		this.btnSpin2win = btnSpin2win;
		this.txtjackpot = txtjackpot;
		this.txtcredit = txtcredit;
		this.txtwin = txtwin;
		this.txtbetPrice = txtbetPrice;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
	}

	
	private void spin() {
		if (!txtcredit.getText().isEmpty() || txtcredit.getText().equals("0")) {
			
			betPrice = Double.parseDouble(txtbetPrice.getText());
			
			credit = Double.parseDouble(txtcredit.getText());
			
			jackpot = Double.parseDouble(txtjackpot.getText());
			jackpot += betPrice;

			credit -= betPrice;
			txtcredit.setText(Double.toString(credit));
			
			Thread t1 = new SpinThread(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot, txtcredit,
					txtwin, txtbetPrice, slot1,jackpot);
			Thread t2 = new SpinThread(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot, txtcredit,
					txtwin, txtbetPrice, slot2,jackpot);
			Thread t3 = new SpinThread(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot, txtcredit,
					txtwin, txtbetPrice, slot3,jackpot);
			t1.start();
			t2.start();
			t3.start();
			System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVV");
			checkWin(slot1, slot2, slot3);
			
		} else {
			JOptionPane.showMessageDialog(null,
					"Adicione Créditos clicando em BET para adicionar o valor mínimo ou MAX BET para adicionar o valor máximo",
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void checkWin(JTextField slot1, JTextField slot2, JTextField slot3) {
		int s1 = Integer.parseInt(slot1.getText());
		int s2 = Integer.parseInt(slot2.getText());
		int s3 = Integer.parseInt(slot3.getText());
		
		if(s1 == s2 && s2 == s3) {
			System.out.println("VENCEDOR!");
			prize(slot1);
		}
	}

	private void prize(JTextField slot1) {
		switch (Integer.parseInt(slot1.getText())) {
		case 1:
			win = 1;
			break;
		case 2:
			win = 10;
			jackpot -= win;
			break;
		case 3:
			win = 50;
			break;
		case 4:
			win = 100;
			break;
		case 5:
			win = 250;
			break;
		case 6:
			win = 500;
			break;
		case 7:
			win = jackpot;
			break;
		default:
			break;
		}
		System.out.println("selecionado valor do premio: " + win);
		pay(win);
	}

	private void pay(double win2) {
		jackpot -= win;
		System.out.println("descontado valor do premio do jackpot> " + jackpot);
		credit += win;
		System.out.println("adicionado valor do premio em creditos: " + credit);
		txtcredit.setText(credit + "");
		register(jackpot, win, credit);
	}


	private void register(double jackpot2, double win2, double credit2) {
		System.out.println("~~~~~~" + jackpot2 + "~~~~~~");
	}
	
	private void writeJackpot() throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(Double.toString(jackpot));
		writer.close();
		txtjackpot.setText("");
		txtjackpot.setText(Double.toString(jackpot));
		System.out.println("====");
		System.out.println(txtjackpot.getText());
		
	}


	private void bet() {
		credit += betPrice;
		txtcredit.setText(txtbetPrice.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		spin();
	}

}
