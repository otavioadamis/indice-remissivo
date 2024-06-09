import estruturas.ArvoreBinariaBusca;
import estruturas.ListaOcorrencias;
import estruturas.ListaPalavras;
import utils.FileReader;
import utils.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();

        ListaPalavras palavrasTexto  = fileReader.readLines(System.getProperty("user.home") + "\\Desktop\\Texto.txt");
        ListaPalavras keyWords = fileReader.readKeyWords(System.getProperty("user.home") + "\\Desktop\\KeyWords.txt");

        String indiceRemissivo = generateIndex(palavrasTexto, keyWords);

        FileWriter writer = new FileWriter();
        writer.writeLines(System.getProperty("user.home") + "\\Desktop\\IndiceRemissivo.txt", indiceRemissivo);
    }

    public static String generateIndex(ListaPalavras texto, ListaPalavras palavrasChave) {
        String indiceRemissivo = "";
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        int numLinhaAtual = 1;
        for (int i = 0; i < texto.size(); i++) {
            String palavra = texto.get(i);

            if (!palavra.equals("\n")) {
                arvore.insere(palavra, numLinhaAtual);
            }
            else{numLinhaAtual++;}
        }

        // Gerar índice remissivo para cada palavra-chave
        for (int k = 0; k < palavrasChave.size(); k++) {
            String keyWord = palavrasChave.get(k);
            ListaOcorrencias ocorrencias = arvore.busca(keyWord);

            if (!ocorrencias.isEmpty()) {
                indiceRemissivo += (keyWord) + (": ");

                for (int j = 0; j < ocorrencias.size(); j++) {
                    indiceRemissivo += (ocorrencias.get(j));

                    if (j < ocorrencias.size() - 1) {
                        indiceRemissivo += (", ");
                    }
                }
                indiceRemissivo += ("\n");
            }
        }
        return indiceRemissivo;
    }
}