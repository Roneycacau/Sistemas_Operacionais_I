package ex05.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ex05.controller.SpinController;

public class SlotMachine extends JFrame {

	private JPanel contentPane;
	private JTextField slot1;
	private JTextField slot2;
	private JTextField slot3;
	private JTextField txtbetPrice;
	private JTextField txtjackpot;
	private JLabel lbJackpot;
	private JButton btnBet;
	private JLabel lbcredit;
	private JTextField txtcredit;
	private JButton btnAutoSpin;
	private JTextField txtwin;
	private JLabel lbWin;
	private JButton btnMaxBet;
	private JButton btnSpin2win;
	private String filename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotMachine frame = new SlotMachine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public SlotMachine() throws IOException {

		filename = "jackpot.txt";
		String row;
		try {
			BufferedReader read = new BufferedReader(new FileReader(filename));
			row = read.readLine();
			System.out.println(row + "\nVVV");
			read.close();
		} catch (Exception e) {
			row = "1000";
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		slot1 = new JTextField();
		slot1.setForeground(Color.RED);
		slot1.setHorizontalAlignment(SwingConstants.CENTER);
		slot1.setFont(new Font("Algerian", Font.PLAIN, 90));
		slot1.setEditable(false);
		slot1.setBounds(3, 143, 103, 103);
		contentPane.add(slot1);
		slot1.setColumns(10);

		slot2 = new JTextField();
		slot2.setFont(new Font("Algerian", Font.PLAIN, 90));
		slot2.setForeground(Color.RED);
		slot2.setEditable(false);
		slot2.setColumns(10);
		slot2.setBounds(120, 143, 103, 103);
		contentPane.add(slot2);

		slot3 = new JTextField();
		slot3.setFont(new Font("Algerian", Font.PLAIN, 90));
		slot3.setForeground(Color.RED);
		slot3.setEditable(false);
		slot3.setColumns(10);
		slot3.setBounds(236, 143, 103, 103);
		contentPane.add(slot3);

		JButton btnSpin = new JButton("SPIN");
		btnSpin.setFont(new Font("Impact", Font.PLAIN, 70));
		btnSpin.setIcon(null);
		btnSpin.setBounds(349, 134, 166, 127);
		contentPane.add(btnSpin);

		txtbetPrice = new JTextField();
		txtbetPrice.setForeground(Color.GRAY);
		txtbetPrice.setText("0.25");
		txtbetPrice.setFont(new Font("Impact", Font.PLAIN, 34));
		txtbetPrice.setEditable(false);
		txtbetPrice.setBounds(3, 63, 69, 51);
		contentPane.add(txtbetPrice);
		txtbetPrice.setColumns(10);

		JLabel lbPrice = new JLabel("Price");
		lbPrice.setForeground(Color.DARK_GRAY);
		lbPrice.setFont(new Font("Impact", Font.PLAIN, 30));
		lbPrice.setBounds(3, 28, 64, 26);
		contentPane.add(lbPrice);

		txtjackpot = new JTextField();
		txtjackpot.setHorizontalAlignment(SwingConstants.TRAILING);
		txtjackpot.setEditable(false);
		txtjackpot.setFont(new Font("Impact", Font.PLAIN, 49));
		txtjackpot.setBounds(220, 23, 285, 56);
		contentPane.add(txtjackpot);
		txtjackpot.setColumns(10);
		txtjackpot.setText("");
		txtjackpot.setText(row);

		lbJackpot = new JLabel("Jackpot");
		lbJackpot.setFont(new Font("Impact", Font.PLAIN, 40));
		lbJackpot.setBounds(86, 23, 132, 40);
		contentPane.add(lbJackpot);

		btnBet = new JButton("BET");
		btnBet.setFont(new Font("Impact", Font.PLAIN, 29));
		btnBet.setBounds(10, 269, 76, 76);
		contentPane.add(btnBet);

		lbcredit = new JLabel("CREDIT");
		lbcredit.setFont(new Font("Impact", Font.PLAIN, 15));
		lbcredit.setBounds(191, 289, 48, 14);
		contentPane.add(lbcredit);

		txtcredit = new JTextField();
		txtcredit.setEditable(false);
		txtcredit.setFont(new Font("Impact", Font.PLAIN, 15));
		txtcredit.setBounds(243, 286, 96, 20);
		contentPane.add(txtcredit);
		txtcredit.setColumns(10);
		txtcredit.setText("0.25");

		btnAutoSpin = new JButton("AutoSpin");
		btnAutoSpin.setFont(new Font("Impact", Font.PLAIN, 26));
		btnAutoSpin.setBounds(356, 266, 156, 40);
		contentPane.add(btnAutoSpin);

		txtwin = new JTextField();
		txtwin.setText("0");
		txtwin.setFont(new Font("Impact", Font.PLAIN, 15));
		txtwin.setEditable(false);
		txtwin.setColumns(10);
		txtwin.setBounds(243, 317, 96, 20);
		contentPane.add(txtwin);

		lbWin = new JLabel("WIN");
		lbWin.setFont(new Font("Impact", Font.PLAIN, 15));
		lbWin.setBounds(205, 320, 38, 14);
		contentPane.add(lbWin);

		btnMaxBet = new JButton("MAX\r\n BET");
		btnMaxBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMaxBet.setFont(new Font("Impact", Font.PLAIN, 20));
		btnMaxBet.setBounds(0, 354, 106, 35);
		contentPane.add(btnMaxBet);

		btnSpin2win = new JButton("Spin2Win");
		btnSpin2win.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSpin2win.setFont(new Font("Impact", Font.PLAIN, 25));
		btnSpin2win.setBounds(359, 322, 156, 67);
		contentPane.add(btnSpin2win);

		SpinController spin = new SpinController(btnSpin, btnAutoSpin, btnBet, btnMaxBet, btnSpin2win, txtjackpot,
				txtcredit, txtwin, txtbetPrice, slot1, slot2, slot3);
		btnSpin.addActionListener(spin);
		btnBet.addActionListener(spin);

	}
}
