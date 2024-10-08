package Frutas;

public class Fruta {
	private String tipo;

    // Construtor
    public Fruta(String tipo) {
        this.tipo = tipo;
    }

    
    public String getTipo() {
        return tipo;    
        }
    
    @Override
    public String toString() {
        return tipo;
    }
}