package br.com.profdinho.listas;

import java.util.Objects;

public class DoublyLinkedList {
    private DoublyNode head;

    // Construtor
    DoublyLinkedList() {
        this.head = null;
    }

    // Adicionar elemento no final da lista
    public void add(Integer data) {
        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            head = newNode;
        } else {
            DoublyNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Remover elemento da lista
    public void remove(Integer data) {
        if (head == null) return;

        if (Objects.equals(head.data, data)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        DoublyNode current = head;
        while (current.next != null && !Objects.equals(current.data, data)) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    // Exibir todos os elementos da lista
    public void printList() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
