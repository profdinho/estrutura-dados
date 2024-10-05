package br.com.profdinho.busca;

public class BuscaInterpolacao {

    public static int buscaInterpolacao(int[] array, int chave) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim && chave >= array[inicio] && chave <= array[fim]) {
            if (inicio == fim) {
                if (array[inicio] == chave) {
                    return inicio;
                }
                return -1;
            }

            // Fórmula da interpolação
            int pos = inicio + ((chave - array[inicio]) * (fim - inicio)) / (array[fim] - array[inicio]);

            if (array[pos] == chave) {
                return pos; // Chave encontrada
            }

            if (array[pos] < chave) {
                inicio = pos + 1; // Busca na metade direita
            } else {
                fim = pos - 1; // Busca na metade esquerda
            }
        }

        return -1; // Chave não encontrada
    }

    public static void main(String[] args) {
        int[] array = {10, 12, 15, 20, 25, 30, 35, 40, 45};
        int chave = 25;

        int resultado = buscaInterpolacao(array, chave);
        if (resultado == -1) {
            System.out.println("Chave não encontrada.");
        } else {
            System.out.println("Chave encontrada no índice: " + resultado);
        }
    }
}
