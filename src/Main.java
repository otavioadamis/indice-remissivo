import estruturas.ArvoreBinariaBusca;
import estruturas.ListaOcorrencias;
import estruturas.ListaPalavras;
import utils.FileReader;
import utils.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();

        ListaPalavras palavrasTexto  = fileReader.readLines("C:\\Users\\otavi\\Desktop\\Texto.txt");
        ListaPalavras keyWords = fileReader.readKeyWords("C:\\Users\\otavi\\Desktop\\KeyWords.txt");

        String indiceRemissivo = generateIndex(palavrasTexto, keyWords);

        FileWriter writer = new FileWriter();
        writer.writeLines("C:\\Users\\otavi\\Desktop\\IndiceRemissivo.txt", indiceRemissivo);
    }


    public static String generateIndex(ListaPalavras texto, ListaPalavras palavrasChave) {
        StringBuilder indiceRemissivo = new StringBuilder();

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        // Inserir palavras do texto na árvore com seus índices de linha
        for (int i = 0; i < texto.size(); i++) {
            String palavra = texto.get(i).replaceAll("\\s", ""); // Remover espaços
            if (!palavra.isEmpty() && !palavra.equals("\n")) {
                int numeroLinha = obterNumeroLinha(texto, i);
                arvore.insere(palavra, numeroLinha);
            }
        }

        // Gerar índice remissivo para cada palavra-chave
        for (int k = 0; k < palavrasChave.size(); k++) {
            String keyWord = palavrasChave.get(k);
            List<Integer> ocorrencias = arvore.busca(keyWord);

            if (!ocorrencias.isEmpty()) {
                indiceRemissivo.append(keyWord).append(": ");
                for (int j = 0; j < ocorrencias.size(); j++) {
                    indiceRemissivo.append(ocorrencias.get(j));
                    if (j < ocorrencias.size() - 1) {
                        indiceRemissivo.append(", ");
                    }
                }
                indiceRemissivo.append("\n");
            }
        }
        return indiceRemissivo.toString();
    }

    private static int obterNumeroLinha(ListaPalavras texto, int indicePalavra) {
        int numeroLinha = 1; // Começa da linha 1
        // Conta as quebras de linha antes do índice da palavra
        for (int i = 0; i < indicePalavra; i++) {
            if (texto.get(i).contains("\n")) {
                numeroLinha++;
            }
        }
        return numeroLinha;
    }
}