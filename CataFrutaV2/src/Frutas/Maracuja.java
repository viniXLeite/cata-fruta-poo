package Frutas;

/**
 * Representa uma fruta específica do tipo maracujá.
 * 
 * <p>A classe {@code Maracuja} herda de {@link Fruta} e permite a criação de um maracujá
 * especificando seu tipo e a quantidade associada por jogo.</p>
 * 
 */

public class Maracuja extends Fruta{
	private int quantidadePorJogo;
	
	/**
     * Construtor da classe Maracuja.
     * 
     * <p>Inicializa um objeto da classe {@code Maracuja} com o tipo fornecido e a quantidade por jogo.</p>
     * 
     * @param tipo O tipo do maracujá (por exemplo, "Maracujá Amarelo").
     * @param quantidade A quantidade de maracujás por jogo.
     */
	
	public Maracuja (String tipo, int quantidade){
		super(tipo);
		this.quantidadePorJogo = quantidade;
	}
	
	/**
     * Retorna a quantidade de maracujás por jogo.
     * 
     * @return A quantidade de maracujás por jogo.
     */
	
	public int getQuantidadePorJogo() {
		return this.quantidadePorJogo;
	}
}
