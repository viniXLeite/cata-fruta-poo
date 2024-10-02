package Map;

public class Terreno {
	private Chao[][] tabuleiro;
	private int linhas, colunas;
	
	public Terreno(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		tabuleiro = new Chao[linhas][colunas];
	}
	
	public void adicionarChao(int linha, int coluna, String tipo) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            System.out.println("Posição inválida!");
            return;
        }

        switch (tipo.toLowerCase()) {
            case "rochoso":
                tabuleiro[linha][coluna] = new ChaoRochoso();
                break;
            case "grama":
                tabuleiro[linha][coluna] = new ChaoGramado();
                break;
            default:
                System.out.println("Tipo de chão inválido!");
                return;
        }
        System.out.println("Chão do tipo " + tipo + " adicionado na posição [" + linha + ", " + coluna + "].");
    }
	
	public void exibirTabuleiro(){
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				if (tabuleiro[i][j] != null) {
                    System.out.print(tabuleiro[i][j].getTipo() + " | ");
                } else {
                    System.out.print("Vazio | ");
                }
            System.out.println();
			}
		}
	}
	
	
}
