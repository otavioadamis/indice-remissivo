package utils;
import estruturas.ListaPalavras;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileReader {
    public ListaPalavras readLines(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        String texto = "";

        while (scan.hasNextLine()) {
            texto += (scan.nextLine());
            texto += "\n"; //Adicionando quebra de linha para verificar mais tarde em outras funcoes
        }

        ListaPalavras listaPalavras = new ListaPalavras();
        String palavra = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                palavra += (c);
            } else if (c == '\n') { // Se encontrar uma quebra de linha
                if (!palavra.isEmpty()) {
                    listaPalavras.add(palavra);
                    palavra = "";
                }
                listaPalavras.add("\n"); // Adiciona a quebra de linha à lista
            } else if (!palavra.isEmpty()) {
                listaPalavras.add(palavra);
                palavra = "";
            }
        }

        // Se houver uma palavra pendente no final do texto
        if (!palavra.isEmpty()) {
            listaPalavras.add(palavra);
        }
        return listaPalavras;
    }

    public ListaPalavras readKeyWords(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        ListaPalavras keyWordsList = new ListaPalavras();
        String palavra = "";

        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);
                if (c != ',') {
                    palavra += (c);
                } else {
                    keyWordsList.add(palavra.trim());
                    palavra = "";
                }
            }
            if (palavra.length() > 0) {
                keyWordsList.add(palavra.trim());
                palavra = "";
            }
        }
        return keyWordsList;
    }
}
