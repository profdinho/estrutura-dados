package br.com.profdinho.grafos;

public class MainPotencialReduzido {
    public static void main(String[] args) {
        PotencialReduzido grafo = new PotencialReduzido(5);

        // Adiciona as arestas (origem, destino, capacidade, custo)
        grafo.adicionarAresta(0, 1, 10, 5);
        grafo.adicionarAresta(0, 2, 5, 8);
        grafo.adicionarAresta(1, 2, 15, 3);
        grafo.adicionarAresta(1, 3, 10, 2);
        grafo.adicionarAresta(2, 4, 10, 7);
        grafo.adicionarAresta(3, 4, 10, 1);

        // Calcula o fluxo de custo mínimo entre o vértice 0 e o vértice 4
        int fluxoMaximo = grafo.fluxoCustoMinimo(0, 4);
        System.out.println("Fluxo máximo: " + fluxoMaximo);
    }
}
