package estruturas;
import estruturas.ArvoreBinariaBusca;
import java.util.ArrayList;
import java.util.List;

public class HashGenerico<T> {

    public ArvoreBinariaBusca[] vetor;
    public int capacidade;

    public HashGenerico(int capacidade) {
        this.capacidade = capacidade;
        this.vetor = new ArvoreBinariaBusca[capacidade];
        for (int i = 0; i < capacidade; i++) {
            this.vetor[i] = new ArvoreBinariaBusca();
        }
    }

    public int tamanho() {
        return this.capacidade;
    }

    public void insere(String palavra, int indice) {
        char primeiraLetra = palavra.charAt(0); // Obtém a primeira letra da palavra
        int chave = funcaoHashDJB2(primeiraLetra); // Calcula a posição na tabela hash

        this.vetor[chave].insere(palavra, indice); // Insere na árvore binária de busca correspondente
    }

    public boolean contem(String palavra) {
        int chave = funcaoHashDJB2(palavra.charAt(0));
        return this.vetor[chave].busca(palavra);
    }

    // Método de hash DJB2 modificado para usar apenas a primeira letra
    private int funcaoHashDJB2(char primeiraLetra) {
        return primeiraLetra % this.capacidade;
    }
}
