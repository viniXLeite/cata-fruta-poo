package Dado;
import java.util.Random;

/**
 * A classe {@code Dado} representa um dado de seis lados que gera um número aleatório entre 1 e 6.
 * Essa classe é utilizada para definir a ordem dos turnos dos jogadores em um jogo.
 * 
 * <p>Exemplo de uso:
 * <pre>
 *     Dado dado = new Dado();
 *     int resultado = dado.rolar();
 *     System.out.println("Resultado do dado: " + resultado);
 * </pre>
 * </p>
 */

public class Dado {

    /**
     * Gera um número aleatório entre 1 e 6, simulando o lançamento de um dado.
     * 
     * @return um número inteiro entre 1 e 6 representando o valor sorteado.
     */
    
    public static int rolar() {
        Random random = new Random();

        int resultadoDado = random.nextInt(6)+1;
        return resultadoDado;
    }
}