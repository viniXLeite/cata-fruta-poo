package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class barraLateral {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barraLateral window = new barraLateral();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public barraLateral() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setResizable(false);
		frame.setBounds(100, 100, 415, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jogador 1:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 119, 204, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblJogador = new JLabel("Jogador 2:");
		lblJogador.setFont(new Font("Verdana", Font.BOLD, 25));
		lblJogador.setBounds(10, 343, 204, 68);
		frame.getContentPane().add(lblJogador);
		
		JLabel lblDado = new JLabel("Dado:");
		lblDado.setFont(new Font("Verdana", Font.BOLD, 20));
		lblDado.setBounds(143, 572, 84, 61);
		frame.getContentPane().add(lblDado);
		
		JButton btnNewButton = new JButton("Rolar ");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(115, 626, 174, 47);
		frame.getContentPane().add(btnNewButton);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(75, 197, 0, 40);
		frame.getContentPane().add(formattedTextField);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(100, 204, 34, 22);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblMaracuj = new JLabel("Maracujá:");
		lblMaracuj.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMaracuj.setBounds(275, 173, 84, 83);
		frame.getContentPane().add(lblMaracuj);
		
		JLabel lblLaranja = new JLabel("Laranja:");
		lblLaranja.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja.setBounds(144, 191, 72, 47);
		frame.getContentPane().add(lblLaranja);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setEditable(false);
		textArea_1_1.setBounds(229, 204, 34, 22);
		frame.getContentPane().add(textArea_1_1);
		
		JTextArea textArea_1_1_1 = new JTextArea();
		textArea_1_1_1.setEditable(false);
		textArea_1_1_1.setBounds(229, 246, 34, 22);
		frame.getContentPane().add(textArea_1_1_1);
		
		JTextArea textArea_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1.setEditable(false);
		textArea_1_1_1_1.setBounds(100, 246, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1.setEditable(false);
		textArea_1_1_1_1_1.setBounds(100, 295, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1_1.setEditable(false);
		textArea_1_1_1_1_1_1.setBounds(229, 295, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1_2 = new JTextArea();
		textArea_1_1_1_1_1_2.setEditable(false);
		textArea_1_1_1_1_1_2.setBounds(357, 204, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1_2);
		
		JLabel lblAbacate = new JLabel("Abacate:");
		lblAbacate.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAbacate.setBounds(10, 233, 72, 47);
		frame.getContentPane().add(lblAbacate);
		
		JLabel lblLaranja_1_1 = new JLabel("Coco:");
		lblLaranja_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1.setBounds(142, 233, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1);
		
		JLabel lblLaranja_1_1_1 = new JLabel("Acerola:");
		lblLaranja_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_1.setBounds(10, 284, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_1);
		
		JLabel lblLaranja_1_1_1_1 = new JLabel("Amora:");
		lblLaranja_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_1_1.setBounds(144, 284, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_1_1);
		
		JLabel lblLaranja_1_1_1_1_1 = new JLabel("Goiaba:");
		lblLaranja_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_1_1_1.setBounds(10, 191, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_1_1_1);
		
		JLabel lblMaracuj_1 = new JLabel("Maracujá:");
		lblMaracuj_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMaracuj_1.setBounds(275, 381, 84, 83);
		frame.getContentPane().add(lblMaracuj_1);
		
		JTextArea textArea_1_2 = new JTextArea();
		textArea_1_2.setEditable(false);
		textArea_1_2.setBounds(100, 412, 34, 22);
		frame.getContentPane().add(textArea_1_2);
		
		JLabel lblLaranja_1 = new JLabel("Laranja:");
		lblLaranja_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1.setBounds(144, 399, 72, 47);
		frame.getContentPane().add(lblLaranja_1);
		
		JTextArea textArea_1_1_2 = new JTextArea();
		textArea_1_1_2.setEditable(false);
		textArea_1_1_2.setBounds(229, 412, 34, 22);
		frame.getContentPane().add(textArea_1_1_2);
		
		JLabel lblAbacate_1 = new JLabel("Abacate:");
		lblAbacate_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAbacate_1.setBounds(10, 444, 72, 47);
		frame.getContentPane().add(lblAbacate_1);
		
		JTextArea textArea_1_1_1_1_2 = new JTextArea();
		textArea_1_1_1_1_2.setEditable(false);
		textArea_1_1_1_1_2.setBounds(100, 457, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_2);
		
		JLabel lblLaranja_1_1_2 = new JLabel("Coco:");
		lblLaranja_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_2.setBounds(142, 444, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_2);
		
		JTextArea textArea_1_1_1_2 = new JTextArea();
		textArea_1_1_1_2.setEditable(false);
		textArea_1_1_1_2.setBounds(229, 457, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_2);
		
		JLabel lblLaranja_1_1_1_2 = new JLabel("Acerola:");
		lblLaranja_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_1_2.setBounds(10, 495, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_1_2);
		
		JTextArea textArea_1_1_1_1_1_3 = new JTextArea();
		textArea_1_1_1_1_1_3.setEditable(false);
		textArea_1_1_1_1_1_3.setBounds(100, 506, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1_3);
		
		JLabel lblLaranja_1_1_1_1_2 = new JLabel("Amora:");
		lblLaranja_1_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_1_1_2.setBounds(144, 495, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_1_1_2);
		
		JTextArea textArea_1_1_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1_1_1.setEditable(false);
		textArea_1_1_1_1_1_1_1.setBounds(221, 594, 42, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1_1_1);
		
		JLabel lblLaranja_1_1_1_1_1_1 = new JLabel("Goiaba:");
		lblLaranja_1_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLaranja_1_1_1_1_1_1.setBounds(10, 399, 72, 47);
		frame.getContentPane().add(lblLaranja_1_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1_2_1 = new JTextArea();
		textArea_1_1_1_1_1_2_1.setEditable(false);
		textArea_1_1_1_1_1_2_1.setBounds(357, 412, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1_2_1);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Verdana", Font.BOLD, 25));
		lblStatus.setBounds(144, 26, 95, 83);
		frame.getContentPane().add(lblStatus);
		
		JTextArea textArea_1_1_1_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1_1_1_1.setEditable(false);
		textArea_1_1_1_1_1_1_1_1.setBounds(229, 508, 34, 22);
		frame.getContentPane().add(textArea_1_1_1_1_1_1_1_1);
	}
}
