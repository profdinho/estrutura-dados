package br.com.profdinho.pilhas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaEstatica pilha = new PilhaEstatica();
        String texto;
        Integer numero;
        do {
            System.out.printf("Digite um número: ");
            texto = scanner.nextLine();
            if (!texto.isEmpty()) {
                numero = Integer.parseInt(texto);
                pilha.push(numero);
            }
        }
        while (!texto.isEmpty());
        //pilha.push(numero);
        scanner.close();
        System.out.println("O topo da pilha é " + pilha.peek() + " após " + pilha.size() + " inserções");
        while(!pilha.empty())
            System.out.println("O " + pilha.size() + "o. elemento inserido foi " + pilha.pop());
    }
}
