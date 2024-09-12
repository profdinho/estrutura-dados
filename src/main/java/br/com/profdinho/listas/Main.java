package br.com.profdinho.listas;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("#### - Lista Ligada Simples - ####");

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Lista após adições:");
        list.printList();

        list.remove(20);
        System.out.println("Lista após remoção:");
        list.printList();

        list.insertAt(0, 20);
        System.out.println("Lista após inserção na posição 0:");
        list.printList();

        list.removeAt(1);
        System.out.println("Lista após a remoção na posição 1:");
        list.printList();

        /*
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("#### - Lista Duplamente Ligada - ####");

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Lista após adições:");
        list.printList();

        list.remove(20);
        System.out.println("Lista após remoção:");
        list.printList();
         */

        /*
        CircularLinkedList list = new CircularLinkedList();
        //System.out.println("#### - Lista Ligada Circular - ####");

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("#### - Lista Ligada Circular - ####");
        list.printList();
         */

        /*
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        //System.out.println("#### - Lista Duplamente Ligada Circular - ####");

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("#### - Lista Duplamente Ligada Circular - ####");
        list.printList();
         */

        /*
        SelfOrganizingList list = new SelfOrganizingList();
        System.out.println("#### - Lista Auto-Organizável - ####");

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Lista inicial:");
        list.printList();

        list.access(20); // Acessa o elemento 20
        System.out.println("Lista após acessar 20:");
        list.printList();

        list.access(30); // Acessa o elemento 30
        System.out.println("Lista após acessar 30:");
        list.printList();
         */
    }
}
