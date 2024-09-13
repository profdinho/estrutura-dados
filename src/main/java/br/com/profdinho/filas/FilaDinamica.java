package br.com.profdinho.filas;

public class FilaDinamica {
    private Node front; // mais recente
    private Node back;  // mais antigo
    private Integer size;

    public void enqueue(Integer item) {
        if (front == null) // fila vazia
        {   front = new Node();
            front.item = item;
            back = front;
        } else
        {   Node newNode = new Node();
            newNode.item = item;
            back.next = newNode;
            back = newNode;
        }
        this.size++;
    }

    public Integer dequeue() {
        Integer i = front.item;
        front  = front.next;
        size--;

        return i;
    }

}
