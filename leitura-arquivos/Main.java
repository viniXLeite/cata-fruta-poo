import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Leitura Leitor = new Leitura("a.txt");
        
        String linha = "";

        while (linha != null){
            Leitor.ler();
        }

        Leitor.fechar();
    }
}