package br.com.profdinho.arvores;

import java.util.ArrayList;
import java.util.List;

 public class RTree {
    RTreeNode root;

    public RTree() {
        root = new RTreeNode();
    }

    public void insert(Rectangle rect) {
        root.insert(rect);
    }

    public List<Rectangle> search(Rectangle query) {
        return root.search(query);
    }

    public static void main(String[] args) {
        RTree rTree = new RTree();
        rTree.insert(new Rectangle(0, 0, 10, 10));
        rTree.insert(new Rectangle(5, 5, 15, 15));
        rTree.insert(new Rectangle(10, 10, 20, 20));

        Rectangle query = new Rectangle(7, 7, 12, 12);
        List<Rectangle> result = rTree.search(query);
        System.out.println("Retângulos que intersectam com o retângulo de consulta:");
        for (Rectangle rect : result) {
            System.out.println("[" + rect.x1 + ", " + rect.y1 + ", " + rect.x2 + ", " + rect.y2 + "]");
        }
    }
}

class Rectangle {
    int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean intersects(Rectangle other) {
        return !(other.x1 > x2 || other.x2 < x1 || other.y1 > y2 || other.y2 < y1);
    }
}

class RTreeNode {
    List<Rectangle> rectangles;
    List<RTreeNode> children;

    public RTreeNode() {
        this.rectangles = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void insert(Rectangle rect) {
        if (children.isEmpty()) {
            rectangles.add(rect);
        } else {
            // Inserir em um dos nós filhos (logicamente deveria expandir)
            children.get(0).insert(rect);
        }
    }

    public List<Rectangle> search(Rectangle query) {
        List<Rectangle> result = new ArrayList<>();
        for (Rectangle rect : rectangles) {
            if (rect.intersects(query)) {
                result.add(rect);
            }
        }
        for (RTreeNode child : children) {
            result.addAll(child.search(query));
        }
        return result;
    }
}
