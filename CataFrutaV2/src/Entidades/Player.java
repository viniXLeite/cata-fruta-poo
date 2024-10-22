package Entidades;
import java.awt.Color;
import java.awt.Graphics2D;

import KeyHandler.*;

import InterfaceGrafica.*;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	Boolean possible;
	int quantity;
	int counter;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		this.possible = true;
		this.quantity = 0;
		this.counter = 0;
		
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		x = 0;
		y = 0;
		step = 128;
	}
	
	public void update() {
		if (possible && this.quantity > 0) {
			if(keyH.upPressed == true) {
				if (y - step >= 0) {
					y -= step;
					possible = false;
					this.quantity--;
				}
			}
			else if(keyH.downPressed == true) {
				if (y + step <= 760) {
					y += step;
					possible = false;
					this.quantity--;
				}
			}
			else if(keyH.leftPressed == true) {
				if (x - step >= 0) {
					x -= step;
					possible = false;
					quantity--;
				}
			}
			else if(keyH.rightPressed == true) {
				if (x + step <= 767) {
					x += step;
					possible = false;
					this.quantity--;
				}
			}
		}
		if (keyH.spacePressed) {
			possible = true;
			quantity = 3;
		}
		if (keyH.released) {
			possible = true;
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x, y, 128, 128);
	}
}
