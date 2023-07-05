package org.example.arquivoIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ArquivoJavaIO {
    private static final String MEU_ARQUIVO2 = "//home//adelino//Maven" + File.separator + "arquivo-io.txt";
    public ArquivoJavaIO(){
//        try{
//            final File file = new File(MEU_ARQUIVO2);
//            if(!file.exists()){
//                file.createNewFile();
//                System.out.println(file.exists());
//            }
//            System.out.println(file.getAbsolutePath());
//        }catch (IOException ioException){
//            ioException.printStackTrace();
//        }
        escreverArquivo();
        lerArquivo();
    }

    private void escreverArquivo() {
//        final File file = new File(MEU_ARQUIVO2);
//        boolean arquivoCriado = false;
//        if(!file.exists()){
//            arquivoCriado = file.createNewFile();
//        }
//        if(arquivoCriado || file.exists()){
        OutputStream outputStream = null;
        final var conteudo = "Meu arquivo IO.";
        try{
            outputStream = new FileOutputStream(MEU_ARQUIVO2);
            outputStream.write(conteudo.getBytes("UTF-8"));
            outputStream.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        System.out.println("Dados gravados no arquivo.");
//        }
    }

    private void lerArquivo() {
//        InputStream inputStream = null;
        //reduzindo a verbosidade
//        try (final InputStream input = new FileInputStream(MEU_ARQUIVO2)){
//            int conteudo;
//            while ((conteudo = input.read()) != -1) {
//                System.out.print((char) conteudo);
//            }
//        }catch (IOException ioException){
//            ioException.printStackTrace();
//        }
        //outra forma de reduzir a verbosidade com FileReader
        try(final FileReader file = new FileReader(MEU_ARQUIVO2)){
            int conteudo = file.read();
            while (conteudo != -1){
                System.out.print((char) conteudo);
                conteudo = file.read();
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }

//        try {
//            inputStream = new FileInputStream(MEU_ARQUIVO2);
//            int conteudo;
//            while ((conteudo = inputStream.read()) != -1) {
//                System.out.print((char) conteudo);
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//            ;
//        } finally {
//            if(inputStream != null){
//                try {
//                    inputStream.close();
//                }catch (IOException ioException){
//                    ioException.printStackTrace();
//                }
//            }
//        }

    }

    public static void main(String[] args) {
        new ArquivoJavaIO();
    }
}
