package br.com.profdinho.grafos;

import java.util.Arrays;

class FluxoCustoMinimo {
    private static final int INF = Integer.MAX_VALUE;
    private int V;
    private int[][] capacidade;
    private int[][] custo;
    private int[] pai;
    private int[] dist;

    public FluxoCustoMinimo(int V) {
        this.V = V;
        capacidade = new int[V][V];
        custo = new int[V][V];
        pai = new int[V];
        dist = new int[V];
    }

    public void adicionarAresta(int origem, int destino, int cap, int cost) {
        capacidade[origem][destino] = cap;
        custo[origem][destino] = cost;
        custo[destino][origem] = -cost; // custo reverso
    }

    private boolean bellmanFord(int s, int t) {
        Arrays.fill(dist, INF);
        dist[s] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (capacidade[u][v] > 0 && dist[u] != INF && dist[u] + custo[u][v] < dist[v]) {
                        dist[v] = dist[u] + custo[u][v];
                        pai[v] = u;
                    }
                }
            }
        }

        return dist[t] != INF;
    }

    public int fluxoCustoMinimo(int fonte, int sumidouro) {
        int fluxoMax = 0, custoTotal = 0;

        while (bellmanFord(fonte, sumidouro)) {
            int fluxoCaminho = Integer.MAX_VALUE;

            for (int v = sumidouro; v != fonte; v = pai[v]) {
                int u = pai[v];
                fluxoCaminho = Math.min(fluxoCaminho, capacidade[u][v]);
            }

            for (int v = sumidouro; v != fonte; v = pai[v]) {
                int u = pai[v];
                capacidade[u][v] -= fluxoCaminho;
                capacidade[v][u] += fluxoCaminho;
                custoTotal += fluxoCaminho * custo[u][v];
            }

            fluxoMax += fluxoCaminho;
        }

        System.out.println("Custo total: " + custoTotal);
        return fluxoMax;
    }
}
