package estruturas;
import java.util.NoSuchElementException;

public class ListaSimplesmenteEncadeada {
    private static class Nodo {
        public String palavra;
        public Nodo proximo;

        public Nodo(String palavra) {
            this.palavra = palavra;
            this.proximo = null;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;
    private int tamanho;

    public ListaSimplesmenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void insereInicio(String palavra) {
        Nodo novoNodo = new Nodo(palavra);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            novoNodo.proximo = primeiro;
            primeiro = novoNodo;
        }
        tamanho++;
    }

    public void removeInicio() {
        if (primeiro == null) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            primeiro = primeiro.proximo;
            tamanho--;
            if (tamanho == 0) {
                ultimo = null;
            }
        }
    }


    public void insereFinal(String palavra) {
        Nodo novoNodo = new Nodo(palavra);
        if (ultimo == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public void removeFinal() {
        if (ultimo == null) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;
            } else {
                Nodo atual = primeiro;
                while (atual.proximo != ultimo) {
                    atual = atual.proximo;
                }
                atual.proximo = null;
                ultimo = atual;
            }
            tamanho--;
        }
    }

    public void inserePosicao(String palavra, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            insereInicio(palavra);
        } else if (posicao == tamanho) {
            insereFinal(palavra);
        } else {
            Nodo novoNodo = new Nodo(palavra);
            Nodo atual = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novoNodo.proximo = atual.proximo;
            atual.proximo = novoNodo;
            tamanho++;
        }
    }

    public void removePosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            removeInicio();
        } else if (posicao == tamanho - 1) {
            removeFinal();
        } else {
            Nodo atual = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
            tamanho--;
        }
    }

    public void imprimirLista() {
        Nodo atual = primeiro;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.palavra + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
