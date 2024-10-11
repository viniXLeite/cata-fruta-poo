package Arvores;


/**
 * Representa uma árvore genérica no jogo.
 * 
 * <p>A classe {@code Arvore} é a classe base para diferentes tipos de árvores. 
 * Ela pode ser estendida para representar árvores específicas.</p>
 */

public class Arvore{
    private String tipo;

    
    
    /**
     * Construtor da classe Arvore.
     * 
     * <p>Inicializa um objeto da classe {@code Arvore} com o tipo fornecido.</p>
     * 
     * @param tipo O tipo da árvore.
     */
    
    // Construtor
    public Arvore(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Retorna o tipo da árvore.
     * 
     * @return O tipo da árvore.
     */
    
    public String getTipo() {
        return tipo;
    }
    
    
    /**
     * Converte o objeto {@code Arvore} em uma string representando seu tipo.
     * 
     * @return Uma string representando o tipo da árvore.
     */
    @Override
    public String toString() {
        return tipo;
    }
}
