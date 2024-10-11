package Frutas;

/**
 * Representa uma fruta específica do tipo laranja.
 * 
 * <p>A classe {@code Laranja} herda de {@link Fruta} e permite a criação de uma laranja
 * especificando seu tipo.</p>
 * 
 */

public class Laranja extends Fruta{
	/**
     * Construtor da classe Laranja.
     * 
     * <p>Inicializa um objeto da classe {@code Laranja} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da laranja (por exemplo, "Laranja Pera", "Laranja Lima").
     */
	public Laranja (String tipo){
		super(tipo);
	}
}
