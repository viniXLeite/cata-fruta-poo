package Map;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Arvores.Abacateiro;
import Arvores.Aceroleiro;
import Arvores.Amoreira;
import Arvores.Arvore;
import Arvores.Coqueiro;
import Arvores.Goiabeira;
import Arvores.Laranjeira;
import Chao.Chao;
import Chao.ChaoGramado;
import Chao.ChaoRochoso;
import Frutas.Abacate;
import Frutas.Acerola;
import Frutas.Amora;
import Frutas.Coco;
import Frutas.Goiaba;
import Frutas.Laranja;
import Frutas.Maracuja;
import LeituraArquivos.Escrita;
import Mochila.*;


/**
 * Classe que representa o terreno, contendo um tabuleiro de células do tipo Chao.
 * As células podem ser grama ou rocha, e podem conter árvores e frutas.
 */

public class Terreno {
	public BufferedImage grama, pedra, aceroleiro, abacateiro, amoreira, coqueiro, goiabeira, maracuja, laranjeira;
	private static Chao[][] tabuleiro;
	private int linhas, colunas;
	//public static int aux;
	

	public Terreno(int m, int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) throws IOException {
		this.linhas = m;
		this.colunas = m;
		tabuleiro = new Chao[linhas][colunas];
		inicializarTerreno(m ,numPedras, nomeArvores, quantidadeArvores, quantidadeMaxArvores, frutasNoChao);
		
		
		try {
			grama = ImageIO.read(getClass().getResourceAsStream("/Imagens/grama.png"));
            pedra = ImageIO.read(getClass().getResourceAsStream("/Imagens/pedra_ok.png"));
            aceroleiro = ImageIO.read(getClass().getResourceAsStream("/Imagens/aceroleiro.png"));
            abacateiro = ImageIO.read(getClass().getResourceAsStream("/Imagens/abacateiro.png"));
            amoreira = ImageIO.read(getClass().getResourceAsStream("/Imagens/amoreira.png"));
            coqueiro = ImageIO.read(getClass().getResourceAsStream("/Imagens/coqueiro.png"));
            goiabeira = ImageIO.read(getClass().getResourceAsStream("/Imagens/goiabeira.png"));
            maracuja = ImageIO.read(getClass().getResourceAsStream("/Imagens/fruta_maracuja.png"));
            laranjeira = ImageIO.read(getClass().getResourceAsStream("/Imagens/laranjeira.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
	
	}
	
	public void mapeiaArvore(String nomeArvore, int quantidadeArvores, int frutasNoChao) {
	    int arvoresColocadas = 0;
	    int frutasColocadas = 0;
	    Random random = new Random();

	    while (arvoresColocadas < quantidadeArvores) {
	        int i_arvore = random.nextInt(linhas);
	        int j_arvore = random.nextInt(colunas);

	        if (tabuleiro[i_arvore][j_arvore] instanceof ChaoGramado) {
	            ChaoGramado gramado = (ChaoGramado) tabuleiro[i_arvore][j_arvore];

	            // Comparando strings usando equals() para garantir a comparação correta de conteúdo
	            if (nomeArvore.equals("laranja")) {
	            	
	                gramado.setArvore(new Laranjeira(nomeArvore));
	                
	            } else if (nomeArvore.equals("abacate")) {
	            	
	                gramado.setArvore(new Abacateiro(nomeArvore));
	                
	            } else if (nomeArvore.equals("coco")) {
	            	
	                gramado.setArvore(new Coqueiro(nomeArvore));
	                
	            } else if (nomeArvore.equals("acerola")) {
	            	
	                gramado.setArvore(new Aceroleiro(nomeArvore));
	                
	            } else if (nomeArvore.equals("amora")) {
	            	
	                gramado.setArvore(new Amoreira(nomeArvore));
	                
	            } else if (nomeArvore.equals("goiaba")) {
	            	
	                gramado.setArvore(new Goiabeira(nomeArvore));
	                
	            }
	            
	            arvoresColocadas++;
	        }
	    }
	    
	    
	    while(frutasColocadas < frutasNoChao) {
	    	int i_fruta = random.nextInt(linhas);
	        int j_fruta = random.nextInt(colunas);

	        if (tabuleiro[i_fruta][j_fruta] instanceof ChaoGramado) {
	            ChaoGramado gramado = (ChaoGramado) tabuleiro[i_fruta][j_fruta];
	            
	            if (nomeArvore.equals("laranja")) {
	            	
	                gramado.setFruta(new Laranja(nomeArvore));
	                
	            } else if (nomeArvore.equals("abacate")) {
	            	
	                gramado.setFruta(new Abacate(nomeArvore));
	                
	            } else if (nomeArvore.equals("coco")) {
	            	
	                gramado.setFruta(new Coco(nomeArvore));
	                
	            } else if (nomeArvore.equals("acerola")) {
	            	
	                gramado.setFruta(new Acerola(nomeArvore));
	                
	            } else if (nomeArvore.equals("amora")) {
	            	
	                gramado.setFruta(new Amora(nomeArvore));
	                
	            } else if (nomeArvore.equals("goiaba")) {
	            	
	                gramado.setFruta(new Goiaba(nomeArvore));
	                
	            }
	            
	            frutasColocadas++;
	        }
	    }
	}
	
	private void mapeiaFrutaOuro(int numTotal, int numPorRodada) {
		int frutasOuroColocadas = 0;
		
		Random random = new Random();
		
		while(frutasOuroColocadas < numPorRodada) {
			int i_fruta_ouro = random.nextInt(linhas);
			int j_fruta_ouro = random.nextInt(colunas);
			
			if(tabuleiro[i_fruta_ouro][j_fruta_ouro] instanceof ChaoGramado) {
				ChaoGramado gramado = (ChaoGramado)tabuleiro[i_fruta_ouro][j_fruta_ouro];
				
				if(gramado.getArvore() == null) {
					gramado.setFruta(new Maracuja("maracuja", numTotal));
				}
			}
			
			frutasOuroColocadas++;
			
		}
	} 


	
	private void inicializarComponentsMap(int m, int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) {
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
		
		for(int i = 1; i < quantidadeMaxArvores; i++) {
			mapeiaArvore(nomeArvores[i], quantidadeArvores[i], frutasNoChao);
		}
		
		
			
			mapeiaFrutaOuro(2, 1);	
		
		
		
	}
	
	void inicializarTerreno(int m, int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) throws IOException{
		Escrita escrever = new Escrita("terrenoGeradoTeste.txt");

	    inicializarComponentsMap(m, numPedras, nomeArvores, quantidadeArvores, quantidadeMaxArvores, frutasNoChao);

	    for (int i = 0; i < m; i++) {
			if (i != 0)
				escrever.pulaLinha();
	        for (int j = 0; j < m; j++) {
	            if (tabuleiro[i][j] instanceof ChaoRochoso) {
	                System.out.print("P ");
					escrever.escreve("Pe ");
	            }
	            // Verifica se é uma instância de ChaoGramado e se tem uma árvore
	            else if (tabuleiro[i][j] instanceof ChaoGramado) {
	                ChaoGramado gramado = (ChaoGramado) tabuleiro[i][j];
	                if (gramado.getArvore() != null) {
	                	
	                	Arvore arv = gramado.getArvore();
	                	String nomeArvore = arv.toString();
	                	
	                	if(nomeArvore.equals("laranja")) {
	                		System.out.print("l ");
							escrever.escreve("La ");
	                	}
	                	else if(nomeArvore.equals("abacate")){
	                		System.out.print("a ");
							escrever.escreve("Ab ");
	                	}
	                	else if(nomeArvore.equals("coco")){
	                		System.out.print("c ");
							escrever.escreve("Co ");
	                	}
	                	else if(nomeArvore.equals("acerola")){
	                		System.out.print("ac ");
							escrever.escreve("Ac ");
	                	}
	                	else if(nomeArvore.equals("amora")){
	                		System.out.print("am ");
							escrever.escreve("Am ");
	                	}
	                	else {
	                		System.out.print("G ");
							escrever.escreve("Gr ");
	                	}
	                	
	                } 
	                else if(gramado.getFruta() instanceof Maracuja) {
	                	System.out.print("M ");
						escrever.escreve("Ma ");
	                }
	                else {
	                    System.out.print("g ");
						escrever.escreve("Gr ");
	                }
	            } else {
	                System.out.print("g ");
					escrever.escreve("Gr ");
	            }

	        }
	        System.out.println();
	    }
	    escrever.fechar();
	}
/*	
	public void inicializePlayers(Jogador j1, Jogador j2) {
		Random random = new Random();
		boolean player1Acepted = false, player2Acepted = false;
		
		while(player1Acepted == false) {
			int i = random.nextInt(linhas);
			int j = random.nextInt(colunas);
			
			if(tabuleiro[i][j] instanceof ChaoGramado) {
				ChaoGramado gramado = (ChaoGramado) tabuleiro[i][j];
				gramado.setPlayer(new Jogador());
				player1Acepted = true;
			}
		}
		
		while(player2Acepted == false) {
			int i = random.nextInt(linhas);
			int j = random.nextInt(colunas);
			
			if(tabuleiro[i][j] instanceof ChaoGramado) {
				ChaoGramado gramado = (ChaoGramado) tabuleiro[i][j];
				gramado.setPlayer(new Jogador());
				player2Acepted = true;
			}
		}
	}
	*/
	
		
	public static Chao getPosition(int x, int y) {
		  return tabuleiro[x][y];
	}
	
	public static int sizeofMap() {
		return tabuleiro[0].length;
	}
	
	public static void addFruitinMyBag(Mochila p1, String key) {
	    p1.top++;
	    switch (key) {
	        case "acerola":
	            p1.mochila[p1.top++] = new Acerola(key);
	            break;
	        case "abacate":
	            p1.mochila[p1.top++] = new Abacate(key);
	            break;
	        case "laranja":
	            p1.mochila[p1.top++] = new Laranja(key);
	            break;
	        case "coco":
	            p1.mochila[p1.top++] = new Coco(key);
	            break;
	        case "amora":
	            p1.mochila[p1.top++] = new Amora(key);
	            break;
	        default:
	            p1.mochila[p1.top++] = new Goiaba(key);
	            break;
	    }
	}
	
	public void draw(Graphics2D g) {
		
		for (int i = 0; i < linhas; i++) {
	        for (int j = 0; j < colunas; j++) {
	        	
	            if (tabuleiro[i][j] instanceof ChaoRochoso) {
	            	g.drawImage(pedra, i * 128, j * 128, 128, 128, null);
	            }
	            // Verifica se é uma instância de ChaoGramado e se tem uma árvore
	            else if (tabuleiro[i][j] instanceof ChaoGramado) {
	                ChaoGramado gramado = (ChaoGramado) tabuleiro[i][j];
	                if (gramado.getArvore() != null) {
	                	
	                	Arvore arv = gramado.getArvore();
	                	String nomeArvore = arv.toString();
	                	
	                	if(nomeArvore.equals("laranja")) {
	                		g.drawImage(laranjeira, i * 128, j * 128, 128, 128, null);
	                	}
	                	else if(nomeArvore.equals("abacate")){
	                		g.drawImage(abacateiro, i * 128, j * 128, 128, 128, null);
	                	}
	                	else if(nomeArvore.equals("coco")){
	                		g.drawImage(coqueiro, i * 128, j * 128, 128, 128, null);
	                	}
	                	else if(nomeArvore.equals("acerola")){
	                		g.drawImage(aceroleiro, i * 128, j * 128, 128, 128, null);
	                	}
	                	else if(nomeArvore.equals("amora")){
	                		g.drawImage(amoreira, i * 128, j * 128, 128, 128, null);
	                	}
	                	else {
	                		g.drawImage(goiabeira, i * 128, j * 128, 128, 128, null);
	                	}
	                	
	                } 
	                else if(gramado.getFruta() instanceof Maracuja) {
	                	g.drawImage(maracuja, i * 128, j * 128, 128, 128, null);
	                }
	                else {
	                	g.drawImage(grama, i * 128, j * 128, 128, 128, null);
	                }
	            } else {
	            	g.drawImage(grama, i * 128, j * 128, 128, 128, null);
	            }

	        }
	        
	    }
	    
	}
		
		
        
        
	}



	
