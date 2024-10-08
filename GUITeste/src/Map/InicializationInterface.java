package Map;

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
	        
	        int frameSize = m*128;
	        frame.setBounds(10, 10, frameSize, frameSize);
	        GamePanel gp = new GamePanel();
	        gp.setTerreno(t);
	        frame.add(gp);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
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
