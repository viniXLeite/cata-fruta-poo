package Frutas;

/**
 * Representa uma fruta específica do tipo goiaba.
 * 
 * <p>A classe {@code Goiaba} herda de {@link Fruta} e permite a criação de uma goiaba
 * especificando seu tipo.</p>
 * 
 */

public class Goiaba extends Fruta{
	
	/**
     * Construtor da classe Goiaba.
     * 
     * <p>Inicializa um objeto da classe {@code Goiaba} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da goiaba (por exemplo, "Goiaba Vermelha", "Goiaba Branca").
     */
	
	public Goiaba (String tipo){
		super(tipo);
	}
}