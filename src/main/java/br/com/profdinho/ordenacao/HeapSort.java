package br.com.profdinho.ordenacao;

public class HeapSort {

    // Método principal que realiza o Heap Sort
    public void sort(int[] array) {
        int n = array.length;

        // Constrói o max-heap (reorganiza o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrai um a um os elementos do heap
        for (int i = n - 1; i >= 0; i--) {
            // Move a raiz atual (maior elemento) para o final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama heapify na heap reduzida
            heapify(array, i, 0);
        }
    }

    // Função para ajustar a sub-árvore com a raiz em i
    void heapify(int[] array, int n, int i) {
        int maior = i;  // Inicializa o maior como a raiz
        int esquerda = 2 * i + 1;  // Filho esquerdo
        int direita = 2 * i + 2;   // Filho direito

        // Se o filho esquerdo for maior que a raiz
        if (esquerda < n && array[esquerda] > array[maior]) {
            maior = esquerda;
        }

        // Se o filho direito for maior que o maior até agora
        if (direita < n && array[direita] > array[maior]) {
            maior = direita;
        }

        // Se o maior não for a raiz
        if (maior != i) {
            int troca = array[i];
            array[i] = array[maior];
            array[maior] = troca;

            // Recursivamente aplica heapify na sub-árvore afetada
            heapify(array, n, maior);
        }
    }

    // Método auxiliar para imprimir o array
    static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        HeapSort heapSort = new HeapSort();

        System.out.println("Array original:");
        imprimirArray(array);

        heapSort.sort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
