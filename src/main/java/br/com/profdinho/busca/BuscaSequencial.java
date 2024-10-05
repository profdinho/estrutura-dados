package br.com.profdinho.busca;

public class BuscaSequencial {

    public static int buscaSequencial(int[] array, int chave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chave) {
                return i; // Retorna o índice da chave encontrada
            }
        }
        return -1; // Retorna -1 se a chave não for encontrada
    }

    public static void main(String[] args) {
        int[] array = {10, 23, 15, 9, 30, 12};
        int chave = 15;

        int resultado = buscaSequencial(array, chave);
        if (resultado == -1) {
            System.out.println("Chave não encontrada.");
        } else {
            System.out.println("Chave encontrada no índice: " + resultado);
        }
    }
}

