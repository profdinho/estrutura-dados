package br.com.profdinho.ordenacao;

public class SelectionSort {

    // Método para realizar o Selection Sort em um array
    public static void selectionSort(int[] array) {
        int n = array.length;

        // Percorre o array
        for (int i = 0; i < n - 1; i++) {
            // Encontra o menor elemento na parte não ordenada
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Troca o menor elemento com o primeiro elemento não ordenado
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
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
        int[] array = {29, 10, 14, 37, 13};

        System.out.println("Array original:");
        imprimirArray(array);

        // Chama o método selectionSort para ordenar o array
        selectionSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
