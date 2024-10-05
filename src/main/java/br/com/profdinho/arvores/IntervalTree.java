package br.com.profdinho.arvores;

import java.util.ArrayList;
import java.util.List;

 public class IntervalTree {
    private IntervalNode root;

    public void insert(Interval interval) {
        root = insert(root, interval);
    }

    private IntervalNode insert(IntervalNode root, Interval interval) {
        if (root == null) {
            return new IntervalNode(interval);
        }

        if (interval.low < root.interval.low) {
            root.left = insert(root.left, interval);
        } else {
            root.right = insert(root.right, interval);
        }

        root.max = Math.max(root.max, interval.high);
        return root;
    }

    public List<Interval> searchOverlapping(Interval interval) {
        List<Interval> result = new ArrayList<>();
        searchOverlapping(root, interval, result);
        return result;
    }

    private void searchOverlapping(IntervalNode root, Interval interval, List<Interval> result) {
        if (root == null) {
            return;
        }

        if (doOverlap(root.interval, interval)) {
            result.add(root.interval);
        }

        if (root.left != null && root.left.max >= interval.low) {
            searchOverlapping(root.left, interval, result);
        }

        searchOverlapping(root.right, interval, result);
    }

    private boolean doOverlap(Interval i1, Interval i2) {
        return i1.low <= i2.high && i2.low <= i1.high;
    }

    public static void main(String[] args) {
        IntervalTree tree = new IntervalTree();
        tree.insert(new Interval(15, 20));
        tree.insert(new Interval(10, 30));
        tree.insert(new Interval(17, 19));
        tree.insert(new Interval(5, 20));
        tree.insert(new Interval(12, 15));
        tree.insert(new Interval(30, 40));

        Interval query = new Interval(14, 16);
        List<Interval> result = tree.searchOverlapping(query);
        System.out.println("Intervalos sobrepostos com " + query.low + ", " + query.high + ":");
        for (Interval interval : result) {
            System.out.println("[" + interval.low + ", " + interval.high + "]");
        }
    }
}

class Interval {
    int low, high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }
}

class IntervalNode {
    Interval interval;
    int max;
    IntervalNode left, right;

    public IntervalNode(Interval interval) {
        this.interval = interval;
        this.max = interval.high;
    }
}
