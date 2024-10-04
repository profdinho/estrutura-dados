package br.com.profdinho.ordenacao;

public class MergeSort {

    // Método principal para executar o Merge Sort
    public static void mergeSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            // Encontra o meio do array
            int meio = (esquerda + direita) / 2;

            // Ordena a primeira e a segunda metade
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);

            // Mescla as duas metades
            merge(array, esquerda, meio, direita);
        }
    }

    // Função auxiliar para mesclar dois subarrays ordenados
    public static void merge(int[] array, int esquerda, int meio, int direita) {
        // Encontra o tamanho dos dois subarrays a serem mesclados
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        // Arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; ++i) {
            L[i] = array[esquerda + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[meio + 1 + j];
        }

        // Índices iniciais dos subarrays e do array mesclado
        int i = 0, j = 0;
        int k = esquerda;

        // Mescla os arrays temporários de volta no array original
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Função auxiliar para imprimir o array
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Método principal para testar o Merge Sort
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Array original:");
        imprimirArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
