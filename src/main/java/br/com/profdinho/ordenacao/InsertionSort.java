package br.com.profdinho.ordenacao;

public class InsertionSort {

    // Método para realizar o Insertion Sort em um array
    public static void insertionSort(int[] array) {
        int n = array.length;

        // Percorre o array a partir do segundo elemento
        for (int i = 1; i < n; i++) {
            // Armazena o valor da "chave" que será inserido na posição correta
            int chave = array[i];
            int j = i - 1;

            // Move os elementos da sublista ordenada que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            // Insere a chave na posição correta
            array[j + 1] = chave;
        }
    }

    // Método auxiliar para imprimir o array
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3};

        System.out.println("Array original:");
        imprimirArray(array);

        // Chama o método insertionSort para ordenar o array
        insertionSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
