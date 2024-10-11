package InterfaceGrafica;
import Map.*;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


/**
 * Painel de jogo que exibe o tabuleiro e lida com a interface gráfica.
 * 
 * <p>A classe {@code GamePanel} estende {@link JPanel} e define as dimensões do painel, 
 * a cor de fundo e métodos para configurar e desenhar o tabuleiro do jogo.</p>
 */

public class GamePanel extends JPanel{
	public static final int WIDTH = 767;
	public static final int HEIGTH = 760;
	public static final int UNIT_SIZE = 64;
	Terreno tabuleiro;
	
	/**
     * Construtor da classe GamePanel.
     * 
     * <p>Inicializa o painel com dimensões e cor de fundo padrão.</p>
     */
	
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGTH));
		setBackground(Color.BLACK);
		setFocusable(true);
		tabuleiro = null;
	
		
	}
	
	/**
     * Define o terreno a ser exibido no painel.
     * 
     * <p>Este método configura o tabuleiro e solicita uma nova pintura do painel.</p>
     * 
     * @param terreno O terreno a ser exibido.
     */
	
	public void setTerreno(Terreno terreno) {
		this.tabuleiro = terreno;
		repaint();
	}
	
	
	/**
     * Desenha o componente gráfico no painel.
     * 
     * <p>Este método é chamado automaticamente pelo sistema quando é necessário 
     * repintar o painel. Ele chama o método de desenho do tabuleiro, se definido.</p>
     * 
     * @param g O objeto {@code Graphics} usado para desenhar.
     */
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//tabuleiro.draw(g2);
		
		if (tabuleiro != null) {
            tabuleiro.draw(g2);  
        }
		
		
		
				
		
		
	}
}