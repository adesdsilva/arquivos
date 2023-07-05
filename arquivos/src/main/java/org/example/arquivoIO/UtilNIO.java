package org.example.arquivoIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class UtilNIO {

    private static final String MEU_ARQUIVO2 = "//home//adelino//Maven" + File.separator + "arquivo-nio.txt";
    public UtilNIO(){
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
        final RandomAccessFile file = new RandomAccessFile(MEU_ARQUIVO2, "rw");
        final FileChannel channel = file.getChannel();
        channel.write(ByteBuffer.wrap("Meu arquivo NIO".getBytes(StandardCharsets.UTF_8)));
        channel.close();
        file.close();
        System.out.println("Dados gravados no arquivo.");
    }

    private void lerArquivo() throws IOException {
        final RandomAccessFile file = new RandomAccessFile(MEU_ARQUIVO2, "rw");
        final FileChannel channel = file.getChannel();
        final var fileSize = channel.size();
        final ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileSize);
        channel.read(byteBuffer);
        byteBuffer.flip();
        for(int i = 0; i < fileSize; i++){
            System.out.print((char)byteBuffer.get());
        }
        channel.close();
        file.close();
    }

    public static void main(String[] args) {
        new UtilNIO();
    }

}
