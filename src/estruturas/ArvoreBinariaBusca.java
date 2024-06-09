package estruturas;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca {

    class Nodo {
        public String palavra;
        public ListaOcorrencias ocorrencias;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(String palavra, int ocorrencia) {
            this.palavra = palavra;
            this.ocorrencias = new ListaOcorrencias();
            this.ocorrencias.add(ocorrencia); // Adiciona a ocorrência inicialmente
            this.esquerdo = null;
            this.direito = null;
        }
    }

    private Nodo raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void insere(String palavra, int ocorrencia) {
        this.raiz = insereRecursivo(this.raiz, palavra, ocorrencia);
    }

    private Nodo insereRecursivo(Nodo nodo, String palavra, int ocorrencia) {
        if (nodo == null) {
            return new Nodo(palavra, ocorrencia);
        }

        if (palavra.compareTo(nodo.palavra) < 0) {
            nodo.esquerdo = insereRecursivo(nodo.esquerdo, palavra, ocorrencia);
        } else if (palavra.compareTo(nodo.palavra) > 0) {
            nodo.direito = insereRecursivo(nodo.direito, palavra, ocorrencia);
        } else {
            nodo.ocorrencias.add(ocorrencia);
        }
        return nodo;
    }

    public ListaOcorrencias busca(String palavra) {
        return buscaRecursiva(this.raiz, palavra);
    }

    private ListaOcorrencias buscaRecursiva(Nodo nodo, String palavra) {
        if (nodo == null) {
            return new ListaOcorrencias();
        }

        if (palavra.compareTo(nodo.palavra) < 0) {
            return buscaRecursiva(nodo.esquerdo, palavra);
        } else if (palavra.compareTo(nodo.palavra) > 0) {
            return buscaRecursiva(nodo.direito, palavra);
        } else {
            return nodo.ocorrencias;
        }
    }
}
