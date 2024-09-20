package br.com.profdinho.grafos;

import java.util.LinkedList;
import java.util.Queue;

class EdmondsKarp {
    private int V;  // Número de vértices no grafo
    private int[][] capacidade;  // Matriz de capacidade das arestas

    public EdmondsKarp(int V) {
        this.V = V;
        capacidade = new int[V][V];
    }

    // Adiciona aresta com capacidade
    public void adicionarAresta(int origem, int destino, int cap) {
        capacidade[origem][destino] = cap;
    }

    // Implementa BFS para encontrar o caminho de aumento
    private boolean bfs(int[][] rCapacidade, int fonte, int sumidouro, int[] pai) {
        boolean[] visitado = new boolean[V];
        Queue<Integer> fila = new LinkedList<>();
        fila.add(fonte);
        visitado[fonte] = true;
        pai[fonte] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v = 0; v < V; v++) {
                if (!visitado[v] && rCapacidade[u][v] > 0) {
                    fila.add(v);
                    pai[v] = u;
                    visitado[v] = true;
                    if (v == sumidouro) {
                        return true;  // Encontramos um caminho até o sumidouro
                    }
                }
            }
        }

        return false;  // Não encontrou caminho de aumento
    }

    // Implementação do algoritmo de Edmonds-Karp
    public int edmondsKarp(int fonte, int sumidouro) {
        int[][] rCapacidade = new int[V][V];  // Matriz de capacidade residual

        // Inicializar a capacidade residual como a capacidade original
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                rCapacidade[u][v] = capacidade[u][v];
            }
        }

        int[] pai = new int[V];  // Array para armazenar o caminho de aumento
        int fluxoMaximo = 0;

        // Enquanto existir um caminho de aumento, adiciona o fluxo
        while (bfs(rCapacidade, fonte, sumidouro, pai)) {
            // Determina o fluxo máximo ao longo do caminho encontrado
            int fluxoCaminho = Integer.MAX_VALUE;
            for (int v = sumidouro; v != fonte; v = pai[v]) {
                int u = pai[v];
                fluxoCaminho = Math.min(fluxoCaminho, rCapacidade[u][v]);
            }

            // Atualiza a capacidade residual
            for (int v = sumidouro; v != fonte; v = pai[v]) {
                int u = pai[v];
                rCapacidade[u][v] -= fluxoCaminho;
                rCapacidade[v][u] += fluxoCaminho;
            }

            fluxoMaximo += fluxoCaminho;
        }

        return fluxoMaximo;
    }
}
