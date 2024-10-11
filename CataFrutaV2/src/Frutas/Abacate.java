package Frutas;

/**
 * Representa uma fruta específica do tipo abacate.
 * 
 * <p>A classe {@code Abacate} herda de {@link Fruta} e permite a criação de um abacate
 * especificando seu tipo.</p>
 * 
 */

public class Abacate extends Fruta{
	
	/**
     * Construtor da classe Abacate.
     * 
     * <p>Inicializa um objeto da classe {@code Abacate} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo do abacate (por exemplo, "Abacate Hass").
     */
	public Abacate (String tipo){
		super(tipo);
	}
}