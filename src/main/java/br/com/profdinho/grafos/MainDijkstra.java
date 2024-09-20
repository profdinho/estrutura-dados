package br.com.profdinho.grafos;

public class MainDijkstra {
    public static void main(String[] args) {
        GrafoDijkstra grafo = new GrafoDijkstra();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);

        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(1, 3, 4);
        grafo.adicionarAresta(2, 3, 2);
        grafo.adicionarAresta(2, 4, 6);
        grafo.adicionarAresta(3, 4, 3);

        System.out.println("Menores distâncias com Dijkstra:");
        grafo.dijkstra(1);
    }
}
