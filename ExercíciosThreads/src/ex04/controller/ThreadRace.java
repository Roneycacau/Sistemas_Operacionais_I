package ex04.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ThreadRace extends Thread{

	private JLabel lbCarro;
	private JButton btnGo;
	private JTextField txtWinner;
	private JTextField txtLoser;
	private JTextArea txtAreaWin;
	private JTextArea txtAreaLose;
	private JLabel labelFinish;
	private JTextField racerName;
	private JButton btnReset;
	
	private String winner;
	private String loser;
	private boolean checkWinner = false;
	private Random r = new Random();
	
	
	
	
	public ThreadRace(JLabel lbCarro, JButton btnGo, JTextField txtWinner, JTextField txtLoser, JTextArea txtAreaWin,
			JTextArea txtAreaLose, JLabel labelFinish, JTextField racerName, JButton btnReset) {
		
		this.lbCarro = lbCarro;
		this.btnGo = btnGo;
		this.txtWinner = txtWinner;
		this.txtLoser = txtLoser;
		this.txtAreaWin = txtAreaWin;
		this.txtAreaLose = txtAreaLose;
		this.labelFinish = labelFinish;
		this.racerName = racerName;
		this.btnReset = btnReset;
	}
	
	private void result() {
		if(checkWinner) {
			
		}
		if(txtWinner.getText().isEmpty()) {
			txtWinner.setText(winner);
		}
		
		
	}
	
	private void race() {
		btnGo.setVisible(false);
		Rectangle position = lbCarro.getBounds();
		Rectangle finish = labelFinish.getBounds();
		while(!checkWinner) {
			do{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int thrust = r.nextInt(50);
				position.x += thrust;
				System.out.println(racerName.getText() + "=>" + position.x + "\n ==" + finish.x + "==");
				lbCarro.setBounds(position);
			}while(position.x < finish.x);
			checkWinner = true;
		}
		winner = racerName.getText();
		
		btnReset.setVisible(true);

	}
	
	private void raceLog() {
		
	}
	

	@Override
	public void run() {
		race();
		result();
		if(checkWinner) {
			interrupt();
		}
	}
}
