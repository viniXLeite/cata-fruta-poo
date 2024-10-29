package Arvores;


/**
 * Representa uma árvore do tipo laranjeira.
 * 
 * <p>A classe {@code Laranjeira} herda da classe {@link Arvore} e permite a criação de uma laranjeira
 * especificando seu tipo.</p>
 * 
 */

public class Laranjeira extends Arvore{

	
	/**
     * Construtor da classe Laranjeira.
     * 
     * <p>Inicializa um objeto da classe {@code Laranjeira} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da laranjeira (por exemplo, "Laranjeira Pera").
     */
	
	public Laranjeira(String tipo) {
		super(tipo);
	}
	
}
