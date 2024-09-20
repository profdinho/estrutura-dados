package br.com.profdinho.grafos;

import java.util.*;

public class GrafoDijkstra {
    private Map<Integer, List<Node>> adjList;

    public GrafoDijkstra() {
        adjList = new HashMap<>();
    }

    class Node implements Comparable<Node> {
        int vertice;
        int peso;

        Node(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }

        public int compareTo(Node outro) {
            return Integer.compare(this.peso, outro.peso);
        }
    }

    public void adicionarVertice(int vertice) {
        adjList.putIfAbsent(vertice, new ArrayList<>());
    }

    public void adicionarAresta(int vertice1, int vertice2, int peso) {
        adjList.get(vertice1).add(new Node(vertice2, peso));
        adjList.get(vertice2).add(new Node(vertice1, peso)); // Grafo não direcionado
    }

    public void dijkstra(int inicio) {
        Map<Integer, Integer> distancias = new HashMap<>();
        for (int vertice : adjList.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);

        PriorityQueue<Node> filaPrioridade = new PriorityQueue<>();
        filaPrioridade.add(new Node(inicio, 0));

        while (!filaPrioridade.isEmpty()) {
            Node atual = filaPrioridade.poll();

            for (Node vizinho : adjList.get(atual.vertice)) {
                int novaDistancia = distancias.get(atual.vertice) + vizinho.peso;
                if (novaDistancia < distancias.get(vizinho.vertice)) {
                    distancias.put(vizinho.vertice, novaDistancia);
                    filaPrioridade.add(new Node(vizinho.vertice, novaDistancia));
                }
            }
        }

        for (int vertice : distancias.keySet()) {
            System.out.println("Distância do vértice " + inicio + " até " + vertice + " é: " + distancias.get(vertice));
        }
    }
}
