package br.com.profdinho.grafos;

import java.util.*;

public class GrafoDFS {
    private Map<Integer, List<Integer>> adjList;

    public GrafoDFS() {
        adjList = new HashMap<>();
    }

    public void adicionarVertice(int vertice) {
        adjList.putIfAbsent(vertice, new ArrayList<>());
    }

    public void adicionarAresta(int vertice1, int vertice2) {
        adjList.get(vertice1).add(vertice2);
        adjList.get(vertice2).add(vertice1); // Grafo não direcionado
    }

    public void buscaEmProfundidade(int inicio) {
        Set<Integer> visitado = new HashSet<>();
        dfs(inicio, visitado);
    }

    private void dfs(int vertice, Set<Integer> visitado) {
        visitado.add(vertice);
        System.out.print(vertice + " ");

        for (int vizinho : adjList.get(vertice)) {
            if (!visitado.contains(vizinho)) {
                dfs(vizinho, visitado);
            }
        }
    }
}
