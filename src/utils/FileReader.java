package utils;
import estruturas.ListaPalavras;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileReader {
    public ListaPalavras readLines(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        StringBuilder textoBuilder = new StringBuilder();
        while (scan.hasNextLine()) {
            textoBuilder.append(scan.nextLine());
            textoBuilder.append("\n"); // Adiciona explicitamente a quebra de linha
        }

        String texto = textoBuilder.toString();

        ListaPalavras listaPalavras = new ListaPalavras();
        StringBuilder palavraBuilder = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                palavraBuilder.append(c);
            } else if (c == '\n') { // Se encontrar uma quebra de linha
                if (!palavraBuilder.isEmpty()) {
                    listaPalavras.add(palavraBuilder.toString());
                    palavraBuilder.setLength(0);
                }
                listaPalavras.add("\n"); // Adiciona a quebra de linha à lista
            } else if (!palavraBuilder.isEmpty()) {
                listaPalavras.add(palavraBuilder.toString());
                palavraBuilder.setLength(0);
            }
        }

// Se houver uma palavra pendente no final do texto
        if (!palavraBuilder.isEmpty()) {
            listaPalavras.add(palavraBuilder.toString());
        }

        return listaPalavras;
    }

    public ListaPalavras readKeyWords(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        ListaPalavras keyWordsList = new ListaPalavras();
        StringBuilder palavraBuilder = new StringBuilder();

        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);
                if (c != ',') {
                    palavraBuilder.append(c);
                } else {
                    keyWordsList.add(palavraBuilder.toString().trim());
                    palavraBuilder.setLength(0);
                }
            }
            if (palavraBuilder.length() > 0) {
                keyWordsList.add(palavraBuilder.toString().trim());
                palavraBuilder.setLength(0);
            }
        }

        return keyWordsList;
    }
}
