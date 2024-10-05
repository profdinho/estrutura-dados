package br.com.profdinho.arvores;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int data;
        Node left, right, parent;
        boolean color;

        Node(int data) {
            this.data = data;
            this.color = RED;
        }
    }

    private Node root;

    // Rotação à esquerda
    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.parent = node.parent;

        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }

        rightChild.left = node;
        node.parent = rightChild;
    }

    // Rotação à direita
    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.parent = node.parent;

        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }

        leftChild.right = node;
        node.parent = leftChild;
    }

    // Corrige as violações da árvore após inserção
    private void fixViolation(Node node) {
        Node parent = null;
        Node grandParent = null;

        while (node != root && node.color != BLACK && node.parent.color == RED) {
            parent = node.parent;
            grandParent = parent.parent;

            // Caso A: O pai do nó é filho à esquerda do avô
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;

                // Caso 1: O tio é vermelho (apenas recoloração)
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    // Caso 2: O nó é filho à direita (rotação à esquerda)
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    // Caso 3: O nó é filho à esquerda (rotação à direita)
                    rotateRight(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            } else { // Caso B: O pai do nó é filho à direita do avô
                Node uncle = grandParent.left;

                // Caso 1: O tio é vermelho (apenas recoloração)
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    // Caso 2: O nó é filho à esquerda (rotação à direita)
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    // Caso 3: O nó é filho à direita (rotação à esquerda)
                    rotateLeft(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
        }

        root.color = BLACK;
    }

    // Inserção de um novo nó
    public void insert(int data) {
        Node node = new Node(data);
        root = insertBST(root, node);
        fixViolation(node);
    }

    // Inserção padrão em uma árvore binária de busca
    private Node insertBST(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.data < root.data) {
            root.left = insertBST(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = insertBST(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    // Impressão da árvore em ordem
    public void inorder() {
        inorderHelper(root);
    }

    private void inorderHelper(Node root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.print(root.data + " ");
            inorderHelper(root.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);

        System.out.println("Árvore em ordem:");
        tree.inorder();
    }
}
