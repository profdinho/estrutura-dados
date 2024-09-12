package br.com.profdinho.listas;

public class DoublyNode {
    Integer data;
    DoublyNode next;
    DoublyNode prev;

    // Construtor
    DoublyNode(Integer data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
