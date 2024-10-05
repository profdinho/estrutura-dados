package br.com.profdinho.arvores;

class BTree {
    private int T;

    class Node {
        int n;
        int[] keys;
        Node[] children;
        boolean leaf;

        public Node(boolean leaf) {
            this.leaf = leaf;
            keys = new int[2 * T - 1];
            children = new Node[2 * T];
            n = 0;
        }

        public void traverse() {
            int i;
            for (i = 0; i < this.n; i++) {
                if (!this.leaf) {
                    children[i].traverse();
                }
                System.out.print(" " + keys[i]);
            }

            if (!leaf) {
                children[i].traverse();
            }
        }

        public Node search(int key) {
            int i = 0;
            while (i < n && key > keys[i]) {
                i++;
            }

            if (keys[i] == key) {
                return this;
            }

            if (leaf) {
                return null;
            }

            return children[i].search(key);
        }
    }

    private Node root;

    public BTree(int T) {
        this.T = T;
        root = null;
    }

    public void traverse() {
        if (root != null) root.traverse();
    }

    public Node search(int k) {
        if (root == null) return null;
        return root.search(k);
    }
}
