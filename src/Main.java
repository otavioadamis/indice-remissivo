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
        String[] keyWords = fileReader.readKeyWords("C:\\Users\\otavi\\Desktop\\KeyWords.txt");

        String indiceRemissivo = generateIndex(palavrasTexto, keyWords);

        FileWriter writer = new FileWriter();
        writer.writeLines("C:\\Users\\otavi\\Desktop\\IndiceRemissivo.txt", indiceRemissivo);
    }

    public static String generateIndex(ListaPalavras texto, String[] palavrasChave) {

        StringBuilder indiceRemissivo = new StringBuilder();

        // Para cada palavra-chave
        for (String palavra : palavrasChave) {
            ListaOcorrencias ocorrencias = new ListaOcorrencias();

            // Iterar sobre o texto para encontrar as ocorrências da palavra-chave
            for (int i = 0; i < texto.size(); i++) {
                if (texto.get(i).equalsIgnoreCase(palavra)) {
                    // Adiciona o número da linha onde a palavra ocorre
                    int numeroLinha = obterNumeroLinha(texto, i);
                    ocorrencias.add(numeroLinha);
                }
            }

            // Construir a entrada do índice remissivo para esta palavra-chave
            if (!ocorrencias.isEmpty()) {
                indiceRemissivo.append(palavra).append(": ");
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