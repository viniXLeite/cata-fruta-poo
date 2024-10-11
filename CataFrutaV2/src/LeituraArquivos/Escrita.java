package LeituraArquivos;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Escrita {
    PrintStream ps;

    public Escrita(String caminho) throws IOException {

        //define os como stream pra arquivo
        OutputStream os = new FileOutputStream(caminho);
        //ps é um objeto que imprime nessa stream
        this.ps = new PrintStream(os);

        // Escreve o objeto String no arquivo
    }

    // Cria uma String que será gravada
    private String criarString(String txt) {

        // ByteArrayOutputStream mantém a saída em um array
        // e permite recuperá-lo posteriormente
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // PrintStream permite imprimir tipos primitivos,
        // Strings e Objetos. Facilita também a inclusão
        // de separadores de linha
        PrintStream ps = new PrintStream(baos);

        // Escreve no PrintStream o número de linhas especificado
        // contendo o número da linha e uma String na forma
        // NomeX, onde X representa o nome da linha
        ps.print(txt);

        return baos.toString();
    }

    public void escreve(String txt) {
        this.ps.print(criarString(txt));
        this.ps.flush(); // Força a escrita dos buffers
    }

    public void pulaLinha() {
        this.ps.print(criarString("\n"));
        this.ps.flush(); // Força a escrita dos buffers
    }

    public void fechar() {
        this.ps.close(); // Fecha a stream
    }
}