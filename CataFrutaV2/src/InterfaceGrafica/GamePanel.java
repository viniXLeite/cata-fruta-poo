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
import java.util.Random;



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
	private int currentPlayerTurn = 1;
	KeyHandler keyH = new KeyHandler();
	KeyHandler keyK = new KeyHandler();
	Player eminem = new Player(this, keyH, selectPlayer1);
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
		this.addKeyListener(keyK);
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
	
	public void switchTurn() {
        currentPlayerTurn = (currentPlayerTurn == 1) ? 2 : 1;
    }

	public int getRandomPosition(int size) {
		Random rand = new Random();
		int val = rand.nextInt(size);
		return val;
	}

	
	public boolean checkColison(Player eminem, Player kendrick) {
		int player1Right = eminem.x + 128;
	    int player1Bottom = eminem.y + 128;
	    int player2Right = kendrick.x + 128;
	    int player2Bottom = kendrick.y + 128;

	    boolean collisionX = eminem.x < player2Right && player1Right > kendrick.x;
	    boolean collisionY = eminem.y < player2Bottom && player1Bottom > kendrick.y;
	    
	    

	    if(collisionX && collisionY) {
	    	int offSet = 128;
	    	
	    	int boardSize = Terreno.sizeofMap() * offSet;
			@SuppressWarnings("unused")
			int playerEmpurrado;
			int val;

			if (this.currentPlayerTurn == 1) {
				System.out.println("FRUTAS DO KENDRICK CAIRAM");
				playerEmpurrado = 2;
				val = getRandomPosition(Terreno.sizeofMap());
				System.out.println(val);
				System.out.println("POSICAO DA FRUTA EM X: "+ val * 128);
				System.out.println("POSICAO DA FRUTA EM Y: "+ val * 128);
			}else {
				System.out.println("FRUTAS DO EMINEM CAIRAM");
				playerEmpurrado = 1;
				val = getRandomPosition(Terreno.sizeofMap());
				System.out.println(val);
				System.out.println("POSICAO DA FRUTA EM X: "+ val * 128);
				System.out.println("POSICAO DA FRUTA EM Y: "+ val * 128);
			}
	    	
	    	if(eminem.x < kendrick.x) {
	    		eminem.x = Math.max(eminem.x - offSet, 0);
	    		kendrick.x = Math.min(kendrick.x + offSet, boardSize - offSet);
	    	}
	    	else {
	    		kendrick.x = Math.max(eminem.x - offSet, 0);
	    		eminem.x = Math.min(eminem.x + offSet, boardSize - offSet);
	    	}
	    	
	    	if(eminem.y < kendrick.y) {
	    		eminem.y = Math.max(eminem.y - offSet, 0);
	    		kendrick.y = Math.min(kendrick.y + offSet, boardSize - offSet);
	    	}
	    	else {
	    		kendrick.y = Math.max(eminem.y - offSet, 0);
	    		eminem.y = Math.min(eminem.y + offSet, boardSize - offSet);
	    	}
	    	
	    	return true;
	    }
	    
	    return false;
	}
	
public void update() {
		
		
		if(this.currentPlayerTurn == 1) {
			eminem.update();
			if(eminem.quantity == 0) {
				switchTurn();
			}
		}
		
		else {
			kendrick.update();
			if(kendrick.quantity == 0) {
				switchTurn();
			}
		}
		
		
		
		
		if(checkColison(eminem, kendrick)) {
			System.out.println("COLISAO");
		}
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
		
		eminem.draw(g2);
		kendrick.draw(g2);
		
		
		
		
				
		
		
	}
}