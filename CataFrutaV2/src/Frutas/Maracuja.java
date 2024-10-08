package Frutas;

public class Maracuja extends Fruta{
	private int quantidadePorJogo;
	
	public Maracuja (String tipo, int quantidade){
		super(tipo);
		this.quantidadePorJogo = quantidade;
	}
	
	public int getQuantidadePorJogo() {
		return this.quantidadePorJogo;
	}
}
