package br.com.profdinho.grafos;

import java.util.Arrays;
import java.util.PriorityQueue;

class PotencialReduzido {
    private int V; // Número de vértices no grafo
    private int[][] capacidade; // Capacidade das arestas
    private int[][] custo; // Custo das arestas
    private int[] potencial; // Potencial de cada nó
    private int[][] fluxo; // Fluxo atual

    public PotencialReduzido(int V) {
        this.V = V;
        capacidade = new int[V][V];
        custo = new int[V][V];
        potencial = new int[V];
        fluxo = new int[V][V];
    }

    // Adiciona uma aresta com capacidade e custo
    public void adicionarAresta(int origem, int destino, int cap, int custoAresta) {
        capacidade[origem][destino] = cap;
        custo[origem][destino] = custoAresta;
        custo[destino][origem] = -custoAresta; // Custo inverso para o grafo residual
    }

    // Implementação do algoritmo de Potencial Reduzido
    public int fluxoCustoMinimo(int fonte, int sumidouro) {
        int fluxoTotal = 0;
        int custoTotal = 0;

        // Inicializa o fluxo e potencial
        while (true) {
            // Calcula o caminho de custo mínimo usando Dijkstra com potencial
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[fonte] = 0;

            int[] pai = new int[V];  // Armazena o caminho
            Arrays.fill(pai, -1);

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
            pq.add(fonte);

            while (!pq.isEmpty()) {
                int u = pq.poll();

                for (int v = 0; v < V; v++) {
                    if (capacidade[u][v] - fluxo[u][v] > 0) { // Verifica se há capacidade residual
                        int custoReduzido = custo[u][v] + potencial[u] - potencial[v];
                        if (dist[u] + custoReduzido < dist[v]) {
                            dist[v] = dist[u] + custoReduzido;
                            pai[v] = u;
                            pq.add(v);
                        }
                    }
                }
            }

            // Se não encontrou caminho até o sumidouro, termina
            if (dist[sumidouro] == Integer.MAX_VALUE) {
                break;
            }

            // Atualiza os potenciais
            for (int i = 0; i < V; i++) {
                if (dist[i] < Integer.MAX_VALUE) {
                    potencial[i] += dist[i];
                }
            }

            // Encontra a capacidade residual mínima no caminho encontrado
            int fluxoAumentar = Integer.MAX_VALUE;
            for (int v = sumidouro; v != fonte; v = pai[v]) {
                int u = pai[v];
                fluxoAumentar = Math.min(fluxoAumentar, capacidade[u][v] - fluxo[u][v]);
            }

            // Aumenta o fluxo e ajusta os custos
            for (int v = sumidouro; v != fonte; v = pai[v]) {
                int u = pai[v];
                fluxo[u][v] += fluxoAumentar;
                fluxo[v][u] -= fluxoAumentar;
                custoTotal += fluxoAumentar * custo[u][v];
            }

            fluxoTotal += fluxoAumentar;
        }

        System.out.println("Custo total do fluxo: " + custoTotal);
        return fluxoTotal;
    }
}
