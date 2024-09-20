package br.com.profdinho.grafos;

import java.util.*;

class EdmondsBlossom {
    private final int NIL = -1;
    private final int INF = Integer.MAX_VALUE;
    private int vertices;
    private List<Integer>[] grafo;
    private int[] match;  // Array de emparelhamento
    private int[] parent; // Array de pais para a floresta BFS
    private int[] base;   // Base dos vértices na floresta de árvores de busca
    private boolean[] blossom; // Marca os vértices que fazem parte de um "blossom"
    private boolean[] visited; // Marca os vértices visitados
    private Queue<Integer> queue; // Fila de vértices para BFS

    public EdmondsBlossom(int vertices) {
        this.vertices = vertices;
        grafo = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            grafo[i] = new ArrayList<>();
        }
        match = new int[vertices];
        Arrays.fill(match, NIL);
        parent = new int[vertices];
        base = new int[vertices];
        blossom = new boolean[vertices];
        visited = new boolean[vertices];
    }

    // Adiciona uma aresta não-direcionada ao grafo
    public void adicionarAresta(int u, int v) {
        grafo[u].add(v);
        grafo[v].add(u);
    }

    // Função para encontrar a base do vértice
    private int encontrarBase(int u) {
        if (base[u] == u) return u;
        return base[u] = encontrarBase(base[u]);
    }

    // Função para encontrar o LCA (Lowest Common Ancestor) de dois vértices
    private int encontrarLCA(int u, int v) {
        boolean[] marca = new boolean[vertices];
        while (true) {
            u = encontrarBase(u);
            marca[u] = true;
            if (match[u] == NIL) break;
            u = parent[match[u]];
        }
        while (true) {
            v = encontrarBase(v);
            if (marca[v]) return v;
            v = parent[match[v]];
        }
    }

    // Função para encolher um "blossom"
    private void encolher(int u, int v, int lca) {
        while (encontrarBase(u) != lca) {
            parent[u] = v;
            v = match[u];
            if (blossom[encontrarBase(v)]) continue;
            queue.add(v);
            blossom[encontrarBase(v)] = true;
            u = parent[v];
        }
    }

    // Função BFS para encontrar caminho aumentante
    private boolean bfs(int raiz) {
        Arrays.fill(parent, NIL);
        Arrays.fill(visited, false);
        for (int i = 0; i < vertices; i++) {
            base[i] = i;
        }

        queue = new LinkedList<>();
        queue.add(raiz);
        visited[raiz] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : grafo[u]) {
                if (encontrarBase(u) == encontrarBase(v) || match[u] == v) {
                    continue;
                }

                if (v == raiz || (match[v] != NIL && parent[match[v]] != NIL)) {
                    int lca = encontrarLCA(u, v);
                    encolher(u, v, lca);
                    encolher(v, u, lca);
                } else if (parent[v] == NIL) {
                    parent[v] = u;
                    if (match[v] == NIL) {
                        aumentar(v);
                        return true;
                    } else {
                        queue.add(match[v]);
                        blossom[encontrarBase(match[v])] = true;
                    }
                }
            }
        }
        return false;
    }

    // Função para aumentar o emparelhamento ao longo do caminho encontrado
    private void aumentar(int v) {
        while (v != NIL) {
            int u = parent[v];
            int nextV = match[u];
            match[u] = v;
            match[v] = u;
            v = nextV;
        }
    }

    // Função principal para encontrar o emparelhamento máximo
    public int emparelhamentoMaximo() {
        int emparelhamento = 0;
        for (int u = 0; u < vertices; u++) {
            if (match[u] == NIL && bfs(u)) {
                emparelhamento++;
            }
        }
        return emparelhamento;
    }
}
