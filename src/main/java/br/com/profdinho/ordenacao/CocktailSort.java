package br.com.profdinho.ordenacao;

public class CocktailSort {

    // Método para realizar o Cocktail Sort em um array
    public static void cocktailSort(int[] array) {
        boolean trocado = true;
        int inicio = 0;
        int fim = array.length - 1;

        // Continua enquanto houver trocas
        while (trocado) {
            trocado = false;

            // Percorre da esquerda para a direita
            for (int i = inicio; i < fim; i++) {
                if (array[i] > array[i + 1]) {
                    // Troca os elementos
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    trocado = true;
                }
            }

            // Se nenhuma troca foi feita, o array está ordenado
            if (!trocado) {
                break;
            }

            // Reseta o flag de trocas
            trocado = false;

            // Diminui o final, pois o maior elemento já está na posição correta
            fim--;

            // Percorre da direita para a esquerda
            for (int i = fim; i > inicio; i--) {
                if (array[i] < array[i - 1]) {
                    // Troca os elementos
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    trocado = true;
                }
            }

            // Incrementa o início, pois o menor elemento já está na posição correta
            inicio++;
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
        int[] array = {5, 1, 4, 2, 8, 0, 2};

        System.out.println("Array original:");
        imprimirArray(array);

        // Chama o método cocktailSort para ordenar o array
        cocktailSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
