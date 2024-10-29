package Entidades;

import java.awt.image.BufferedImage;

/**
 * A classe {@code Entity} representa uma entidade genérica de jogador em um jogo.
 * 
 * <p>Esta classe armazena as informações de posição e sprites para a entidade, permitindo
 * que a entidade tenha uma direção e uma animação básica com múltiplos quadros para cada
 * direção (cima, baixo, esquerda, direita).</p>
 * 
 * <p>Campos como {@code x}, {@code y}, {@code xi} e {@code yi} representam a posição atual
 * e a posição inicial da entidade no ambiente do jogo. Os campos de imagem ({@code up1},
 * {@code up2}, etc.) são usados para armazenar diferentes sprites da animação da entidade
 * em cada direção.</p>
 */
public class Entity {
    
    /**
     * A posição horizontal da entidade.
     */
    public int x;

    /**
     * A posição vertical da entidade.
     */
    public int y;

    /**
     * A quantidade de passos dados pela entidade.
     */
    public int step;

    /**
     * Sprite da entidade ao se mover para cima, quadro 1.
     */
    public BufferedImage up1;

    /**
     * Sprite da entidade ao se mover para cima, quadro 2.
     */
    public BufferedImage up2;

    /**
     * Sprite da entidade ao se mover para baixo, quadro 1.
     */
    public BufferedImage down1;

    /**
     * Sprite da entidade ao se mover para baixo, quadro 2.
     */
    public BufferedImage down2;

    /**
     * Sprite da entidade ao se mover para a esquerda, quadro 1.
     */
    public BufferedImage left1;

    /**
     * Sprite da entidade ao se mover para a esquerda, quadro 2.
     */
    public BufferedImage left2;

    /**
     * Sprite da entidade ao se mover para a direita, quadro 1.
     */
    public BufferedImage right1;

    /**
     * Sprite da entidade ao se mover para a direita, quadro 2.
     */
    public BufferedImage right2;

    /**
     * A direção atual da entidade, representada como uma {@code String}.
     * Pode assumir valores como "up", "down", "left" e "right".
     */
    public String direction;

    /**
     * Contador do sprite, usado para controlar a velocidade da animação.
     */
    public int spriteCounter = 0;

    /**
     * Número do sprite atual, usado para alternar entre quadros de animação.
     */
    public int spriteNum = 1;
}
