package br.com.profdinho.grafos;

import java.util.*;

public class GrafoKruskal {
    int vertices;
    List<Aresta> arestas;

    public GrafoKruskal(int vertices) {
        this.vertices = vertices;
        arestas = new ArrayList<>();
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        arestas.add(new Aresta(origem, destino, peso));
    }

    public int encontrar(int[] pai, int i) {
        if (pai[i] == -1) {
            return i;
        }
        return encontrar(pai, pai[i]);
    }

    public void unir(int[] pai, int x, int y) {
        int xSet = encontrar(pai, x);
        int ySet = encontrar(pai, y);
        pai[xSet] = ySet;
    }

    public void kruskalMST() {
        Collections.sort(arestas);

        int[] pai = new int[vertices];
        Arrays.fill(pai, -1);

        List<Aresta> mst = new ArrayList<>();
        int pesoTotal = 0;

        for (Aresta aresta : arestas) {
            int origemSet = encontrar(pai, aresta.origem);
            int destinoSet = encontrar(pai, aresta.destino);

            if (origemSet != destinoSet) {
                mst.add(aresta);
                pesoTotal += aresta.peso;
                unir(pai, origemSet, destinoSet);
            }
        }

        System.out.println("Arestas da MST:");
        for (Aresta aresta : mst) {
            System.out.println(aresta.origem + " -- " + aresta.destino + " == " + aresta.peso);
        }
        System.out.println("Peso total da MST: " + pesoTotal);
    }
}

class Aresta implements Comparable<Aresta> {
    int origem, destino, peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Aresta outra) {
        return this.peso - outra.peso;
    }
}