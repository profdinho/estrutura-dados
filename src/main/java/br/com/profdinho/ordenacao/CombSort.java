package br.com.profdinho.ordenacao;

public class CombSort {

    // Método para realizar o Comb Sort em um array
    public static void combSort(int[] array) {
        int n = array.length;
        int gap = n; // Inicializa o gap como o tamanho do array
        double shrink = 1.3; // Fator de encolhimento recomendado
        boolean swapped = true;

        // Continua enquanto o gap for maior que 1 ou houver trocas
        while (gap > 1 || swapped) {
            // Reduz o gap
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1; // Se o gap ficar menor que 1, define como 1
            }

            swapped = false; // Reseta o flag de troca

            // Percorre o array com o gap atual
            for (int i = 0; i + gap < n; i++) {
                if (array[i] > array[i + gap]) {
                    // Troca os elementos
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true; // Marca que houve uma troca
                }
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
        int[] array = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};

        System.out.println("Array original:");
        imprimirArray(array);

        // Chama o método combSort para ordenar o array
        combSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
