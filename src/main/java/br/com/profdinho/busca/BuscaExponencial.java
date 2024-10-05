package br.com.profdinho.busca;

import java.util.Arrays;

public class BuscaExponencial {

    public static int buscaExponencial(int[] array, int chave) {
        if (array[0] == chave) {
            return 0; // Se a chave está no primeiro elemento
        }

        int i = 1;
        // Dobra o intervalo exponencialmente até encontrar um valor maior ou igual à chave
        while (i < array.length && array[i] <= chave) {
            i = i * 2;
        }

        // Chama a busca binária no intervalo encontrado
        return Arrays.binarySearch(array, i / 2, Math.min(i, array.length), chave);
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40, 50, 80, 100, 120, 130, 140};
        int chave = 40;

        int resultado = buscaExponencial(array, chave);
        if (resultado < 0) {
            System.out.println("Chave não encontrada.");
        } else {
            System.out.println("Chave encontrada no índice: " + resultado);
        }
    }
}
