package Entidades;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 0;
		y = 0;
		step = 128;
		direction = "down";
		
	}
	
	public void update() {
		if (possible && this.quantity > 0) {
			if(keyH.upPressed == true) {
				if (y - step >= 0) {
					direction = "up";
					y -= step;
					possible = false;
					this.quantity--;
				}
			}
			else if(keyH.downPressed == true) {
				if (y + step <= 760) {
					direction = "down";
					y += step;
					possible = false;
					this.quantity--;
				}
			}
			else if(keyH.leftPressed == true) {
				if (x - step >= 0) {
					direction = "left";
					x -= step;
					possible = false;
					quantity--;
				}
			}
			else if(keyH.rightPressed == true) {
				if (x + step <= 767) {
					direction = "right";
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
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	public void getPlayerImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_0.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_1.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_2.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_movi_2.png"));
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down1;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;	
		}
		
		g2.drawImage(image, x, y, 128, 128, null);
	}
}
