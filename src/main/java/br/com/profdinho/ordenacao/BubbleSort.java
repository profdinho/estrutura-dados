package br.com.profdinho.ordenacao;

public class BubbleSort {

    // Método para realizar o Bubble Sort em um array
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean trocou;

        // Passa por cada elemento do array
        for (int i = 0; i < n - 1; i++) {
            trocou = false;

            // Loop interno para comparar e trocar elementos adjacentes
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocou = true;
                }
            }

            // Se não houve nenhuma troca na passagem, o array já está ordenado
            if (!trocou) {
                break;
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
        int[] array = {5, 1, 4, 2, 8};

        System.out.println("Array original:");
        imprimirArray(array);

        // Chama o método bubbleSort para ordenar o array
        bubbleSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
