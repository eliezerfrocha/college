package model;

public class Vetor<T> {
    private T[] vet;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int tamanho) {
        this.tamanho = tamanho;
        this.vet = (T[]) new Object[tamanho];
    }

    public void setElemento(int indice, T elemento) {
        if (indice >= 0 && indice < tamanho) {
            vet[indice] = elemento;
        } else {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
    }

    public T getElemento(int indice) {
        if (indice >= 0 && indice < tamanho) {
            return vet[indice];
        } else {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void adicionar(T elemento) {
        if (tamanho == vet.length) {
            redimensionar();
        }
        vet[tamanho++] = elemento;
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        int novaCapacidade = vet.length * 2;
        T[] novoVetor = (T[]) new Object[novaCapacidade];
        for (int i = 0; i < vet.length; i++) {
            novoVetor[i] = vet[i];
        }
        vet = novoVetor;
    }
}
