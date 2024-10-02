package Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        
        System.out.println("Digite o número de linhas do terreno:");
        int linhas = scanner.nextInt();
        System.out.println("Digite o número de colunas do terreno:");
        int colunas = scanner.nextInt();

        CriarMapa terreno = new CriarMapa(linhas, colunas);

        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.println("Digite o tipo de chão para a posição [" + i + ", " + j + "] (rochoso/grama):");
                String tipo = scanner.next();
                terreno.adicionarChao(i, j, tipo);
            }
        }

        // Exibir o terreno final
        System.out.println("\nTerreno final:");
        terreno.exibirTabuleiro();

	}

}
