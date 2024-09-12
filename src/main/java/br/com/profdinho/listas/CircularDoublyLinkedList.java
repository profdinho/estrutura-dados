package br.com.profdinho.listas;

import java.util.Objects;

public class CircularDoublyLinkedList {
    private DoublyNode head;

    // Construtor
    CircularDoublyLinkedList() {
        this.head = null;
    }

    // Adicionar elemento ao final da lista
    public void add(Integer data) {
        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            DoublyNode last = head.prev;

            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Inserir elemento em uma posição específica
    public void insertAt(Integer index, Integer data) {
        if (index < 0) return; // Índice inválido

        DoublyNode newNode = new DoublyNode(data);

        // Caso especial: inserir no início (posição 0)
        if (index == 0) {
            if (head == null) {
                head = newNode;
                newNode.next = head;
                newNode.prev = head;
            } else {
                DoublyNode last = head.prev;

                newNode.next = head;
                newNode.prev = last;
                head.prev = newNode;
                last.next = newNode;
                head = newNode;
            }
            return;
        }

        DoublyNode current = head;
        for (int i = 0; i < index - 1 && current.next != head; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

    // Remover um elemento da lista
    public void remove(Integer data) {
        if (head == null) return; // Lista vazia

        // Caso especial: remoção do head
        if (Objects.equals(head.data, data)) {
            if (head.next == head) {
                head = null; // Lista só tinha um elemento
            } else {
                DoublyNode last = head.prev;
                head = head.next;
                head.prev = last;
                last.next = head;
            }
            return;
        }

        DoublyNode current = head;
        while (current.next != head && !Objects.equals(current.data, data)) {
            current = current.next;
        }

        if (Objects.equals(current.data, data)) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Remover elemento de uma posição específica
    public void removeAt(Integer index) {
        if (index < 0 || head == null) return; // Índice inválido ou lista vazia

        // Caso especial: remoção do primeiro elemento (índice 0)
        if (index == 0) {
            if (head.next == head) { // Único elemento na lista
                head = null;
            } else {
                DoublyNode last = head.prev;
                head = head.next;
                head.prev = last;
                last.next = head;
            }
            return;
        }

        DoublyNode current = head;
        for (int i = 0; i < index - 1 && current.next != head; i++) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
            current.next.prev = current;
        }
    }

    // Exibir todos os elementos da lista (com um limite para evitar loops infinitos)
    public void printList() {
        if (head == null) return;

        DoublyNode current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(volta ao início)");
    }
}
