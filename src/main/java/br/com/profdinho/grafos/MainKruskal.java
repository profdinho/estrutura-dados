package br.com.profdinho.grafos;

public class MainKruskal {
    public static void main(String[] args) {
        GrafoKruskal grafo = new GrafoKruskal(4);

        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 2, 6);
        grafo.adicionarAresta(0, 3, 5);
        grafo.adicionarAresta(1, 3, 15);
        grafo.adicionarAresta(2, 3, 4);

        grafo.kruskalMST();
    }
}
