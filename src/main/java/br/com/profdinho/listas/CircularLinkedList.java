package br.com.profdinho.listas;

import java.util.Objects;

public class CircularLinkedList {
    private Node head;

    // Construtor
    CircularLinkedList() {
        this.head = null;
    }

    // Adicionar elemento ao final da lista
    public void add(Integer data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head; // Último nó aponta para o primeiro
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // Inserir elemento em uma posição específica
    public void insertAt(Integer index, Integer data) {
        if (index < 0) return; // Índice inválido

        Node newNode = new Node(data);

        // Caso especial: inserir no início (posição 0)
        if (index == 0) {
            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                Node tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                newNode.next = head;
                head = newNode;
                tail.next = head; // Atualiza o último nó para apontar para o novo head
            }
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current.next != head; i++) {
            current = current.next;
        }

        newNode.next = current.next;
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
                Node tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                head = head.next;
                tail.next = head; // Atualiza o último nó para apontar para o novo head
            }
            return;
        }

        Node current = head;
        while (current.next != head && !Objects.equals(current.next.data, data)) {
            current = current.next;
        }

        // Se o nó foi encontrado, removê-lo
        if (Objects.equals(current.next.data, data)) {
            current.next = current.next.next;
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
                Node tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current.next != head; i++) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
        }
    }

    // Exibir todos os elementos da lista (com um limite para evitar loops infinitos)
    public void printList() {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(volta ao início)");
    }
}
