package estruturas;
public class ListaOcorrencias {
    private static class Nodo {
        public int valor;
        public Nodo proximo;
        public Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
    private Nodo primeiro;
    private Nodo ultimo;
    private int tamanho;

    public ListaOcorrencias() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    public void add(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (ultimo == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public int size(){
        return this.tamanho;
    }

    public int get(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Nodo current = primeiro;
        for (int i = 0; i < index; i++) {
            current = current.proximo;
        }
        return current.valor;
    }
}
