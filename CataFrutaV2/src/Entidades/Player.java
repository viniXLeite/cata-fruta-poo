package Entidades;

import Dado.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Chao.ChaoRochoso;
import KeyHandler.*;

import InterfaceGrafica.*;
import Map.Terreno;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	Boolean possible, moveUp, moveLeft, moveRight, moveDown;
	int quantity;
	int counter;
	int aux;
	int posX;
	int posY;
	int sizeMap;
	int selector;
	
	
	public Player(GamePanel gp, KeyHandler keyH, int selector) {
		
		this.gp = gp;
		this.keyH = keyH;
		this.possible = true;
		this.quantity = 0;
		this.counter = 0;
		this.selector = selector;
		this.moveDown = true;
		this.moveLeft = true;
		this.moveRight = true;
		this.moveUp = true;
		
		if(this.selector == 1) {
			setDefaultEminem();
			getPlayerImageEminem();
		}
		else {
			setDefaultKendrick();
			getPlayerImageKendrick();
		}
	}
	
	public void setDefaultEminem() {
		x = 0;
		y = 0;
		step = 128;
		direction = "down";
		
	}
	
	public void setDefaultKendrick() {
		x = 640;
		y = 0;
		step = 128;
		direction = "down";
	}
	
	public void update() {
		
		if(this.quantity == 0) {
			this.quantity = Dado.rolar();
			System.out.println(this.quantity);
		}
		
		posX = x / 128;
		posY = y / 128;
		sizeMap = Terreno.sizeofMap();
		
		
	if (posX != sizeMap  -  1) {
	  if (Terreno.getPosition(posX + 1, posY) instanceof ChaoRochoso) {
		System.out.println("Pedra na direita");
		moveRight = false;
	  }else {
		moveRight = true;
	  }
	}
	if (posX != 0) {
	  if (Terreno.getPosition(posX - 1, posY) instanceof ChaoRochoso) {
		System.out.println("Pedra na esquerda");
		moveLeft = false;
	  }else {
		moveLeft = true;
	  }
	}
	if (posY != 0) {
	  if (Terreno.getPosition(posX, posY - 1) instanceof ChaoRochoso) {
		System.out.println("Pedra em cima");
		moveUp = false;
	  }else {
		moveUp = true;
	  }
	}
	if (posY != sizeMap  -  1) {
	  if (Terreno.getPosition(posX, posY + 1) instanceof ChaoRochoso) {
		System.out.println("Pedra em baixo");
		moveDown = false;
	  }else {
		moveDown = true;
	  }
	}
		
		
	 if(selector == 1) {
			
			if (possible && this.quantity > 0) {
				if(keyH.upPressed == true) {
					if (y - step >= 0 && moveUp) {
						direction = "up";
						y -= step;
						possible = false;
						this.quantity--;
					}
				}
				else if(keyH.downPressed == true && moveDown) {
					if (y + step <= 760) {
						direction = "down";
						y += step;
						possible = false;
						this.quantity--;
					}
				}
				else if(keyH.leftPressed == true && moveLeft) {
					if (x - step >= 0) {
						direction = "left";
						x -= step;
						possible = false;
						quantity--;
					}
				}
				else if(keyH.rightPressed == true && moveRight) {
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
			if (keyH.setasReleased) {
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
	 else {
				if (possible && this.quantity > 0) {
					if(keyH.wPressed == true) {
						if (y - step >= 0 && moveUp) {
							direction = "up";
							y -= step;
							possible = false;
							this.quantity--;
						}
					}
					else if(keyH.sPressed == true && moveDown) {
						if (y + step <= 760) {
							direction = "down";
							y += step;
							possible = false;
							this.quantity--;
						}
					}
					else if(keyH.aPressed == true && moveLeft) {
						if (x - step >= 0) {
							direction = "left";
							x -= step;
							possible = false;
							quantity--;
						}
					}
					else if(keyH.dPressed == true && moveRight) {
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
				if (keyH.teclasReleased) {
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
	 
	}
	
	public void getPlayerImageEminem() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Imagens/eminem_1.png"));
			down1 = up1;
			down2 = up2;
			left1 = up1;
			left2 = up2;
			right1 = up1;
			right2 = up2;
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void getPlayerImageKendrick() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/Imagens/kendrick_0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Imagens/kendrick_1.png"));
			down1 = up1;
			down2 = up2;
			left1 = up1;
			left2 = up2;
			right1 = up1;
			right2 = up2;
			
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
				image = down2;
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
