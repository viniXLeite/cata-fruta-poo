package Arvores;

/**
 * Representa uma árvore do tipo coqueiro.
 * 
 * <p>A classe {@code Coqueiro} herda da classe {@link Arvore} e permite a criação de um coqueiro
 * especificando seu tipo.</p>
 * 
 */

public class Coqueiro extends Arvore{
	
	/**
     * Construtor da classe Coqueiro.
     * 
     * <p>Inicializa um objeto da classe {@code Coqueiro} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo do coqueiro (por exemplo, "Coqueiro Anão").
     */

	public Coqueiro(String tipo) {
		super(tipo);
	}
	
}
