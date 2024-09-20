package br.com.profdinho.grafos;

public class MainHopcroftKarp {
    public static void main(String[] args) {
        int U = 4, V = 4;  // Número de vértices nos subconjuntos U e V
        HopcroftKarp grafo = new HopcroftKarp(U, V);

        // Adiciona arestas entre o conjunto U e o conjunto V
        grafo.adicionarAresta(1, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 1);
        grafo.adicionarAresta(3, 3);
        grafo.adicionarAresta(4, 4);

        // Encontra o emparelhamento máximo
        System.out.println("Emparelhamento máximo: " + grafo.emparelhamentoMaximo());
    }
}
