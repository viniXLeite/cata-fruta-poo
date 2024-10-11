package Frutas;

/**
 * Representa uma fruta com um tipo específico.
 * 
 * Esta classe permite a criação de uma fruta através do seu tipo e oferece métodos para
 * acessar e exibir o tipo da fruta.
 * 
 */

public class Fruta {
	private String tipo;

    // Construtor
    public Fruta(String tipo) {
        this.tipo = tipo;
    }

    
    /**
     * Retorna o tipo da fruta.
     * 
     * @return O tipo da fruta.
     */
    
    public String getTipo() {
        return tipo;    
        }
    
    
    /**
     * Retorna a representação em string da fruta.
     * 
     * O retorno será o tipo da fruta como uma string.
     * 
     * @return O tipo da fruta como string.
     */
    
    @Override
    public String toString() {
        return tipo;
    }
}