package br.com.profdinho.arvores;

class FenwickTree {
    private int[] BIT;
    private int n;

    public FenwickTree(int size) {
        this.n = size;
        this.BIT = new int[n + 1];
    }

    // Atualiza o valor no índice idx
    public void update(int idx, int delta) {
        while (idx <= n) {
            BIT[idx] += delta;
            idx += idx & -idx;
        }
    }

    // Consulta a soma de 1 até o índice idx
    public int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += BIT[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        FenwickTree fenwickTree = new FenwickTree(arr.length - 1);

        // Construir a árvore
        for (int i = 1; i < arr.length; i++) {
            fenwickTree.update(i, arr[i]);
        }

        // Consulta a soma até o índice 5
        System.out.println("Soma até o índice 5: " + fenwickTree.query(5));

        // Atualização do valor no índice 3
        fenwickTree.update(3, 3);
        System.out.println("Soma até o índice 5 após atualização: " + fenwickTree.query(5));
    }
}
