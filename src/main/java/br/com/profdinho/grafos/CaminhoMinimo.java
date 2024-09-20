package br.com.profdinho.grafos;

import java.util.PriorityQueue;
import java.util.Arrays;

class CaminhoMinimo {
    private int V;
    private int[][] grafo;

    public CaminhoMinimo(int V) {
        this.V = V;
        grafo = new int[V][V];
        for (int[] row : grafo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        grafo[origem][destino] = peso;
    }

    public void dijkstra(int origem) {
        int[] dist = new int[V];
        boolean[] visitado = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origem] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        pq.add(origem);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            if (visitado[u]) {
                continue;
            }

            visitado[u] = true;

            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != Integer.MAX_VALUE && !visitado[v] && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                    pq.add(v);
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vértice " + i + " : " + dist[i]);
        }
    }
}



