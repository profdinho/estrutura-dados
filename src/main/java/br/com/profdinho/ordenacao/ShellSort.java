package br.com.profdinho.ordenacao;

public class ShellSort {

    // Método para realizar o Shell Sort em um array
    public static void shellSort(int[] array) {
        int n = array.length;

        // Inicia o gap com metade do tamanho do array
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Realiza a ordenação parcial para cada gap
            for (int i = gap; i < n; i++) {
                // Armazena o valor atual em temp
                int temp = array[i];

                // Move os elementos do subarray que estão "gap" posições atrás
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Coloca o temp na posição correta
                array[j] = temp;
            }
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
        int[] array = {12, 34, 54, 2, 3};

        System.out.println("Array original:");
        imprimirArray(array);

        // Chama o método shellSort para ordenar o array
        shellSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}

