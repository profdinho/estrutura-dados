package br.com.profdinho.arvores;

public class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[2 * n];
        build(arr);
    }

    // Constrói a Segment Tree
    public void build(int[] arr) {
        // Copia os elementos do array original para as folhas da árvore
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }

        // Constrói a árvore
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // Consulta a soma no intervalo [l, r)
    public int query(int l, int r) {
        int sum = 0;
        l += n;
        r += n;

        while (l < r) {
            if ((l & 1) == 1) {
                sum += tree[l++];
            }
            if ((r & 1) == 1) {
                sum += tree[--r];
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    // Atualiza um valor no índice pos
    public void update(int pos, int value) {
        pos += n;
        tree[pos] = value;

        while (pos > 1) {
            pos /= 2;
            tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr);
        System.out.println("Soma entre índices 1 e 3: " + segTree.query(1, 3));
        segTree.update(1, 10);
        System.out.println("Soma entre índices 1 e 3 após atualização: " + segTree.query(1, 3));
    }
}
