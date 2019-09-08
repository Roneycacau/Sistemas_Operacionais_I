package ex04.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RaceController implements ActionListener{
	private JLabel lbCarro1;
	private JLabel lbCarro2;
	private JButton btnGo;
	private JTextField txtWinner;
	private JTextField txtLoser;
	private JTextArea txtAreaWin;
	private JTextArea txtAreaLose;
	private JLabel labelFinish;
	private JTextField racerName1;
	private JTextField racerName2;
	private JButton btnReset;
	

	public RaceController(JLabel lbCarro1, JLabel lbCarro2, JButton btnGo, JTextField txtWinner, JTextField txtLoser,
			JTextArea txtAreaWin, JTextArea txtAreaLose, JLabel labelFinish, JTextField racerName1, JTextField racerName2, JButton btnReset) {
		this.lbCarro1 = lbCarro1;
		this.lbCarro2 = lbCarro2;
		this.btnGo = btnGo;
		this.txtWinner = txtWinner;
		this.txtLoser = txtLoser;
		this.txtAreaWin = txtAreaWin;
		this.txtAreaLose = txtAreaLose;
		this.labelFinish = labelFinish;
		this.racerName1 = racerName1;
		this.racerName2 = racerName2;
		this.btnReset = btnReset;
	}
	

	private void startRace() {
		if(!racerName1.getText().isEmpty()) {
			if(!racerName2.getText().isEmpty()) {
				Thread t1 = new ThreadRace(lbCarro1, btnGo, txtWinner, txtLoser, txtAreaWin, txtAreaLose, labelFinish, racerName1,btnReset);
				Thread t2 = new ThreadRace(lbCarro2, btnGo, txtWinner, txtLoser, txtAreaWin, txtAreaLose, labelFinish, racerName2,btnReset);
				t1.start();
				t2.start();
			}else {
				JOptionPane.showMessageDialog(null, "Digite o Nome do Corredor 2","Erro", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Corredor 1","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void resetRace() {
		lbCarro1.setBounds(0, 35, 192, 65);
		lbCarro2.setBounds(0, 143, 192, 65);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		startRace();
		resetRace();
	}
}
