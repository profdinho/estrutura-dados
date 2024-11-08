package br.com.profdinho.heaphash;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int i) { return (i - 1) / 2; }
    private int getLeftChildIndex(int i) { return 2 * i + 1; }
    private int getRightChildIndex(int i) { return 2 * i + 2; }

    public void insert(int value) {
        if (size == capacity) throw new IllegalStateException("Heap cheio");
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int removeMax() {
        if (size == 0) throw new IllegalStateException("Heap vazio");
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    private void heapifyUp(int index) {
        int temp = heap[index];
        while (index > 0 && temp > heap[getParentIndex(index)]) {
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }
        heap[index] = temp;
    }

    private void heapifyDown(int index) {
        int temp = heap[index];
        while (getLeftChildIndex(index) < size) {
            int largerChildIdx = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && heap[getRightChildIndex(index)] > heap[largerChildIdx]) {
                largerChildIdx = getRightChildIndex(index);
            }
            if (temp > heap[largerChildIdx]) break;
            heap[index] = heap[largerChildIdx];
            index = largerChildIdx;
        }
        heap[index] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, size));
    }
}
