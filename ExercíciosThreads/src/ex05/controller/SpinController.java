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

	private JButton btn;
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

	public SpinController(JButton btn, JTextField txtjackpot, JTextField txtcredit, JTextField txtwin,
			JTextField txtbetPrice, JTextField slot1, JTextField slot2, JTextField slot3) {
		this.btn = btn;
		this.txtjackpot = txtjackpot;
		this.txtcredit = txtcredit;
		this.txtwin = txtwin;
		this.txtbetPrice = txtbetPrice;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
	}

	public void spin() {
		if (!txtcredit.getText().isEmpty() || txtcredit.getText().equals("0")) {

			betPrice = Double.parseDouble(txtbetPrice.getText());

			credit = Double.parseDouble(txtcredit.getText());

			jackpot = Double.parseDouble(txtjackpot.getText());
			jackpot += betPrice;

			credit -= betPrice;
			txtcredit.setText(Double.toString(credit));

			Thread t1 = new SpinThread(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot, txtcredit,
					txtwin, txtbetPrice, slot1, jackpot);
			Thread t2 = new SpinThread(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot, txtcredit,
					txtwin, txtbetPrice, slot2, jackpot);
			Thread t3 = new SpinThread(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot, txtcredit,
					txtwin, txtbetPrice, slot3, jackpot);
			t1.start();
			t2.start();
			t3.start();
			System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVV");

		} else {
			JOptionPane.showMessageDialog(null,
					"Adicione Créditos clicando em BET para adicionar o valor mínimo ou MAX BET para adicionar o valor máximo",
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void bet() {
		credit += betPrice;
		txtcredit.setText(txtbetPrice.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		ButtonController btn = new ButtonController(btnSpin, btnBet, btnMaxBet, btnAutoSpin,btnSpin2win);
	}

	public void maxBet() {
		// TODO Auto-generated method stub

	}

	public void spin2Win() {
		// TODO Auto-generated method stub

	}

	public void autoSpin() {
		// TODO Auto-generated method stub

	}

}
