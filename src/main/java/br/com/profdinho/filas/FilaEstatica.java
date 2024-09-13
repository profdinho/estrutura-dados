package br.com.profdinho.filas;

public class FilaEstatica {

    static final int MAX = 10;

    private int inicio = 0, fim = 0 ;
    private final Integer[] vet = new Integer[MAX];

    void enqueue(FilaEstatica f, Integer v)
    {
        if (incr(f.fim) == f.inicio){ // fila cheia
            System.out.println("Capacidade da fila estourou");
            System.exit(1); //aborta o programa
        }
        // insere elemento na próxima posição livre
        f.vet[f.fim] = v;
        f.fim = incr(f.fim);
    }

    int incr (int i) {
        if (i == FilaEstatica.MAX - 1)
            return 0;
        else
            return i+1;
    }

    Integer dequeue(FilaEstatica f) {
        Integer v;
        if (vazia(f)) {
            System.out.println("Fila vazia.\n");
            System.exit(1); // aborta programa
        }
        //retira elemento no inicio
        v = f.vet[f.inicio];
        f.inicio = incr(f.inicio);
        return v;
    }

    boolean vazia (FilaEstatica f){
        return (f.inicio == f.fim);
    }

    void printQueue(FilaEstatica f){
        int i;
        for (i=f.inicio; i!=f.fim; i=incr(i)){
            System.out.println(f.vet[i]);
        }
    }

}
