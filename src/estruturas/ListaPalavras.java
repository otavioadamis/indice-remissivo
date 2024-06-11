package estruturas;

public class ListaPalavras {

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

    public ListaPalavras() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void add(String palavra) {
        Nodo novoNodo = new Nodo(palavra);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public int size(){
        return this.tamanho;
    }

    public String  get(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ListaPalavras.Nodo current = primeiro;
        for (int i = 0; i < index; i++) {
            current = current.proximo;
        }
        return current.palavra;
    }
}
