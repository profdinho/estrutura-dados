package br.com.profdinho.arvores;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Método de inserção
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Função recursiva para inserir uma nova chave na árvore
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Método de busca
    boolean search(int key) {
        return searchRec(root, key) != null;
    }

    // Função recursiva para buscar uma chave na árvore
    Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // Percurso em in-ordem
    void inorder() {
        inorderRec(root);
    }

    // Função recursiva para fazer o percurso in-ordem
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Método principal para testar a árvore
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Inserindo nós na árvore */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Exibe a árvore em in-ordem (elementos ordenados)
        System.out.println("Percurso in-ordem da árvore:");
        tree.inorder();

        // Busca por um elemento
        int key = 40;
        if (tree.search(key))
            System.out.println("\nO elemento " + key + " foi encontrado.");
        else
            System.out.println("\nO elemento " + key + " não foi encontrado.");
    }
}
