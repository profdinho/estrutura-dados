package br.com.profdinho.listas;

import java.util.Objects;

public class SinglyLinkedList {
    private Node head;

    // Construtor
    SinglyLinkedList() {
        this.head = null;
    }

    // Adicionar elemento no final da lista
    public void add(Integer data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Inserir elemento em uma posição específica
    public void insertAt(Integer index, Integer data) {
        if (index < 0) return; // Índice inválido

        Node newNode = new Node(data);

        // Caso especial: inserir no início (posição 0)
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        // Se a posição é válida, inserimos o nó
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remover elemento da lista
    public void remove(Integer data) {
        if (head == null) return;

        if (Objects.equals(head.data, data)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !Objects.equals(current.next.data, data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Remover elemento de uma posição específica
    public void removeAt(Integer index) {
        if (index < 0 || head == null) return; // Índice inválido ou lista vazia

        // Caso especial: remoção do primeiro elemento (índice 0)
        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }

        // Se a posição é válida, removemos o nó
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Exibir todos os elementos da lista
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
