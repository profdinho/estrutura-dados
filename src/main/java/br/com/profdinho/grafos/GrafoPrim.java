package br.com.profdinho.grafos;

import java.util.*;

public class GrafoPrim {
    private int vertices;
    private List<List<Node>> adjList;

    class Node implements Comparable<Node> {
        int vertice, peso;

        Node(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }

        @Override
        public int compareTo(Node outro) {
            return this.peso - outro.peso;
        }
    }

    public GrafoPrim(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        adjList.get(origem).add(new Node(destino, peso));
        adjList.get(destino).add(new Node(origem, peso)); // Grafo não direcionado
    }

    public void primMST() {
        boolean[] naMST = new boolean[vertices];
        PriorityQueue<Node> filaPrioridade = new PriorityQueue<>();
        filaPrioridade.add(new Node(0, 0));
        int pesoTotal = 0;

        while (!filaPrioridade.isEmpty()) {
            Node node = filaPrioridade.poll();
            int vertice = node.vertice;

            if (naMST[vertice]) continue;

            naMST[vertice] = true;
            pesoTotal += node.peso;

            for (Node vizinho : adjList.get(vertice)) {
                if (!naMST[vizinho.vertice]) {
                    filaPrioridade.add(new Node(vizinho.vertice, vizinho.peso));
                }
            }
        }

        System.out.println("Peso total da MST: " + pesoTotal);
    }
}
