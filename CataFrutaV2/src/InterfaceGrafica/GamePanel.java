package InterfaceGrafica;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Dado.Dado;
import Entidades.Player;
import KeyHandler.KeyHandler;
import Map.Terreno;



/**
 * Painel de jogo que exibe o tabuleiro e lida com a interface gráfica.
 * 
 * <p>A classe {@code GamePanel} estende {@link JPanel} e define as dimensões do painel, 
 * a cor de fundo e métodos para configurar e desenhar o tabuleiro do jogo.</p>
 */

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH = 767;
	public static final int HEIGTH = 760;
	public static final int UNIT_SIZE = 64;
	int selectPlayer1 = 1;
	int selectPlayer2 = 0;
	final int FPS = 60;
	Thread gameThread;
	Terreno tabuleiro;
	KeyHandler keyH = new KeyHandler();
	KeyHandler keyK = new KeyHandler();
	Player player = new Player(this, keyH, selectPlayer1);
	Player kendrick = new Player(this, keyK, selectPlayer2);
	
	
	int playerX = 100;
	int playerY = 100;
	int step = Dado.rolar();
	
	
	/**
     * Construtor da classe GamePanel.
     * 
     * <p>Inicializa o painel com dimensões e cor de fundo padrão.</p>
     */
	
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGTH));
		setBackground(Color.BLACK);
		setFocusable(true);
		this.addKeyListener(keyH);
		tabuleiro = null;
	
		
	}
	
	public void starGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run(){
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
			
		}
	}
	
	public void update() {
		player.update();
		kendrick.update();
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
		//repaint();
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
		
		//Graphics2D g3 = (Graphics2D)g;
		
		
		
		
        tabuleiro.draw(g2);  
		
		player.draw(g2);
		kendrick.draw(g2);
		
		
		
		
				
		
		
	}
}