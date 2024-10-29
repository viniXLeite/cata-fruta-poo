package Arvores;

/**
 * Representa uma árvore do tipo aceroleiro.
 * 
 * <p>A classe {@code Aceroleiro} herda da classe {@link Arvore} e permite a criação de um aceroleiro
 * especificando seu tipo.</p>
 * 
 */

public class Aceroleiro extends Arvore{

	
	/**
     * Construtor da classe Aceroleiro.
     * 
     * <p>Inicializa um objeto da classe {@code Aceroleiro} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo do aceroleiro (por exemplo, "Aceroleiro Vermelho").
     */
	public Aceroleiro(String tipo) {
		super(tipo);
	}
}
