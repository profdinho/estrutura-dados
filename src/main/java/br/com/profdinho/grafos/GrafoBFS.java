package br.com.profdinho.grafos;

import java.util.*;

public class GrafoBFS {
    private Map<Integer, List<Integer>> adjList;

    public GrafoBFS() {
        adjList = new HashMap<>();
    }

    public void adicionarVertice(int vertice) {
        adjList.putIfAbsent(vertice, new ArrayList<>());
    }

    public void adicionarAresta(int vertice1, int vertice2) {
        adjList.get(vertice1).add(vertice2);
        adjList.get(vertice2).add(vertice1); // Grafo não direcionado
    }

    public void buscaEmLargura(int inicio) {
        Set<Integer> visitado = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();

        fila.add(inicio);
        visitado.add(inicio);

        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.print(vertice + " ");

            for (int vizinho : adjList.get(vertice)) {
                if (!visitado.contains(vizinho)) {
                    fila.add(vizinho);
                    visitado.add(vizinho);
                }
            }
        }
    }
}


