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
        char primeiraLetra = palavra.charAt(0);
        int chave = funcaoHashDJB2(primeiraLetra);
        this.vetor[chave].insere(palavra, indice);
    }

    private int funcaoHashDJB2(char primeiraLetra) {
        return primeiraLetra % this.capacidade;
    }
}
