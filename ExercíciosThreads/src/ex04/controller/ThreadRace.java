package ex04.controller;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThreadRace extends Thread {

	private JLabel lbCarro;
	private JButton btnGo;
	private JTextField txtWinner;
	private JTextField txtLoser;
	private JTextArea txtAreaWin;
	private JTextArea txtAreaLose;
	private JLabel labelFinish;
	private JTextField racerName;
	private JButton btnReset;
	
	private Thread t;

	private String winner;
	private String loser;
	private Semaphore semaphore = new Semaphore(1);
	
	private Random r = new Random();
	private boolean checkWinner = false;

	public ThreadRace(JLabel lbCarro, JButton btnGo, JTextField txtWinner, JTextField txtLoser, JTextArea txtAreaWin,
			JTextArea txtAreaLose, JLabel labelFinish, JTextField racerName, JButton btnReset, Thread t) {

		this.lbCarro = lbCarro;
		this.btnGo = btnGo;
		this.txtWinner = txtWinner;
		this.txtLoser = txtLoser;
		this.txtAreaWin = txtAreaWin;
		this.txtAreaLose = txtAreaLose;
		this.labelFinish = labelFinish;
		this.racerName = racerName;
		this.btnReset = btnReset;
		this.t = t;
	}

	private void result() {
		winner = racerName.getText();
		if (txtWinner.getText().isEmpty()) {
			winner = racerName.getText();
			txtWinner.setText(winner);
		}else {
			loser = racerName.getText();
			txtLoser.setText(loser);
		}

	}

	private void race() {
		btnGo.setVisible(false);
		racerName.setEditable(false);
		Rectangle position = lbCarro.getBounds();
		Rectangle finish = labelFinish.getBounds();
		while (position.x < finish.x) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int thrust = r.nextInt(50);
				position.x += thrust;
				System.out.println(racerName.getText() + "=>" + position.x + "\n ==" + finish.x + "==");
				lbCarro.setBounds(position);
		}
		checkWinner = true;
		racerName.setEditable(true);
		btnReset.setVisible(true);
	}

	private void raceLog() {
		if(!txtWinner.getText().isEmpty()) {
		}
		if(!txtLoser.getText().isEmpty()) {
			txtAreaWin.setText(txtAreaWin.getText() + "\n" + txtWinner.getText());
			txtAreaLose.setText(txtAreaLose.getText() + "\n" +txtLoser.getText());
		}
	}

	@Override
	public void run() {
		race();
		try {
			semaphore.acquire();
			result();
			raceLog();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaphore.release();
		}

	}
}
