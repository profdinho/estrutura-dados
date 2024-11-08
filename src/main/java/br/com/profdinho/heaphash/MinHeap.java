package br.com.profdinho.heaphash;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Construtor para inicializar o heap com a capacidade especificada
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Métodos auxiliares para obter os índices do pai e dos filhos
    private int getParentIndex(int i) { return (i - 1) / 2; }
    private int getLeftChildIndex(int i) { return 2 * i + 1; }
    private int getRightChildIndex(int i) { return 2 * i + 2; }

    // Métodos para verificar a existência dos nós
    private boolean hasParent(int i) { return getParentIndex(i) >= 0; }
    private boolean hasLeftChild(int i) { return getLeftChildIndex(i) < size; }
    private boolean hasRightChild(int i) { return getRightChildIndex(i) < size; }

    // Métodos para acessar valores do pai e dos filhos
    private int parent(int i) { return heap[getParentIndex(i)]; }
    private int leftChild(int i) { return heap[getLeftChildIndex(i)]; }
    private int rightChild(int i) { return heap[getRightChildIndex(i)]; }

    // Método para garantir que há espaço suficiente no heap (redimensiona se necessário)
    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    // Inserção de um novo elemento no MinHeap
    public void insert(int value) {
        ensureCapacity();
        heap[size] = value; // Adiciona o novo valor no final do array
        size++;
        heapifyUp(size - 1); // Ajusta a posição do novo valor para manter o heap válido
    }

    // Método para remover o menor elemento (raiz do MinHeap)
    public int removeMin() {
        if (size == 0) throw new IllegalStateException("Heap vazio");
        int root = heap[0]; // Guarda o menor elemento (raiz)
        heap[0] = heap[size - 1]; // Substitui a raiz pelo último elemento
        size--;
        heapifyDown(0); // Ajusta o heap para manter a propriedade de MinHeap
        return root;
    }

    // Método para reorganizar o heap após inserção (subindo o elemento)
    private void heapifyUp(int index) {
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index); // Troca com o pai se o elemento atual for menor
            index = getParentIndex(index); // Sobe o índice
        }
    }

    // Método para reorganizar o heap após remoção (descendo o elemento)
    private void heapifyDown(int index) {
        while (hasLeftChild(index)) { // Garante que há pelo menos um filho
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index); // Escolhe o filho menor
            }

            if (heap[index] < heap[smallerChildIndex]) break; // Posiciona corretamente
            else swap(index, smallerChildIndex); // Troca com o filho menor

            index = smallerChildIndex; // Atualiza o índice para continuar descendo
        }
    }

    // Método auxiliar para trocar dois elementos no heap
    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    // Método para retornar o menor elemento sem removê-lo
    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap vazio");
        return heap[0];
    }

    // Método para exibir o heap como uma string
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, size));
    }

    // Main para testar o MinHeap
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(17);
        minHeap.insert(8);

        System.out.println("MinHeap: " + minHeap);
        System.out.println("Menor elemento (raiz): " + minHeap.peek());

        System.out.println("Removendo o menor elemento: " + minHeap.removeMin());
        System.out.println("MinHeap após remoção: " + minHeap);
    }
}

