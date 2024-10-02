package tela;
import Map.*;
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
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class primeiraTela {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
    private JTextArea textoAlerta, statusPainel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField jogador1Nome, jogador2Nome;
	private Path path;
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
	public primeiraTela() throws IOException{
		initialize();
		this.path = null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Define a cor do background
		Color corBackground = new Color(104, 155, 82);
		frame.getContentPane().setBackground(corBackground);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Faça o upload do terreno:");
		lblNewLabel_4.setBounds(10, 199, 201, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton botaoUpload = new JButton("Upload");
		botaoUpload.setForeground(new Color(0, 0, 0));
		botaoUpload.setBackground(new Color(255, 255, 255));
		botaoUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoUpload.setBounds(10, 222, 85, 21);
		frame.getContentPane().add(botaoUpload);
		
		JButton botaoIniciar = new JButton("Iniciar Jogo");
		botaoIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoIniciar.setBounds(192, 260, 106, 21);
		frame.getContentPane().add(botaoIniciar);
		
		botaoUpload.addActionListener(e -> carregarTerreno());
		botaoIniciar.addActionListener(e -> {
			try {
				iniciarJogo();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	// Método para carregar o terreno de um arquivo
	private void carregarTerreno() {
	    JFileChooser fileChooser = new JFileChooser();
	    int option = fileChooser.showOpenDialog(frame); // Passa o frame corretamente
	    if (option == JFileChooser.APPROVE_OPTION) {
	        File file = fileChooser.getSelectedFile();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            JOptionPane.showMessageDialog(frame, "Terreno carregado com sucesso."); // Corrigido
				System.out.println(file.toPath());
				this.path = file.toPath();
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(frame, "Erro ao carregar o terreno."); // Corrigido
				this.path = null;
	        }
	    }else {
			this.path = null;
		}
	}
	
	
    // Método para iniciar o jogo
    private void iniciarJogo() throws IOException {
        String nomeJogador1 = textField.getText();
        String nomeJogador2 = textField_1.getText();
        if (nomeJogador1.isEmpty() || nomeJogador2.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira os nomes dos jogadores.");
            return;
        }

		String newPath = path.toString();
		InicializarMap.inicilizarTerreno(newPath);	

        // Iniciar o jogo e atualizar o painel de status
        //String status = "Jogador 1: " + nomeJogador1 + "\nJogador 2: " + nomeJogador2 + "\nTerreno:\n" + textoAlerta.getText();
        //statusPainel.setText(status);
    }
}
