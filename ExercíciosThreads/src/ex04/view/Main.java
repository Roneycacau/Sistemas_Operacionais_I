package ex04.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ex04.controller.RaceController;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtWinner;
	private JTextField txtLoser;
	private JTextField racerName1;
	private JTextField racerName2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbCarro1 = new JLabel("");
		lbCarro1.setIcon(new ImageIcon(
				"C:\\Users\\roney\\OneDrive - Fatec Centro Paula Souza\\Faculdade\\SO I\\Sistemas_Operacionais_I\\ExercíciosThreads\\src\\ex04\\img\\sportscarIcon.gif"));
		lbCarro1.setBounds(0, 35, 192, 65);
		contentPane.add(lbCarro1);

		JLabel lbCarro2 = new JLabel("");
		lbCarro2.setIcon(new ImageIcon(
				"C:\\Users\\roney\\OneDrive - Fatec Centro Paula Souza\\Faculdade\\SO I\\Sistemas_Operacionais_I\\ExercíciosThreads\\src\\ex04\\img\\sportscar2Icon.gif"));
		lbCarro2.setBounds(0, 143, 192, 65);
		contentPane.add(lbCarro2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 111, 770, 9);
		contentPane.add(separator);

		JLabel lblWinner = new JLabel("Winner");
		lblWinner.setBounds(42, 264, 48, 14);
		contentPane.add(lblWinner);

		JLabel lblLoser = new JLabel("Loser");
		lblLoser.setBounds(42, 313, 48, 14);
		contentPane.add(lblLoser);

		txtWinner = new JTextField();
		txtWinner.setEnabled(false);
		txtWinner.setEditable(false);
		txtWinner.setBounds(96, 261, 96, 20);
		contentPane.add(txtWinner);
		txtWinner.setColumns(10);

		txtLoser = new JTextField();
		txtLoser.setEditable(false);
		txtLoser.setEnabled(false);
		txtLoser.setBounds(96, 310, 96, 20);
		contentPane.add(txtLoser);
		txtLoser.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(512, 265, 83, 309);
		contentPane.add(scrollPane);

		JTextArea txtAreaWin = new JTextArea();
		scrollPane.setViewportView(txtAreaWin);
		txtAreaWin.setEditable(false);
		txtAreaWin.setText("");

		JLabel lblWinnersList = new JLabel("Winners list");
		lblWinnersList.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnersList.setBounds(512, 240, 83, 14);
		contentPane.add(lblWinnersList);

		JButton btnGo = new JButton("GO");
		btnGo.setFont(new Font("Ink Free", Font.BOLD, 66));
		btnGo.setBounds(42, 418, 143, 117);
		contentPane.add(btnGo);

		JLabel labelLoserList = new JLabel("Loser list");
		labelLoserList.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoserList.setBounds(651, 240, 83, 14);
		contentPane.add(labelLoserList);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(651, 265, 83, 309);
		contentPane.add(scrollPane_1);

		JTextArea txtAreaLose = new JTextArea();
		scrollPane_1.setViewportView(txtAreaLose);
		txtAreaLose.setEditable(false);
		txtAreaLose.setText("");

		JLabel labelFinish = new JLabel("");
		labelFinish.setIcon(new ImageIcon(
				"C:\\Users\\roney\\OneDrive - Fatec Centro Paula Souza\\Faculdade\\SO I\\Sistemas_Operacionais_I\\ExercíciosThreads\\src\\ex04\\img\\Finish.png"));
		labelFinish.setBounds(749, 48, 10, 185);
		contentPane.add(labelFinish);

		racerName1 = new JTextField();
		racerName1.setText("Corredor1");
		racerName1.setBounds(0, 11, 96, 20);
		contentPane.add(racerName1);
		racerName1.setColumns(10);

		racerName2 = new JTextField();
		racerName2.setText("Corredor2");
		racerName2.setColumns(10);
		racerName2.setBounds(0, 111, 96, 20);
		contentPane.add(racerName2);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnReset.setBounds(42, 546, 143, 43);
		btnReset.setVisible(false);
		contentPane.add(btnReset);
		

		RaceController raceController = new RaceController(lbCarro1, lbCarro2, btnGo, txtWinner, txtLoser, txtAreaWin,
				txtAreaLose, labelFinish, racerName1, racerName2, btnReset);

		btnGo.addActionListener(raceController);
		btnReset.addActionListener(raceController);
	}
}
