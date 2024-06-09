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
            texto += "\n";
        }

        ListaPalavras listaPalavras = new ListaPalavras();
        String palavra = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                palavra += (c);
            }
            else if (c == '\n') {
                if (!palavra.isEmpty()) {
                    listaPalavras.add(palavra);
                    palavra = "";
                }
                listaPalavras.add("\n");
            }
            else if (!palavra.isEmpty()) {
                listaPalavras.add(palavra);
                palavra = "";
            }
        }

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
