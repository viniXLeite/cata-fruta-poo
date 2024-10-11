package Frutas;

/**
 * Representa uma fruta específica do tipo coco.
 * 
 * <p>A classe {@code Coco} herda de {@link Fruta} e permite a criação de um coco
 * especificando seu tipo.</p>
 * 
 */

public class Coco extends Fruta{
	
	/**
     * Construtor da classe Coco.
     * 
     * <p>Inicializa um objeto da classe {@code Coco} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo do coco (por exemplo, "Coco Verde", "Coco Seco").
     */
	
	public Coco (String tipo){
		super(tipo);
	}
}