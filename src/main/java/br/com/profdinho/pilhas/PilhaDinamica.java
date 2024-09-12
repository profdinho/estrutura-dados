package br.com.profdinho.pilhas;

public class PilhaDinamica {
    private Node top;
    private Integer size;

    public PilhaDinamica(){
        top = null;
        size = 0;
    }

    public void push(Integer e) {
        Node n = new Node(e,top);
        size ++;
        top = n;
    }

    public Integer pop(){
        Integer i = top.data;
        top = top.next;
        size--;
        return i;
    }

    public Integer peek(){
        return top.data;
    }

    public Integer size(){
        return size;
    }

    public boolean empty(){
        return top == null;
    }

}
