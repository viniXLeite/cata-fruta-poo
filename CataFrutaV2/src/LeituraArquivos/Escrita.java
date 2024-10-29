package LeituraArquivos;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * A classe {@code Escrita} permite escrever dados de texto em um arquivo, com funcionalidades para criar
 * strings customizadas e incluir quebras de linha. Utiliza {@link PrintStream} para realizar a escrita
 * no arquivo.
 * 
 * <p>A classe oferece métodos para criar uma string formatada, escrever no arquivo e incluir uma
 * quebra de linha. Também possui um método para fechar a stream de escrita e liberar os recursos.</p>
 */
public class Escrita {
    /**
     * {@link PrintStream} utilizado para escrever no arquivo especificado.
     */
    private PrintStream ps;

    /**
     * Construtor que inicializa o {@code PrintStream} para o arquivo especificado pelo caminho.
     *
     * @param caminho o caminho do arquivo onde os dados serão escritos
     * @throws IOException se ocorrer um erro ao abrir ou criar o arquivo
     */
    public Escrita(String caminho) throws IOException {
        OutputStream os = new FileOutputStream(caminho);
        this.ps = new PrintStream(os);
    }

    /**
     * Cria uma string a partir do texto fornecido.
     *
     * <p>Este método utiliza um {@link ByteArrayOutputStream} para armazenar a saída em um array de bytes,
     * permitindo recuperar a string formatada posteriormente. A string é construída utilizando
     * {@code PrintStream} para adicionar uma nova linha, se necessário.</p>
     *
     * @param txt o texto a ser convertido em string formatada
     * @return a string formatada com o conteúdo de {@code txt}
     */
    private String criarString(String txt) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ps.print(txt);
        return baos.toString();
    }

    /**
     * Escreve o texto especificado no arquivo.
     *
     * <p>O texto é formatado pelo método {@code criarString} antes de ser escrito, e o método
     * {@code flush} é chamado para garantir que os dados sejam imediatamente gravados no arquivo.</p>
     *
     * @param txt o texto a ser escrito no arquivo
     */
    public void escreve(String txt) {
        this.ps.print(criarString(txt));
        this.ps.flush();
    }

    /**
     * Escreve uma quebra de linha no arquivo.
     *
     * <p>Utiliza o método {@code criarString} para gerar a quebra de linha e {@code flush}
     * para garantir a escrita imediata no arquivo.</p>
     */
    public void pulaLinha() {
        this.ps.print(criarString("\n"));
        this.ps.flush();
    }

    /**
     * Fecha o {@link PrintStream} e libera os recursos associados.
     *
     * <p>Deve ser chamado após todas as operações de escrita para garantir que o arquivo
     * seja fechado corretamente.</p>
     */
    public void fechar() {
        this.ps.close();
    }
}
