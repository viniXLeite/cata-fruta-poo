package Frutas;


/**
 * Representa uma fruta específica do tipo acerola.
 * 
 * <p>A classe {@code Acerola} herda de {@link Fruta} e permite a criação de uma acerola
 * especificando seu tipo.</p>
 * 
 */

public class Acerola extends Fruta{
	
	 /**
     * Construtor da classe Acerola.
     * 
     * <p>Inicializa um objeto da classe {@code Acerola} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da acerola (por exemplo, "Acerola Silvestre").
     */
	
	public Acerola(String tipo){
		super(tipo);
	}
}