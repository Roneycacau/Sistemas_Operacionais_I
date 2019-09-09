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
	
		
	private int spinning() {
		
		
		btnSpin.setEnabled(false);
		int spins = r.nextInt(10)+1;
		for(int i = 0; i<spins;i++) {
			slot.setText((r.nextInt(2)+1) + "");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("!! " + slot.getText() + " !!");
		return Integer.parseInt(slot.getText());
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
