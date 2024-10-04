package br.com.profdinho.ordenacao;

public class QuickSort {

    // Função principal que executa o QuickSort
    public static void quickSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            // Particiona o array e obtém o índice do pivô
            int pi = partition(array, esquerda, direita);

            // Ordena as sublistas à esquerda e à direita do pivô
            quickSort(array, esquerda, pi - 1);
            quickSort(array, pi + 1, direita);
        }
    }

    // Função que realiza o particionamento
    public static int partition(int[] array, int esquerda, int direita) {
        int pivô = array[direita];  // Escolhe o último elemento como pivô
        int i = (esquerda - 1);     // Índice do menor elemento

        // Percorre o array e organiza os elementos em relação ao pivô
        for (int j = esquerda; j < direita; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (array[j] <= pivô) {
                i++;

                // Troca array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Troca array[i + 1] e array[direita] (ou o pivô)
        int temp = array[i + 1];
        array[i + 1] = array[direita];
        array[direita] = temp;

        // Retorna o índice do pivô
        return i + 1;
    }

    // Função auxiliar para imprimir o array
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Método principal para testar o QuickSort
    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};

        System.out.println("Array original:");
        imprimirArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}
