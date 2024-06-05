package estruturas;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca {

    class Nodo {
        public String palavra;
        public List<Integer> indices;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(String palavra, int indice) {
            this.palavra = palavra;
            this.indices = new ArrayList<>();
            this.indices.add(indice); // Adiciona o índice inicialmente
            this.esquerdo = null;
            this.direito = null;
        }
    }

    public Nodo raiz;
    public int nElementos;

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public void insere(String palavra, int indice) {
        this.raiz = insereRecursivo(this.raiz, palavra, indice);
    }

    private Nodo insereRecursivo(Nodo nodo, String palavra, int indice) {
        if (nodo == null) {
            return new Nodo(palavra, indice);
        }

        if (palavra.compareTo(nodo.palavra) < 0) {
            nodo.esquerdo = insereRecursivo(nodo.esquerdo, palavra, indice);
        } else if (palavra.compareTo(nodo.palavra) > 0) {
            nodo.direito = insereRecursivo(nodo.direito, palavra, indice);
        } else {
            nodo.indices.add(indice);
        }
        return nodo;
    }

    private Nodo maiorElemento(Nodo nodo) {
        while (nodo.direito != null) {
            nodo = nodo.direito;
        }
        return nodo;
    }

    private Nodo menorElemento(Nodo nodo) {
        while (nodo.esquerdo != null) {
            nodo = nodo.esquerdo;
        }
        return nodo;
    }

    public boolean busca(String palavra) {
        return !buscaRecursiva(this.raiz, palavra).isEmpty();
    }

    private List<Integer> buscaRecursiva(Nodo nodo, String palavra) {
        if (nodo == null) {
            return new ArrayList<>(); // Palavra não encontrada, retorna uma lista vazia
        }

        if (palavra.compareTo(nodo.palavra) < 0) {
            return buscaRecursiva(nodo.esquerdo, palavra);
        } else if (palavra.compareTo(nodo.palavra) > 0) {
            return buscaRecursiva(nodo.direito, palavra);
        } else {
            return nodo.indices;
        }
    }

    private int altura(Nodo nodo) {

        if (nodo == null) {
            return -1;
        }

        int alturaEsquerda = this.altura(nodo.esquerdo) + 1;
        int alturaDireita = this.altura(nodo.direito) + 1;

        int altura = alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;

        return altura;

    }

    public int altura() {
        return this.altura(this.raiz);
    }
}
