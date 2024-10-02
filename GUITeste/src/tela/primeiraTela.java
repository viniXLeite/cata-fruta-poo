package tela;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class primeiraTela {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
    private JTextArea textoAlerta;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primeiraTela window = new primeiraTela();
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
	public primeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Define a cor do background
		frame.getContentPane().setBackground(Color.orange);
		
		JLabel lblNewLabel = new JLabel("Nome do jogador 1");
		lblNewLabel.setBounds(10, 74, 113, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 102, 303, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do jogador 2");
		lblNewLabel_1.setBounds(10, 130, 106, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 153, 303, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Seja bem-vindo ao jogo cata-frutas");
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 10, 324, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Preencha as configurações iniciais do jogo!");
		lblNewLabel_3.setBounds(10, 37, 245, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Faça o upload do terreno");
		lblNewLabel_4.setBounds(10, 199, 201, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 222, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar Jogo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(192, 260, 106, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(e -> carregarTerreno());
	}
	
	// Método para carregar o terreno de um arquivo
	private void carregarTerreno() {
	    JFileChooser fileChooser = new JFileChooser();
	    int option = fileChooser.showOpenDialog(frame); // Passa o frame corretamente
	    if (option == JFileChooser.APPROVE_OPTION) {
	        File file = fileChooser.getSelectedFile();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            StringBuilder terreno = new StringBuilder();
	            while ((line = reader.readLine()) != null) {
	                terreno.append(line).append("\n");
	            }
	            textoAlerta.setText(terreno.toString()); // Exibe o conteúdo no JTextArea
	            JOptionPane.showMessageDialog(frame, "Terreno carregado com sucesso."); // Corrigido
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(frame, "Erro ao carregar o terreno."); // Corrigido
	        }
	    }
	}
}
