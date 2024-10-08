package Map;

public class Arvore{
    private String tipo;

    // Construtor
    public Arvore(String tipo) {
        this.tipo = tipo;
    }

    // Getter para o tipo de árvore
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
        return tipo;
    }
}
