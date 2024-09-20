package br.com.profdinho.grafos;

import java.util.LinkedList;

class CorteMinimo {
    private int V;  // Número de vértices no grafo
    private int[][] capacidade;  // Matriz de capacidade das arestas

    public CorteMinimo(int V) {
        this.V = V;
        capacidade = new int[V][V];
    }

    // Adiciona aresta com capacidade
    public void adicionarAresta(int origem, int destino, int cap) {
        capacidade[origem][destino] = cap;
    }

    // BFS para encontrar caminhos de aumento
    private boolean bfs(int[][] rCapacidade, int s, int t, int[] pai) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> fila = new LinkedList<>();
        fila.add(s);
        visitado[s] = true;
        pai[s] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v = 0; v < V; v++) {
                if (!visitado[v] && rCapacidade[u][v] > 0) {
                    fila.add(v);
                    pai[v] = u;
                    visitado[v] = true;
                    if (v == t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Implementação do Algoritmo de Ford-Fulkerson para Fluxo Máximo
    public int fordFulkerson(int fonte, int sumidouro) {
        int u, v;
        int[][] rCapacidade = new int[V][V]; // Matriz de capacidade residual

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rCapacidade[u][v] = capacidade[u][v];
            }
        }

        int[] pai = new int[V];  // Armazena o caminho de aumento
        int fluxoMax = 0;

        // Aumenta o fluxo enquanto houver caminho de aumento
        while (bfs(rCapacidade, fonte, sumidouro, pai)) {
            int fluxoCaminho = Integer.MAX_VALUE;
            for (v = sumidouro; v != fonte; v = pai[v]) {
                u = pai[v];
                fluxoCaminho = Math.min(fluxoCaminho, rCapacidade[u][v]);
            }

            for (v = sumidouro; v != fonte; v = pai[v]) {
                u = pai[v];
                rCapacidade[u][v] -= fluxoCaminho;
                rCapacidade[v][u] += fluxoCaminho;
            }

            fluxoMax += fluxoCaminho;
        }

        // Determina o corte mínimo
        boolean[] visitado = new boolean[V];
        bfs(rCapacidade, fonte, sumidouro, pai);

        System.out.println("As arestas no corte mínimo são:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (visitado[i] && !visitado[j] && capacidade[i][j] > 0) {
                    System.out.println(i + " -> " + j);
                }
            }
        }

        return fluxoMax;
    }
}
