package Entity;
import java.awt.Color;
import java.awt.Graphics2D;

import KeyHandler.*;

import InterfaceGrafica.*;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		x = 10;
		y = 10;
		step = 4;
	}
	
	public void update() {
		if(keyH.upPressed == true) {
			y -= step;
		}
		else if(keyH.downPressed == true) {
			y += step;
		}
		else if(keyH.leftPressed == true) {
			x -= step;
		}
		else if(keyH.rightPressed == true) {
			x += step;
		}
		
		step--;
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x, y, 128, 128);
	}
}
