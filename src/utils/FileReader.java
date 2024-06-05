package utils;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileReader {
    public String[] readLines(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        StringBuilder textoBuilder = new StringBuilder();
        while (scan.hasNextLine()) {
            textoBuilder.append(scan.nextLine());
            textoBuilder.append("\n"); // Adiciona explicitamente a quebra de linha
        }

        String texto = textoBuilder.toString();

        // Dividir o texto em palavras mantendo as quebras de linha e caracteres especiais
        String[] palavras = texto.split("(?<=\\b\\s|\\p{Punct})|(?=\\b\\s|\\p{Punct})");

        // Process each word
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = palavras[i].toLowerCase(); // Convert to lowercase
        }
        return palavras;
    }

    public String[] readKeyWords(String filePath) throws IOException {

        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        String texto = "";
        while(scan.hasNextLine()){
            texto = texto.concat(scan.nextLine());
        }

        String[] keyWords;
        keyWords = texto.split(", ");

        return keyWords;
    }
}
