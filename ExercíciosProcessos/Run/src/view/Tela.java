package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfPath;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfPath = new JTextField();
		tfPath.setBounds(10, 50, 364, 20);
		contentPane.add(tfPath);
		tfPath.setColumns(10);

		JLabel lblDigiteOCaminho = new JLabel("Digite o caminho do executável ou clique em procurar");
		lblDigiteOCaminho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteOCaminho.setBounds(59, 11, 301, 28);
		contentPane.add(lblDigiteOCaminho);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(38, 81, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(149, 81, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(264, 81, 89, 23);
		contentPane.add(btnProcurar);
		lblNewLabel.setBounds(10, -12, 51, 65);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\roney\\OneDrive - Fatec Centro Paula Souza\\Faculdade\\SO I\\Sistemas_Operacionais_I\\ExercíciosProcessos\\Run\\src\\view\\Webp.net-resizeimage.png"));

		
		ActionListener open = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
				
			}
		};
		ActionListener search = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchFile();
			}
		};
		ActionListener cancel = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelRun();
			}
		};

		btnProcurar.addActionListener(search);
		btnOk.addActionListener(open);
		tfPath.addActionListener(open);
		btnCancelar.addActionListener(cancel);
		
		
//		if(tfPath.getText().isEmpty()) {
//			tfPath.addActionListener(search);
//		}

	}
	public void cancelRun() {
		dispose();
	}
	public void openFile() {
		if (!tfPath.getText().isEmpty()) {
			try {
				Process p = Runtime.getRuntime().exec(tfPath.getText());

			} catch (Exception e) {
				// e.printStackTrace();
				if (e.getMessage().contains("740")) {
					StringBuffer buffer = new StringBuffer();
					buffer.append("cmd /c");
					buffer.append(" ");
					buffer.append(tfPath.getText());
					try {
						Runtime.getRuntime().exec(buffer.toString());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					e.printStackTrace();
				}
			} 
		}else {
			searchFile();
		}
		dispose();
	}

	public void searchFile() {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "exe");
			String homeDirectory = System.getProperty("user.home")+"'\'Desktop";
			File dir = new File(homeDirectory);
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(dir);
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setAcceptAllFileFilterUsed(true);
			chooser.addChoosableFileFilter(filter);
			String filePath = "";
				
			int retorn = chooser.showOpenDialog(null);
			if(retorn == JFileChooser.APPROVE_OPTION) {
				filePath = chooser.getSelectedFile().getAbsolutePath();
				tfPath.setText(filePath);
		}
		
	}
}
