package br.com.profdinho.busca;

import java.util.Arrays;

public class BuscaBinaria {

    public static int buscaBinaria(int[] array, int chave) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (array[meio] == chave) {
                return meio; // Retorna o índice da chave encontrada
            }

            if (chave < array[meio]) {
                fim = meio - 1; // Busca na metade esquerda
            } else {
                inicio = meio + 1; // Busca na metade direita
            }
        }
        return -1; // Retorna -1 se a chave não for encontrada
    }

    public static void main(String[] args) {
        int[] array = {9, 12, 15, 23, 30, 35};
        int chave = 23;

        int resultado = buscaBinaria(array, chave);
        if (resultado == -1) {
            System.out.println("Chave não encontrada.");
        } else {
            System.out.println("Chave encontrada no índice: " + resultado);
        }
    }
}
