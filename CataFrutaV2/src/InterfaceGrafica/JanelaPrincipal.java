package InterfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * A classe {@code JanelaPrincipal} é responsável por criar e exibir a janela inicial do jogo.
 * 
 * <p>Essa janela apresenta opções para o usuário iniciar um novo jogo, carregar um jogo existente
 * ou acessar configurações. A janela inicial é a primeira interface que o jogador vê ao abrir o jogo.
 * </p>
 */

public class JanelaPrincipal extends JFrame {
    
    // Componentes principais
    private JTextField inputTerrenoConfig;
    private JButton gerarTerrenoButton, salvarTerrenoButton, carregarTerrenoButton;
    private JTextArea terrenoExemplo, statusPanel;
    private JTextField jogador1Nome, jogador2Nome;
    private JButton iniciarJogoButton;

    /**
     * Constrói a janela inicial do jogo, configurando o título, tamanho e os componentes visuais,
     * como botões e rótulos, para a interação do usuário.
     */

    public JanelaPrincipal() {
        setTitle("Criador de Terreno e Iniciar Jogo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para a criação de terreno
        JPanel painelTerreno = new JPanel();
        painelTerreno.setLayout(new GridLayout(4, 2));

        painelTerreno.add(new JLabel("Configuração do Terreno:"));
        inputTerrenoConfig = new JTextField();
        painelTerreno.add(inputTerrenoConfig);

        gerarTerrenoButton = new JButton("Gerar Terreno");
        painelTerreno.add(gerarTerrenoButton);

        salvarTerrenoButton = new JButton("Salvar Terreno");
        painelTerreno.add(salvarTerrenoButton);

        carregarTerrenoButton = new JButton("Carregar Terreno");
        painelTerreno.add(carregarTerrenoButton);

        terrenoExemplo = new JTextArea(5, 30);
        terrenoExemplo.setEditable(false);
        JScrollPane scroll = new JScrollPane(terrenoExemplo);
        painelTerreno.add(scroll);

        // Painel para iniciar o jogo
        JPanel painelJogo = new JPanel();
        painelJogo.setLayout(new GridLayout(4, 2));

        painelJogo.add(new JLabel("Nome do Jogador 1:"));
        jogador1Nome = new JTextField();
        painelJogo.add(jogador1Nome);

        painelJogo.add(new JLabel("Nome do Jogador 2:"));
        jogador2Nome = new JTextField();
        painelJogo.add(jogador2Nome);

        iniciarJogoButton = new JButton("Iniciar Jogo");
        painelJogo.add(iniciarJogoButton);

        statusPanel = new JTextArea(5, 30);
        statusPanel.setEditable(false);
        JScrollPane scrollStatus = new JScrollPane(statusPanel);
        painelJogo.add(scrollStatus);

        add(painelTerreno, BorderLayout.NORTH);
        add(painelJogo, BorderLayout.SOUTH);

        // Eventos de botão
        gerarTerrenoButton.addActionListener(e -> gerarTerreno());
        salvarTerrenoButton.addActionListener(e -> salvarTerreno());
        carregarTerrenoButton.addActionListener(e -> carregarTerreno());
        iniciarJogoButton.addActionListener(e -> iniciarJogo());
    }

    /**
     * A partir do clique do botão cria o terreno que sera utilizado no jogo
     */
    private void gerarTerreno() {
        String config = inputTerrenoConfig.getText();
        if (config.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma configuração válida.");
            return;
        }

        // Gerar um exemplo de terreno com base na configuração
        String exemploTerreno = "Terreno gerado com a configuração: " + config;
        terrenoExemplo.setText(exemploTerreno);
    }

    /**
     * Ao clicar no botão o terreno será salvo em um arquivo .txt para poder
     * ser reutilizado em outras partidas ou analisado
     */
    private void salvarTerreno() {
        String config = inputTerrenoConfig.getText();
        if (config.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma configuração válida.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(config);
                JOptionPane.showMessageDialog(this, "Terreno salvo com sucesso.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o terreno.");
            }
        }
    }

    /**
     * O clique o botão abrirá uma aba de seleção para escolha do terreno que será utilizado
     */
    private void carregarTerreno() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder terreno = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    terreno.append(line).append("\n");
                }
                terrenoExemplo.setText(terreno.toString());
                JOptionPane.showMessageDialog(this, "Terreno carregado com sucesso.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar o terreno.");
            }
        }
    }

    /**
     * Esse método serve para iniciar o jogo a partir do clique do botão
     */
    private void iniciarJogo() {
        String nomeJogador1 = jogador1Nome.getText();
        String nomeJogador2 = jogador2Nome.getText();
        if (nomeJogador1.isEmpty() || nomeJogador2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira os nomes dos jogadores.");
            return;
        }

        // Iniciar o jogo e atualizar o painel de status
        String status = "Jogador 1: " + nomeJogador1 + "\nJogador 2: " + nomeJogador2 + "\nTerreno:\n" + terrenoExemplo.getText();
        statusPanel.setText(status);
    }
}