package br.com.profdinho.grafos;

public class MainPrim {
    public static void main(String[] args) {
        GrafoPrim grafo = new GrafoPrim(4);

        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 2, 6);
        grafo.adicionarAresta(0, 3, 5);
        grafo.adicionarAresta(1, 3, 15);
        grafo.adicionarAresta(2, 3, 4);

        grafo.primMST();
    }
}
