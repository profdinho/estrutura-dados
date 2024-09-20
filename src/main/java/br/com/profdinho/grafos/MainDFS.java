package br.com.profdinho.grafos;

public class MainDFS {
    public static void main(String[] args) {
        GrafoDFS grafo = new GrafoDFS();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);

        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(2, 5);

        System.out.println("Busca em Profundidade (DFS):");
        grafo.buscaEmProfundidade(1);
    }
}