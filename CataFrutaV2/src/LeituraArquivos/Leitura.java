package LeituraArquivos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * A classe {@code Leitura} é responsável por ler dados de um arquivo texto.
 * Ela permite ler linhas do arquivo e extrair números a partir de uma linha específica.
 */

public class Leitura {
    private String path;
    private BufferedReader buffRead;

    
    /**
     * Construtor da classe {@code Leitura}.
     * 
     * @param path O caminho do arquivo que será lido.
     * @throws IOException Se ocorrer um erro ao abrir o arquivo.
     */
    
    public Leitura(String path) throws IOException{
        this.path = path;
        this.buffRead = new BufferedReader(new FileReader(this.path));
    }

    
    /**
     * Lê uma linha do arquivo.
     * 
     * @return A linha lida, ou {@code null} se não houver mais linhas.
     * @throws IOException Se ocorrer um erro durante a leitura do arquivo.
     */
    
    public String ler() throws IOException {
        String linha = this.buffRead.readLine();
        if (linha != null) {
            System.out.println(linha);
            return linha;
        }else {
            return null;
        }
    }

    
    /**
     * Extrai um número inteiro da linha fornecida.
     * 
     * @param linha A linha de texto da qual o número será extraído.
     * @return O número extraído da linha.
     */
    
    public int numeroNaLinha(String linha) {
        String palavras[] = new String[2];
        palavras = linha.split(" ");
        int num = Integer.valueOf(palavras[1]);
        // System.out.println(num);
        return num;
    }
    
    
    /**
     * Fecha o leitor de arquivos.
     * 
     * @throws IOException Se ocorrer um erro ao fechar o leitor.
     */
    
    public void fechar() throws IOException {
        this.buffRead.close();
    }
}
