package ex05.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JTextField;

public class SpinThread extends Thread {

	private int i;
	private JButton btnSpin;
	private JButton btnAutoSpin;
	private JButton btnBet;
	private JButton btnMaxBet;
	private JButton btnSpin2win;
	private JTextField txtjackpot;
	private JTextField txtcredit;
	private JTextField txtwin;
	private JTextField txtbetPrice;
	private JTextField slot;
	
	
	private double betPrice;
	private double credit;
	private double win;
	private double jackpot;
	
	
	private String filename = "jackpot.txt";

	private static int count;
	private static int[] slots = new int[3];
	
	private Semaphore farol = new Semaphore(1);
	
	private Random r = new Random();
	
	
	public SpinThread(JButton btnSpin, JButton btnAutoSpin, JButton btnBet, JButton btnMaxBet,
			JButton btnSpin2win, JTextField txtjackpot, JTextField txtcredit, JTextField txtwin, JTextField txtbetPrice,JTextField slot, double jackpot) {
		this.btnSpin = btnSpin;
		this.btnAutoSpin = btnAutoSpin;
		this.btnBet = btnBet;
		this.btnMaxBet = btnMaxBet;
		this.btnSpin2win = btnSpin2win;
		this.txtjackpot = txtjackpot;
		this.txtcredit = txtcredit;
		this.txtwin = txtwin;
		this.txtbetPrice = txtbetPrice;
		this.slot = slot;
		this.jackpot = jackpot;
	}
	
		
	private void spinning() {
		
		
		while (count<4) {
			btnSpin.setEnabled(false);
			int spins = r.nextInt(10) + 1;
			for (int i = 0; i < spins; i++) {
				slot.setText((r.nextInt(2) + 1) + "");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("!! " + slot.getText() + " !!");
			slots[count] = Integer.parseInt(slot.getText());
			count++;
		}
		checkWin(slots);
		
	}
	
	
	
	private void writeJackpot() throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(Double.toString(jackpot));
		writer.close();
		txtjackpot.setText("");
		txtjackpot.setText(Double.toString(jackpot));
		System.out.println(txtjackpot.getText());
		btnSpin.setEnabled(true);
	}
	
	
	private void checkWin(int[] slots) {
//		int s1 = Integer.parseInt(slot1.getText());
//		int s2 = Integer.parseInt(slot2.getText());
//		int s3 = Integer.parseInt(slot3.getText());
		
		int s1 = slots[0];
		int s2 = slots[1];
		int s3 = slots[2];
		
		if(s1 == s2 && s2 == s3) {
			System.out.println("VENCEDOR!");
			prize(slots[0]);
		}
	}
	
	private void prize(int num) {
		switch (num) {
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


	@Override
	public void run() {
		spinning();
		try {
			farol.acquire();
			writeJackpot();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			farol.release();
		}
	}
}
