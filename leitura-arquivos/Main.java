import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Leitura Leitor = new Leitura("a.txt");
        
        String linha = "";
        int num;

        while (true){
            linha = Leitor.ler();
            if (linha == null)
                break;
            num = Leitor.numeroNaLinha(linha);
            System.out.println(num);
        }

        Leitor.fechar();
    }
}