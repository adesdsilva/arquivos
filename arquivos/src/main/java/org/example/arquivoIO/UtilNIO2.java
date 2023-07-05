package org.example.arquivoIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilNIO2 {

    private static final String MEU_ARQUIVO2 = "caminho_do_arquivo" + File.separator + "nome_do_arquvivo.txt";

    public UtilNIO2(){
        try {
            escreverArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("*****************************************");
        try {
            lerArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void escreverArquivo() throws IOException {
        final Path path = Paths.get(MEU_ARQUIVO2);
        Files.writeString(path, "Meu arquivo NIO-2");
        System.out.println("Dados gravados no arquivo com sucesso!");
    }

    private void lerArquivo() throws IOException {
        final Path path = Paths.get(MEU_ARQUIVO2);
        Files.readAllLines(path)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new UtilNIO2();
    }
}
