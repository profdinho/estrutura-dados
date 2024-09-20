package br.com.profdinho.grafos;

public class MainEmparelhamentoMaximo {
    public static void main(String[] args) {
        EmparelhamentoMaximo grafo = new EmparelhamentoMaximo(6);

        // Adiciona arestas entre dois conjuntos
        grafo.adicionarAresta(0, 3);
        grafo.adicionarAresta(0, 4);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 5);

        System.out.println("Emparelhamento máximo: " + grafo.emparelhamentoMaximo());
    }
}
