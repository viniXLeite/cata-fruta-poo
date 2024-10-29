package Arvores;


/**
 * Representa uma árvore do tipo goiabeira.
 * 
 * <p>A classe {@code Goiabeira} herda da classe {@link Arvore} e permite a criação de uma goiabeira
 * especificando seu tipo.</p>
 * 
 */


public class Goiabeira extends Arvore{

	/**
     * Construtor da classe Goiabeira.
     * 
     * <p>Inicializa um objeto da classe {@code Goiabeira} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da goiabeira (por exemplo, "Goiabeira Branca").
     */
	
	public Goiabeira(String tipo) {
		super(tipo);
	}
	
}
