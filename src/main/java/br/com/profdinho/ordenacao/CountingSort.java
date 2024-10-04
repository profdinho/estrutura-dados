package br.com.profdinho.ordenacao;

import java.util.Arrays;

public class CountingSort {

    // Função que implementa o Counting Sort
    public static void countingSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();  // Encontra o valor máximo no array
        int min = Arrays.stream(array).min().getAsInt();  // Encontra o valor mínimo no array
        int range = max - min + 1;  // Determina o intervalo dos valores no array

        // Array de contagem
        int[] count = new int[range];
        Arrays.fill(count, 0);  // Inicializa o array de contagem com 0

        // Array de saída que conterá o array ordenado
        int[] output = new int[array.length];

        // Conta o número de ocorrências de cada elemento
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;  // Subtrai min para alinhar os valores com o índice 0
        }

        // Modifica o array de contagem para acumular as contagens
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída colocando os elementos na posição correta
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copia os elementos ordenados para o array original
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    // Função auxiliar para imprimir o array
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Método principal para testar o Counting Sort
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Array original:");
        imprimirArray(array);

        countingSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
