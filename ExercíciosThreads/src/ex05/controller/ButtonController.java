package ex05.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonController implements ActionListener {

	private JButton btn;
	
//	private JButton btnSpin;
//	private JButton btnAutoSpin;
//	private JButton btnBet;
//	private JButton btnMaxBet;
//	private JButton btnSpin2win;
	
	private JTextField txtjackpot;
	private JTextField txtcredit;
	private JTextField txtwin;
	private JTextField txtbetPrice;
	private JTextField slot1;
	private JTextField slot2;
	private JTextField slot3;

	
	
//	public ButtonController(JButton btn, JTextField txtjackpot, JTextField txtcredit, JTextField txtwin,
//			JTextField txtbetPrice, JTextField slot1, JTextField slot2, JTextField slot3) {
//		
//		this.btn = btn;
//		this.btnSpin = btnSpin;
//		this.btnAutoSpin = btnAutoSpin;
//		this.btnBet = btnBet;
//		this.btnMaxBet = btnMaxBet;
//		this.btnSpin2win = btnSpin2win;
//		this.txtjackpot = txtjackpot;
//		this.txtcredit = txtcredit;
//		this.txtwin = txtwin;
//		this.txtbetPrice = txtbetPrice;
//		this.slot1 = slot1;
//		this.slot2 = slot2;
//		this.slot3 = slot3;
//	}
	
	public ButtonController(JButton btn, JTextField txtjackpot, JTextField txtcredit, JTextField txtwin,
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


	SpinController sc = new SpinController(btn, txtjackpot, txtcredit, txtwin, txtbetPrice, slot1, slot2, slot3);

	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (btn.getText().equalsIgnoreCase("spin")) {
			sc.spin();
		}
		if (btn.getText().equalsIgnoreCase("Bet")) {
			sc.bet();
		}
		if(btn.getText().equalsIgnoreCase("max bet")) {
			sc.maxBet();
		}
		if(btn.getText().equalsIgnoreCase("autoSpin")) {
			sc.autoSpin();
		}
		if(btn.getText().equalsIgnoreCase("spin2Win")) {
			sc.spin2Win();
		}

	}

}
