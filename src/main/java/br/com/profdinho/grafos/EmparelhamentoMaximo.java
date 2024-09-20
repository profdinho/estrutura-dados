package br.com.profdinho.grafos;

import java.util.LinkedList;

class EmparelhamentoMaximo {
    private int V;  // Número de vértices no grafo bipartido
    private int[][] grafo;

    public EmparelhamentoMaximo(int V) {
        this.V = V;
        grafo = new int[V][V];
    }

    public void adicionarAresta(int u, int v) {
        grafo[u][v] = 1;
    }

    private boolean bfs(int[] parU, int[] parV, boolean[] visitado) {
        LinkedList<Integer> fila = new LinkedList<>();
        for (int u = 0; u < V / 2; u++) {
            if (parU[u] == -1) {
                fila.add(u);
                visitado[u] = true;
            }
        }

        while (!fila.isEmpty()) {
            int u = fila.poll();
            for (int v = 0; v < V / 2; v++) {
                if (grafo[u][v] == 1 && !visitado[v]) {
                    visitado[v] = true;
                    if (parV[v] == -1 || bfs(parU, parV, visitado)) {
                        parU[u] = v;
                        parV[v] = u;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int emparelhamentoMaximo() {
        int[] parU = new int[V / 2];
        int[] parV = new int[V / 2];
        boolean[] visitado = new boolean[V / 2];

        for (int i = 0; i < V / 2; i++) {
            parU[i] = -1;
            parV[i] = -1;
        }

        int emparelhamento = 0;
        for (int u = 0; u < V / 2; u++) {
            if (parU[u] == -1) {
                for (int i = 0; i < visitado.length; i++) {
                    visitado[i] = false;
                }
                if (bfs(parU, parV, visitado)) {
                    emparelhamento++;
                }
            }
        }
        return emparelhamento;
    }
}



