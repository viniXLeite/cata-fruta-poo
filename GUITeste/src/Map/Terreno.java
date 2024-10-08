package Map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Frutas.*;


public class Terreno {
	public BufferedImage grama, pedra, aceroleiro;
	private Chao[][] tabuleiro;
	private int linhas, colunas;
	private int acumulador;
	private String nomeArv;
	
	
	public Terreno(int m, int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) {
		this.linhas = m;
		this.colunas = m;
		tabuleiro = new Chao[linhas][colunas];
		inicializarTerreno(m ,numPedras, nomeArvores, quantidadeArvores, quantidadeMaxArvores, frutasNoChao);
		
		
		try {
			grama = ImageIO.read(getClass().getResourceAsStream("/Map/grama.png"));
			pedra = ImageIO.read(getClass().getResourceAsStream("/Map/pedra.png"));
			aceroleiro = ImageIO.read(getClass().getResourceAsStream("/Map/acerola.png"));
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
	            	
	                gramado.setArvore(new Amoreiro(nomeArvore));
	                
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
		
		this.acumulador++;
		this.nomeArv = nomeArvores[0];
		
		//Vejo quais posições não estão com rocha e coloco grama, como pede a professora
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				if(!(tabuleiro[i][j] instanceof ChaoRochoso)) {
						tabuleiro[i][j] = new ChaoGramado();
				}
			}
		}
		
		//for(int i = 0; i < quantidadeMaxArvores; i++) {
			mapeiaArvore(nomeArvores[0], 2, frutasNoChao);
			mapeiaArvore(nomeArvores[1], 2, frutasNoChao);
			mapeiaArvore(nomeArvores[2], 2, frutasNoChao);
			mapeiaArvore(nomeArvores[3], 1, frutasNoChao);
			mapeiaArvore(nomeArvores[4], 1,  frutasNoChao);
			mapeiaArvore(nomeArvores[5], 1, frutasNoChao);
			
			mapeiaFrutaOuro(2, 1);
			
		//}
		
		
		
	}
	
	void inicializarTerreno(int m, int numPedras, String[] nomeArvores, int[] quantidadeArvores, int quantidadeMaxArvores, int frutasNoChao) {

	    inicializarComponentsMap(m, numPedras, nomeArvores, quantidadeArvores, quantidadeMaxArvores, frutasNoChao);

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < m; j++) {

	            if (tabuleiro[i][j] instanceof ChaoRochoso) {
	                System.out.print("P ");
	            }
	            // Verifica se é uma instância de ChaoGramado e se tem uma árvore
	            else if (tabuleiro[i][j] instanceof ChaoGramado) {
	                ChaoGramado gramado = (ChaoGramado) tabuleiro[i][j];
	                if (gramado.getArvore() != null) {
	                	
	                	Arvore arv = gramado.getArvore();
	                	String nomeArvore = arv.toString();
	                	
	                	if(nomeArvore.equals("laranja")) {
	                		System.out.print("l ");
	                	}
	                	else if(nomeArvore.equals("abacate")){
	                		System.out.print("a ");
	                	}
	                	else if(nomeArvore.equals("coco")){
	                		System.out.print("c ");
	                	}
	                	else if(nomeArvore.equals("acerola")){
	                		System.out.print("ac ");
	                	}
	                	else if(nomeArvore.equals("amora")){
	                		System.out.print("am ");
	                	}
	                	else {
	                		System.out.print("G ");
	                	}
	                	
	                } 
	                else if(gramado.getFruta() instanceof Maracuja) {
	                	System.out.print("M ");
	                }
	                else {
	                    System.out.print("g ");
	                }
	            } else {
	                System.out.print("g ");
	            }

	        }
	        System.out.println();
	    }
	    
	}
	
	
	
	public void draw(Graphics2D g) {
		
		
		if (grama == null) {
	        System.out.println("Erro: Imagem não carregada.");
	    } else {
			boolean green = true;
	        for (int i = 0; i < linhas; i++) {
	            for (int j = 0; j < colunas; j++) {
	                if (tabuleiro[i][j] instanceof ChaoGramado) {
	                	ChaoGramado gramado = (ChaoGramado) tabuleiro[i][j];
	                	if(gramado.getArvore() instanceof Aceroleiro) {
	                		g.drawImage(aceroleiro, i * 128, j * 128, 128, 128, null);
	                	}
	                	else {
	                		g.drawImage(grama, i * 128, j * 128, 128, 128, null);
	                	}
	                }
	                if(tabuleiro[i][j] instanceof ChaoRochoso) {
	                	g.drawImage(pedra, i * 128, j * 128, 128, 128, null);
	                    
	                }
	                
	                
	                
	                //green = ! green;
	            }
	            //green = !green;  // Alterna a cor a cada nova linha
	        }
	    }
        
        /*
        for(int i = 0; i < linhas; i++) {
        	for(int j = 0; j < colunas; j++) {
        		if(tabuleiro[i][j] instanceof ChaoGramado) {
        			g.setColor(Color.BLACK);
        		}
        	}
        }
        */
        
        
        
	}



	
	
	
	
}
