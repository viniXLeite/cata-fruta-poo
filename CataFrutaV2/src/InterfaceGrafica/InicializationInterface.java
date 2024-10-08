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

public class InicializationInterface {
	public BufferedImage image;
		
	    public void tabuleiroGInterface(int m, Terreno t) {
	    	
	    	JFrame frame = new JFrame("Cata-Fruta");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(true);
	        
	        // Definir o layout do JFrame como BorderLayout
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
	        
	        
	      /*  //frame.setUndecorated(true);
	        JPanel pn = new JPanel() {
	            @Override
	            public void paint(Graphics g) {
	            	super.paint(g);
	            	Graphics2D g2 = (Graphics2D) g;
	            	
	            	
	                boolean green = true;
	                for (int i = 0; i < m; i++) {
	                    for (int j = 0; j < m; j++) {
	                        if (green) {
	                            g.setColor(Color.LIGHT_GRAY);
	                        } else {
	                            g.setColor(Color.GRAY);
	                        }
	                        g.fillRect(i * 64, j * 64, 64, 64);
	                        green = ! green;
	                    }
	                    green = !green;  // Alterna a cor a cada nova linha
	                }
	                
	                
	                
	            }
	            */
	        //};

	        
	    }
}