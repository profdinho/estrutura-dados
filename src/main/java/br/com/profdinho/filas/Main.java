package br.com.profdinho.filas;

public class Main {
    public static void main(String[] args){

        FilaEstatica f = new FilaEstatica();
        f.enqueue(f,10);
        f.enqueue(f,20);
        f.enqueue(f,30);
        f.enqueue(f,40);
        f.printQueue(f);
        System.out.println("\n Primeiro elemento: " + f.dequeue(f));
        System.out.println("\n Segundo elemento: " + f.dequeue(f));
        System.out.println("\n Configuracao da fila:");
        f.printQueue(f);
        f = null;
    }

}
