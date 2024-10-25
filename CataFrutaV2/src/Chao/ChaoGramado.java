package Chao;
import Frutas.*;
import Arvores.*;



/**
 * Classe filha de {@code Chao}, que pode conter uma árvore ou uma fruta.
 */
public class ChaoGramado extends Chao{
	private Arvore arvore;
	private Fruta fruta;
	
	/**
     * Construtor da classe {@code ChaoGramado}.
     * Inicializa um chão gramado sem árvore e sem fruta.
     */
	
	public ChaoGramado() {
		super("Chao Gramado");
		this.arvore = null;
		this.fruta = null;
		
		
	}
	
	/**
     * Retorna uma arvore
     */
	
	public Arvore getArvore(){
    	return arvore;
    }
    
	/**
     * Atribui uma instância da classe {@code Arvore}.
     * 
     * @param arvore A árvore a ser atribuída ao chão gramado.
     */
    public void setArvore(Arvore arvore) {
    	this.arvore = arvore;
    }
    
    /**
     * Retorna a fruta contida no chão gramado.
     * 
     * @return A fruta contida no chão, ou {@code null} se não houver.
     */
    
    public Fruta getFruta() {
    	return fruta;
    }
    
    /**
     * Atribui uma instância da classe {@code Fruta}.
     * 
     * @param fruta A fruta a ser atribuída ao chão gramado.
     */
    
    public void setFruta(Fruta fruta) {
    	this.fruta = fruta;
    }
    
  
	
	
}
