package br.com.profdinho.grafos;

import java.util.LinkedList;

class GrafoFordFulkerson {
    private int V;  // Número de vértices
    private int[][] capacidade; // Matriz de capacidade

    public GrafoFordFulkerson(int V) {
        this.V = V;
        capacidade = new int[V][V];
    }

    public void adicionarAresta(int origem, int destino, int cap) {
        capacidade[origem][destino] = cap;
    }

    // BFS para encontrar caminho de aumento
    private boolean bfs(int[][] rCapacidade, int fonte, int sumidouro, int[] pai) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> fila = new LinkedList<>();
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
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Implementação do Algoritmo de Ford-Fulkerson
    public int fordFulkerson(int fonte, int sumidouro) {
        int u, v;

        // Cria uma matriz residual para armazenar capacidades residuais
        int[][] rCapacidade = new int[V][V];
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rCapacidade[u][v] = capacidade[u][v];
            }
        }

        int[] pai = new int[V];  // Armazena o caminho de aumento

        int fluxoMax = 0;  // Inicializa o fluxo máximo

        // Aumenta o fluxo enquanto houver um caminho de aumento
        while (bfs(rCapacidade, fonte, sumidouro, pai)) {
            // Encontra a capacidade residual mínima ao longo do caminho de aumento
            int fluxoCaminho = Integer.MAX_VALUE;
            for (v = sumidouro; v != fonte; v = pai[v]) {
                u = pai[v];
                fluxoCaminho = Math.min(fluxoCaminho, rCapacidade[u][v]);
            }

            // Atualiza as capacidades residuais das arestas e arestas reversas ao longo do caminho
            for (v = sumidouro; v != fonte; v = pai[v]) {
                u = pai[v];
                rCapacidade[u][v] -= fluxoCaminho;
                rCapacidade[v][u] += fluxoCaminho;
            }

            // Adiciona o fluxo do caminho ao fluxo total
            fluxoMax += fluxoCaminho;
        }

        return fluxoMax;
    }
}
