package Chao;

import java.awt.Graphics2D;
import java.util.AbstractMap.SimpleEntry;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe abstrata que representa o tipo de solo presente no jogo, onde o jogador irá se mover.
 * 
 * <p>A classe {@code Chao} define a estrutura básica para diferentes tipos de solos, como pedras, 
 * grama ou árvores. Essa classe pode ser estendida para definir tipos de solo específicos, 
 * como {@code ChaoRochoso} ou {@code ChaoComGrama}.</p>
 * 
 * <p>Essa classe contém a imagem do solo e o tipo de solo em questão.</p>
 */

public abstract class Chao {
	public BufferedImage image;
	public SimpleEntry<Integer, Integer> posicaoP1;
	public SimpleEntry<Integer, Integer> posicaoP2;
    private String tipo;

    
    /**
     * Construtor da classe Chao.
     * 
     * <p>Inicializa um objeto da classe {@code Chao} com o tipo de solo fornecido.</p>
     * 
     * @param tipo O tipo de solo.
     */
    
    // Construtor
    public Chao(String tipo) {
        this.tipo = tipo;
    }

    
    /**
     * Retorna o tipo de solo.
     * 
     * @return O tipo de solo.
     */
    
    // Método concreto
    public String getTipo() {
        return tipo;
    }

    
    /**
     * Define um novo tipo de solo.
     * 
     * @param tipo O novo tipo de solo.
     */
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}