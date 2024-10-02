package Map;

public abstract class Chao {
    private String tipo;

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
}