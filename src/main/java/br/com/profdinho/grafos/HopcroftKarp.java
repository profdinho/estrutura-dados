package br.com.profdinho.grafos;

import java.util.LinkedList;
import java.util.Queue;

class HopcroftKarp {
    private final int NIL = 0;  // Nó nil (representa ausência de emparelhamento)
    private final int INF = Integer.MAX_VALUE;  // Infinito (para comparação)

    private int U, V;  // Número de vértices nos dois subconjuntos
    private int[][] grafo;  // Grafo bipartido representado por uma lista de adjacências

    private int[] parU, parV;  // Arrays de emparelhamento para U e V
    private int[] dist;  // Array de distâncias usado no BFS

    public HopcroftKarp(int U, int V) {
        this.U = U;  // Número de vértices no subconjunto U
        this.V = V;  // Número de vértices no subconjunto V
        grafo = new int[U + 1][V + 1];  // Grafo bipartido
        parU = new int[U + 1];  // Emparelhamento de U
        parV = new int[V + 1];  // Emparelhamento de V
        dist = new int[U + 1];  // Distâncias
    }

    // Adiciona aresta entre um vértice u de U e v de V
    public void adicionarAresta(int u, int v) {
        grafo[u][v] = 1;  // Define que u está conectado a v
    }

    // BFS para construir a camada de níveis (níveis alternados)
    private boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // Inicializa todos os vértices de U não emparelhados
        for (int u = 1; u <= U; u++) {
            if (parU[u] == NIL) {
                dist[u] = 0;
                queue.add(u);
            } else {
                dist[u] = INF;
            }
        }

        dist[NIL] = INF;

        // BFS para encontrar o caminho de aumento mais curto
        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (dist[u] < dist[NIL]) {
                for (int v = 1; v <= V; v++) {
                    if (grafo[u][v] == 1) {  // Há uma aresta de u para v
                        if (dist[parV[v]] == INF) {
                            dist[parV[v]] = dist[u] + 1;
                            queue.add(parV[v]);
                        }
                    }
                }
            }
        }

        return dist[NIL] != INF;  // Retorna verdadeiro se houver caminho de aumento
    }

    // DFS para buscar caminhos de aumento (recursivamente)
    private boolean dfs(int u) {
        if (u != NIL) {
            for (int v = 1; v <= V; v++) {
                if (grafo[u][v] == 1 && dist[parV[v]] == dist[u] + 1) {
                    if (dfs(parV[v])) {
                        parU[u] = v;
                        parV[v] = u;
                        return true;
                    }
                }
            }

            dist[u] = INF;
            return false;
        }

        return true;
    }

    // Algoritmo de Hopcroft-Karp para encontrar o emparelhamento máximo
    public int emparelhamentoMaximo() {
        // Inicializa o emparelhamento de todos os vértices como NIL
        for (int u = 0; u <= U; u++) parU[u] = NIL;
        for (int v = 0; v <= V; v++) parV[v] = NIL;

        int emparelhamento = 0;

        // Enquanto houver caminho de aumento, aumente o emparelhamento
        while (bfs()) {
            for (int u = 1; u <= U; u++) {
                if (parU[u] == NIL && dfs(u)) {
                    emparelhamento++;
                }
            }
        }

        return emparelhamento;
    }
}
