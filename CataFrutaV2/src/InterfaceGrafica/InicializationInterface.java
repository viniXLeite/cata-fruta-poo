package InterfaceGrafica;
import Map.*;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * A classe {@code InicializationInterface} é responsável por criar a interface gráfica do jogo "Cata-Fruta".
 * Esta classe contém métodos para inicializar a janela do jogo e exibir o tabuleiro na interface.
 */


public class InicializationInterface {
	public BufferedImage image;
		
	
	 /**
     * Inicializa a interface gráfica do tabuleiro do jogo.
     * 
     * @param m O tamanho do tabuleiro.
     * @param t O objeto {@code Terreno} que representa o estado do tabuleiro do jogo.
     */
	
	    public void tabuleiroGInterface(int m, Terreno t) {
	    	
	    	JFrame frame = new JFrame("Cata-Fruta"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	        
	        frame.setLayout(new BorderLayout());

	        // Criar o GamePanel e associar o terreno
	        GamePanel gp = new GamePanel();
	        gp.setTerreno(t);

	        // Adicionar o GamePanel no centro do frame
	        frame.add(gp, BorderLayout.CENTER);

	        // Ajustar o tamanho da janela automaticamente de acordo com os componentes
	        frame.pack();

	        // Centralizar a janela na tela
	        frame.setLocationRelativeTo(null);

	        // Tornar a janela visível
	        frame.setVisible(true);
	        
	        gp.starGameThread();
	        
	        
	      
	        
	    }
}