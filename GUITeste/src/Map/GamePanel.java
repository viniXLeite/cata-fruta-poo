package Map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public static final int WIDTH = 800;
	public static final int HEIGTH = 800;
	Terreno tabuleiro;
	

	
	
	
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGTH));
		setBackground(Color.BLACK);
		tabuleiro = null;
	
		
	}
	
	public void setTerreno(Terreno terreno) {
		this.tabuleiro = terreno;
		repaint();
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//tabuleiro.draw(g2);
		
		if (tabuleiro != null) {
            tabuleiro.draw(g2);  // Desenha o tabuleiro apenas se não for nulo
        }
		
		
		
				
		
		
	}
}
