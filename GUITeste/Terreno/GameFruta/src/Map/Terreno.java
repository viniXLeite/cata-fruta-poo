package Map;
import java.util.Random;


public class Terreno {
	private Chao[][] tabuleiro;
	private int linhas, colunas;
	
	public Terreno(int m, int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) {
		this.linhas = m;
		this.colunas = m;
		tabuleiro = new Chao[linhas][colunas];
		inicializarTerreno(numPedras, nomeArvores, quantidadeArvores, quantidadeMaxArvores, frutasNoChao);
	}
	
	public void mapeiaArvore(String nomeArvore, int quantidadeArvores, Random random) {
		int arvoresColocadas = 0;
		
		while(arvoresColocadas < quantidadeArvores) {
			int i_arvore = random.nextInt(linhas);
			int j_arvore = random.nextInt(colunas);
			
			if(tabuleiro[i_arvore][j_arvore] instanceof ChaoGramado) {
				
				
				if(nomeArvore == "laranja") {
					tabuleiro[i_arvore][j_arvore].setArvore(new Laranjeira());
				}
				if(nomeArvore == "abacate") {
					tabuleiro[i_arvore][j_arvore].setArvore(new Abacateiro());
				}
				
				if(nomeArvore == "coco") {
					tabuleiro[i_arvore][j_arvore].setArvore(new Coqueiro());
				}
				
				if(nomeArvore == "acerola") {
					tabuleiro[i_arvore][j_arvore].setArvore(new Aceroleiro());
				}
				
				if(nomeArvore == "amora") {
					tabuleiro[i_arvore][j_arvore].setArvore(new Amoreiro());
				}
				
				if(nomeArvore == "goiaba") {
					tabuleiro[i_arvore][j_arvore].setArvore(new Goiabeira());
				}
			}
		}
		
	}
	
	private void inicializarTerreno(int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) {
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
		
		
		for(int i = 0; i < quantidadeMaxArvores; i++) {
			mapeiaArvore(nomeArvores[i], quantidadeArvores[i], random);
		}
		
		
		
	}
	
	
	
	
}
