package Map;

public abstract class Chao {
    private String tipo;
    private Arvore arvore;

    // Construtor
    public Chao(String tipo) {
        this.tipo = tipo;
    }

    // Método concreto
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Arvore getArvore(){
    	return arvore;
    }
    
    public void setArvore(Arvore arvore) {
    	this.arvore = arvore;
    }
}