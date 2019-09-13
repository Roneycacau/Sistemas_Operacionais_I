package ex05.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonController implements ActionListener {

	private JButton btn;
	private JTextField txtjackpot;
	private JTextField txtcredit;
	private JTextField txtwin;
	private JTextField txtbetPrice;
	private JTextField slot1;
	private JTextField slot2;
	private JTextField slot3;

	SpinController sc = new SpinController(btn, txtjackpot, txtcredit, txtwin, txtbetPrice, slot1, slot2, slot3);

	public ButtonController(JButton btn) {

	}

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
