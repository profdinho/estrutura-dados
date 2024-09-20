package br.com.profdinho.grafos;

public class MainFluxoCustoMinimo {
    public static void main(String[] args) {
        FluxoCustoMinimo grafo = new FluxoCustoMinimo(4);

        grafo.adicionarAresta(0, 1, 3, 1);
        grafo.adicionarAresta(0, 2, 2, 2);
        grafo.adicionarAresta(1, 2, 2, 1);
        grafo.adicionarAresta(1, 3, 2, 3);
        grafo.adicionarAresta(2, 3, 2, 1);

        System.out.println("Fluxo máximo: " + grafo.fluxoCustoMinimo(0, 3));
    }
}
