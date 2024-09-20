package br.com.profdinho.grafos;

public class MainEdmonds {
    public static void main(String[] args) {
        int vertices = 6; // Número de vértices no grafo
        EdmondsBlossom grafo = new EdmondsBlossom(vertices);

        // Adiciona arestas ao grafo
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 5);
        grafo.adicionarAresta(5, 0);

        // Calcula o emparelhamento máximo
        int emparelhamento = grafo.emparelhamentoMaximo();
        System.out.println("Emparelhamento máximo: " + emparelhamento);
    }
}
