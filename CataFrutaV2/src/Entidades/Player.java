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

/**
 * A classe {@code Player} representa um jogador em um jogo.
 * 
 * <p>Essa classe estende a classe {@link Entity} e inclui informações específicas
 * para manipular o jogador, como a posição, quantidade de movimentos restantes,
 * direção, seleção de personagem (Eminem ou Kendrick), e sprites associados.
 * Além disso, controla a lógica de movimento, como colisão com obstáculos e atualização
 * da imagem de animação baseada na direção e na quantidade de passos.
 * </p>
 */

public class Player extends Entity {

	/**
     * Painel do jogo onde o jogador será renderizado.
     */
    GamePanel gp;

    /**
     * Manipulador de teclas para capturar as entradas do jogador.
     */
    KeyHandler keyH;

    /**
     * Controle de movimento e estado do jogador:
     * - {@code possible}: determina se o jogador pode mover-se no próximo turno.
     * - {@code moveUp}, {@code moveDown}, {@code moveLeft}, {@code moveRight}: 
     *   controle de movimento nas direções.
     * - {@code quantity}: passos restantes do jogador.
     */
    Boolean possible, moveUp, moveLeft, moveRight, moveDown;
    public int quantity;

    /**
     * Informações auxiliares para cálculo de posição e lógica de movimento:
     * - {@code counter}, {@code aux}: variáveis auxiliares de controle.
     * - {@code posX}, {@code posY}: posição do jogador em blocos no mapa.
     * - {@code sizeMap}: tamanho do mapa do jogo.
     * - {@code selector}: escolha do personagem (1 para Eminem, outro valor para Kendrick).
     */
    int counter, aux, posX, posY, sizeMap, selector;

	/**
     * Construtor da classe {@code Player}.
     * Inicializa o jogador com as configurações iniciais e carrega os sprites
     * do personagem escolhido.
     * 
     * @param gp o painel de jogo onde o jogador será renderizado
     * @param keyH o manipulador de teclas para capturar entradas do jogador
     * @param selector indica o personagem selecionado (1 para Eminem, outro valor para Kendrick)
     */

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

		if (this.selector == 1) {
			setDefaultEminem();
			getPlayerImageEminem();
		} else {
			setDefaultKendrick();
			getPlayerImageKendrick();
		}
	}

	/**
     * Define as configurações padrão para o personagem Eminem.
     */

	public void setDefaultEminem() {
		x = 0;
		y = 0;
		step = 128;
		direction = "down";

	}

	/**
     * Define as configurações padrão para o personagem Kendrick.
     */

	public void setDefaultKendrick() {
		x = 640;
		y = 0;
		step = 128;
		direction = "down";
	}

	/**
     * Atualiza o estado do jogador, incluindo sua posição, colisão com obstáculos e animação.
     * 
     * <p>Essa função realiza a rolagem de dados para determinar o número de passos que o jogador pode andar
     * e utiliza as entradas do teclado para alterar a posição do jogador. Verifica colisões com obstáculos
     * no mapa para impedir que o jogador se mova para determinadas direções.</p>
     */

	public void update() {

		if (this.quantity == 0) {
			this.quantity = Dado.rolar();
			if (selector == 1) {
				System.out.print("Passos do EMINEM: ");
			}else {
				System.out.print("Passos do KENDRICK: ");
			}
			System.out.println(this.quantity);
		}

		posX = x / 128;
		posY = y / 128;
		sizeMap = Terreno.sizeofMap();

		if (posX != sizeMap - 1) {
			if (Terreno.getPosition(posX + 1, posY) instanceof ChaoRochoso) {
				// System.out.println("Pedra na direita");
				moveRight = false;
			} else {
				moveRight = true;
			}
		}
		if (posX != 0) {
			if (Terreno.getPosition(posX - 1, posY) instanceof ChaoRochoso) {
				// System.out.println("Pedra na esquerda");
				moveLeft = false;
			} else {
				moveLeft = true;
			}
		}
		if (posY != 0) {
			if (Terreno.getPosition(posX, posY - 1) instanceof ChaoRochoso) {
				// System.out.println("Pedra em cima");
				moveUp = false;
			} else {
				moveUp = true;
			}
		}
		if (posY != sizeMap - 1) {
			if (Terreno.getPosition(posX, posY + 1) instanceof ChaoRochoso) {
				// System.out.println("Pedra em baixo");
				moveDown = false;
			} else {
				moveDown = true;
			}
		}

		if (selector == 1) {
			if (possible && this.quantity > 0) {
				if (keyH.wPressed == true) {
					if (y - step >= 0 && moveUp) {
						direction = "up";
						y -= step;
						possible = false;
						this.quantity--;
					}
				} else if (keyH.sPressed == true && moveDown) {
					if (y + step <= 760) {
						direction = "down";
						y += step;
						possible = false;
						this.quantity--;
					}
				} else if (keyH.aPressed == true && moveLeft) {
					if (x - step >= 0) {
						direction = "left";
						x -= step;
						possible = false;
						quantity--;
					}
				} else if (keyH.dPressed == true && moveRight) {
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
		} else {
			if (possible && this.quantity > 0) {
				if (keyH.upPressed == true) {
					if (y - step >= 0 && moveUp) {
						direction = "up";
						y -= step;
						possible = false;
						this.quantity--;
					}
				} else if (keyH.downPressed == true && moveDown) {
					if (y + step <= 760) {
						direction = "down";
						y += step;
						possible = false;
						this.quantity--;
					}
				} else if (keyH.leftPressed == true && moveLeft) {
					if (x - step >= 0) {
						direction = "left";
						x -= step;
						possible = false;
						quantity--;
					}
				} else if (keyH.rightPressed == true && moveRight) {
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
		}

		spriteCounter++;
		if (spriteCounter > 10) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}

	}

	/**
     * Carrega as imagens do personagem Eminem para as diferentes direções.
     */

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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * Carrega as imagens do personagem Kendrick para as diferentes direções.
     */

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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * Desenha o jogador na tela com base em sua direção e quadro de animação atual.
     * 
     * @param g2 o contexto gráfico onde o jogador será desenhado
     */

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
			case "up":
				if (spriteNum == 1) {
					image = up1;
				}
				if (spriteNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if (spriteNum == 1) {
					image = down1;
				}
				if (spriteNum == 2) {
					image = down2;
				}
				break;
			case "left":
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
				break;
			case "right":
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				break;
		}

		g2.drawImage(image, x, y, 128, 128, null);
	}
}
