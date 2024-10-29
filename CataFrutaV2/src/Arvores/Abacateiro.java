package Arvores;

/**
 * Representa uma árvore do tipo abacateiro.
 * 
 * <p>A classe {@code Abacateiro} herda da classe {@link Arvore} e permite a criação de um abacateiro
 * especificando seu tipo.</p>
 * 
 */

public class Abacateiro extends Arvore{

	
	/**
     * Construtor da classe Abacateiro.
     * 
     * <p>Inicializa um objeto da classe {@code Abacateiro} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo do abacateiro (por exemplo, "Abacateiro Hass").
     */
	
	public Abacateiro(String tipo) {
		super(tipo);
	}
	
	
}
