package Map;
import java.util.Random;


public class Terreno {
	private Chao[][] tabuleiro;
	private int linhas, colunas;
	
	public Terreno(int m, int numPedras) {
		this.linhas = m;
		this.colunas = m;
		tabuleiro = new Chao[linhas][colunas];
	}
	
	private void inicializarTerreno(int numPedras) {
		Random random = new Random();
		int pedrasColocadas = 0;
		
		//Gera posições aleatorias no terreno para  colocar as pedras definidas pelo usuário
		while(pedrasColocadas < numPedras) {
			int linhaAleatoria = random.nextInt(linhas);
			int colunaAleatoria = random.nextInt(colunas);
			
			if(!(tabuleiro[linhaAleatoria][colunaAleatoria] instanceof ChaoRochoso)) {
				tabuleiro[linhaAleatoria][colunaAleatoria] = new ChaoRochoso();
				pedrasColocadas++;
			}
			
		}
		
		//Vejo quais posições não estão com rocha e coloco grama, como pede a professora
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				if(!(tabuleiro[i][j] instanceof ChaoRochoso)) {
					tabuleiro[i][j] = new ChaoGramado();
				}
			}
		}
		
	}
	
	
	
	
}
