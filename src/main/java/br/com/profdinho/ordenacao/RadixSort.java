package br.com.profdinho.ordenacao;

import java.util.Arrays;

public class RadixSort {

    // Função principal para implementar o Radix Sort
    public static void radixSort(int[] array) {
        // Encontra o número máximo para saber quantos dígitos ele tem
        int max = Arrays.stream(array).max().getAsInt();

        // Aplica Counting Sort para cada dígito, começando do dígito menos significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    // Função que realiza o Counting Sort baseado no dígito exp (1, 10, 100, ...)
    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];  // Array de saída
        int[] count = new int[10];  // Array de contagem para os dígitos (0-9)

        // Inicializa o array de contagem com 0
        Arrays.fill(count, 0);

        // Conta as ocorrências dos dígitos correspondentes (exp é o divisor para obter o dígito)
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        // Modifica o array de contagem para acumular as posições
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída com base nos dígitos ordenados
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copia o array de saída de volta para o array original
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Função auxiliar para imprimir o array
    public static void imprimirArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Método principal para testar o Radix Sort
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Array original:");
        imprimirArray(array);

        radixSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
