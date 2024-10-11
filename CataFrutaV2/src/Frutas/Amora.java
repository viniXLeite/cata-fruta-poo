package Frutas;

/**
 * Representa uma fruta específica do tipo amora.
 * 
 * <p>A classe {@code Amora} herda de {@link Fruta} e permite a criação de uma amora
 * especificando seu tipo.</p>
 * 
 */

public class Amora extends Fruta{
	
	/**
     * Construtor da classe Amora.
     * 
     * <p>Inicializa um objeto da classe {@code Amora} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da amora (por exemplo, "Amora Preta").
     */
	
	public Amora(String tipo){
		super(tipo);
	}
}