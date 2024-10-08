package Map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Chao {
	public BufferedImage image;
    private String tipo;

    // Construtor
    public Chao(String tipo) {
        this.tipo = tipo;
    }

    // Método concreto
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}