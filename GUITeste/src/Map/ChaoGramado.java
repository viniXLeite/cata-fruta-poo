package Map;
import Frutas.*;

public class ChaoGramado extends Chao{
	private Arvore arvore;
	private Fruta fruta;
	
	public ChaoGramado() {
		super("Chao Gramado");
		this.arvore = null;
		this.fruta = null;
		
		
	}
	
	public Arvore getArvore(){
    	return arvore;
    }
    
    public void setArvore(Arvore arvore) {
    	this.arvore = arvore;
    }
    
    public Fruta getFruta() {
    	return fruta;
    }
    
    public void setFruta(Fruta fruta) {
    	this.fruta = fruta;
    }

	
	
}
