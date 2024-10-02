import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {
    private String path;
    private BufferedReader buffRead;

    public Leitura(String path) throws IOException{
        this.path = path;
        this.buffRead = new BufferedReader(new FileReader(this.path));
    }

    public String ler() throws IOException {
        String linha = this.buffRead.readLine();
        if (linha != null) {
            // System.out.println(linha);
            return linha;
        }else {
            return null;
        }
    }

    public int numeroNaLinha(String linha) {
        String palavras[] = new String[2];
        palavras = linha.split(" ");
        int num = Integer.valueOf(palavras[1]);
        return num;
    }
    
    public void fechar() throws IOException {
        this.buffRead.close();
    }
}
