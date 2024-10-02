package Map;

import java.io.IOException;

public class InicializarMap {
    public static void inicilizarTerreno(String path) throws IOException{
		Leitura Leitor = new Leitura(path);
		String linha;
		String nomeArvores[];
		int quantidadeArvores[]; 
		nomeArvores = new String[7];
		quantidadeArvores = new int[7];
		int frutasNoChao = 0, quantidadeMaximaArvores = 0;
		String palavras[] = new String[3];
		// leitura do arquivo
		// Dimensao e numero de pedras
		linha = Leitor.ler();
		int dimensao = Leitor.numeroNaLinha(linha);
		linha = Leitor.ler();
		int pedras = Leitor.numeroNaLinha(linha);
		// leitura das frutas
		for(int i = 0; i < 7; i++) {
			linha = Leitor.ler();
			palavras = linha.split(" ");
			nomeArvores[i] = palavras[0];
			quantidadeArvores[i] = Integer.valueOf(palavras[1]);
			frutasNoChao += Integer.valueOf(palavras[2]);
		}
		linha = Leitor.ler();
		int bichadas = Leitor.numeroNaLinha(linha);
		linha = Leitor.ler();
		int mochila = Leitor.numeroNaLinha(linha);

		Terreno mapa = new Terreno(dimensao, pedras, nomeArvores, quantidadeArvores, quantidadeMaximaArvores, frutasNoChao);
		Leitor.fechar();
    }
}
