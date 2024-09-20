package br.com.profdinho.grafos;

public class MainCaminhoMinimo {
    public static void main(String[] args) {
        CaminhoMinimo grafo = new CaminhoMinimo(5);

        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 4, 3);
        grafo.adicionarAresta(1, 2, 2);
        grafo.adicionarAresta(2, 3, 9);
        grafo.adicionarAresta(4, 1, 4);
        grafo.adicionarAresta(4, 2, 8);

        grafo.dijkstra(0);
    }
}
